package project.spotEEfy.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import project.spotEEfy.core.service.UserService;
import org.springframework.web.bind.annotation.*;
import project.spotEEfy.core.entity.User;
import project.spotEEfy.core.service.UserService;
import project.spotEEfy.web.API.CallbackAPI;
//      import project.spotEEfy.core.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class LoginController {

    private final static Logger log = LoggerFactory.getLogger(LoginController.class);


    private UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }
       



    @GetMapping("/login")
    public String signInPage(ModelMap model) {

        model.addAttribute("test","ouaiouaitest");
        return "login";
    }

    @GetMapping("/error")
    public String failedLogin(ModelMap model) {

        return "login";
    }


    @GetMapping("/callback/response")
    public String test(@Context HttpServletRequest req) {
        return "callback";
    }



    @GetMapping("/token")
    public String test(@RequestParam("access_token") String token) {
        log.warn("test token: " + token);

        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL("https://api.spotify.com/v1/me");

            log.warn("Access token: " + token);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Authorization", "Bearer "+ token);
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;

            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }

            in.close();
            // printing result from response
            log.warn("Response:-" + response.toString());



            //InputStream inputStream = con.getInputStream();
            //responseBody.append(con.getResponseMessage());
            //log.warn("response message user " + String.valueOf(responseBody));

            //log.warn("response body user " + String.valueOf(inputStream));


        } catch (IOException e) {
            e.printStackTrace();
        }


        return "home";
    }

}