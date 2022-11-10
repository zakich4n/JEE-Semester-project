package project.spotEEfy.web.API;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.spotEEfy.web.controller.RestController;

import javax.inject.Named;
import javax.management.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Named
@Controller
@Path("/")
public class CallbackAPI  {

    private final static Logger log = LoggerFactory.getLogger(CallbackAPI.class);

    /*
    @GET
    @Path("/")
    public String getAuthToken(@PathParam("response") String response){
        String accessToken = "test";

        log.warn("we are in : " + accessToken);
        log.warn("response "+ response);
        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL("https://api.spotify.com/v1/me");

            log.warn("Access token: " + accessToken);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer "+ accessToken);
            con.connect();
            responseBody.append(con.getResponseMessage());
            log.warn(String.valueOf(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return Response.status(Response.Status.TEMPORARY_REDIRECT).location(URI.create("http://localhost:8080/SpotEEfy_core_war_exploded/api/account_details"));
        return "login";
    }

     */

    @GET
    @Path("/response/error={payload}")
    public Response redirectError(@PathParam("payload") String payload){
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }


}
