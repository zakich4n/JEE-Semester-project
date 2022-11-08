package project.spotEEfy.web.API;


import project.spotEEfy.web.controller.RestController;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Named
@Path("/callback")
public class CallbackAPI implements RestController {

    @GET
    @Path("/response/access_token={payload}")
    public Response.ResponseBuilder getAuthToken(@PathParam("payload") String payload){
        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL("https://api.spotify.com/v1/me");
            System.out.println("Access token: " + payload );
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer "+ payload);
            con.connect();
            responseBody.append(con.getResponseMessage());
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.TEMPORARY_REDIRECT).location(URI.create("http://localhost:8080/api/account_details"));

    }

    @GET
    @Path("/response/error={payload}")
    public Response redirectError(@PathParam("payload") String payload){
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
