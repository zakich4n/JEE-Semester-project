package project.spotEEfy.web.controller;



import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.spotEEfy.core.dao.LikeDAO;
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

    static User sessionUser;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
       

    static String tokeng;


    @GetMapping("/login")
    public String signInPage(ModelMap model) {
        //LOGGER.warn("LOGIN QUI SE LANCE");
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

        tokeng = token;

        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL("https://api.spotify.com/v1/me");

            log.warn("Access token: " + token);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Authorization", "Bearer "+ token);
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("Accept","application/json");
            con.setRequestMethod("GET");
            log.warn("connected");
            //log.warn("con : "+ con.getContent());
            //log.warn("con : "+ con.getRequestProperties());
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;

            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            // printing result from response
            log.warn("Response:-" + response.toString());

            //TODO change id user to string
            String jsonString = response.toString() ; //assign your JSON String here
            JSONObject obj = new JSONObject(jsonString);
            String username  = obj.getString("display_name");
            String email  = obj.getString("email");
            String ID_User  = obj.getString("id");
            String country  = obj.getString("country");


            log.warn(username  + " " + email + " "+ ID_User + " "+ country);

            sessionUser = new User(ID_User, email, username, country);
            userService.saveUser(sessionUser);
            log.warn("save User :", sessionUser.getID_User());
            //InputStream inputStream = con.getInputStream();
            //responseBody.append(con.getResponseMessage());
            //log.warn("response message user " + String.valueOf(responseBody));
            //log.warn("response body user " + String.valueOf(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/wait";
    }

    @GetMapping("/wait")
    public String getUserData(User user) {

        StringBuilder responseBody = new StringBuilder();
        try {
            URL url = new URL("https://api.spotify.com/v1/users/"+ sessionUser.getID_User()+ "/playlists");


            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestProperty("Authorization", "Bearer "+ tokeng);
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("Accept","application/json");
            con.setRequestMethod("GET");
            log.warn("we will get playlist");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;

            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            // printing result from response
            log.warn("Response_playlist:-" + response.toString());



            //TODO change id user to string

            String jsonString = response.toString() ; //assign your JSON String here
            JSONObject obj = new JSONObject(jsonString);
            String username  = obj.getString("display_name");
            String email  = obj.getString("email");
            String ID_User  = obj.getString("id");
            String country  = obj.getString("country");


            log.warn(username  + " " + email + " "+ ID_User + " "+ country);

            sessionUser = new User(ID_User, email, username, country);
            userService.saveUser(sessionUser);
            log.warn("save User :", sessionUser.getID_User());



        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }


}