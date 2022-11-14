package project.spotEEfy.web.controller;



import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.spotEEfy.core.dao.LikeDAO;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.entity.User;
import project.spotEEfy.core.service.PlaylistService;
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
import java.util.List;


@Controller
public class LoginController {

    private final static Logger log = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;

    static User sessionUser;

    private PlaylistService playlistService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    static String tokeng;

    public List<List<String>> deparseSongList(String json){

        List<List<String>> list = null;

        String jsonString = json.toString() ; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("items");
        log.warn(arr.toString());
        for (int i = 0; i < arr.length(); i++) {
            List<String> listTmp = null;

            String title = arr.getJSONObject(i).getJSONObject("track").getString("name");
            JSONArray author_arr = arr.getJSONObject(i).getJSONObject("track").getJSONArray("artists");
            String author = author_arr.getJSONObject(0).getString("name");
            JSONArray photo_url_arr = arr.getJSONObject(i).getJSONObject("track").getJSONObject("album").getJSONArray("images");
            String url_photo = photo_url_arr.getJSONObject(2).getString("url");

            log.warn("result of the songs list call of index "+ i +" : " + author + " " + " "
                    + url_photo );


            listTmp.add(title);
            listTmp.add(author);
            listTmp.add(url_photo);
            list.add(listTmp);
        }

        return list;
    }


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
        return "redirect:/home";
    }


    // To explain a little this function had to get and create all the playlist but it still don't work on monday so... ://
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

            String ID_Playlist = null;
            String user_playlist = null;
            String name = null;
            String songs_url = null;
            String photo_url = null;
            //int number_of_songs = 0;
            String jsonString = response.toString() ; //assign your JSON String here
            JSONObject obj = new JSONObject(jsonString);
            JSONArray arr = obj.getJSONArray("items"); // notice that `"posts": [...]`
            for (int i = 0; i < arr.length(); i++){
                ID_Playlist = arr.getJSONObject(i).getString("id");
                user_playlist  = arr.getJSONObject(i).getJSONObject("owner").getString("display_name");
                name  = arr.getJSONObject(i).getString("name");
                songs_url = arr.getJSONObject(i).getJSONObject("tracks").getString("href");
                //number_of_songs = Integer.parseInt(arr.getJSONObject(i).getJSONObject("tracks").getString("total"));
                JSONArray photo_url_arr = arr.getJSONObject(i).getJSONArray("images");
                for(int n = 0; n<photo_url_arr.length(); n++){
                    if(n == 1) {
                        photo_url = photo_url_arr.getJSONObject(n).getString("url");
                    }
                }


                log.warn("result of the playlist call of index "+ i +" : " + ID_Playlist + " " + user_playlist + " "
                        + name + " " + songs_url + " "  + " " + photo_url );
                Playlist playlistToCreate = new Playlist(ID_Playlist, user_playlist, name, photo_url);
                playlistService.savePlaylist(playlistToCreate);


                //URL url_songs = new URL(songs_url+"?fields=items(track(name,artists,duration_ms,album(name,href,images)))");
                /*
                HttpURLConnection con_songs = (HttpURLConnection) url_songs.openConnection();
                con_songs.setRequestProperty("Authorization", "Bearer "+ tokeng);
                con_songs.setRequestProperty("Content-Type","application/json");
                con_songs.setRequestProperty("Accept","application/json");
                con_songs.setRequestMethod("GET");
                log.warn("we get tracks");
                BufferedReader in_songs = new BufferedReader(new InputStreamReader(con_songs.getInputStream()));
                String output_songs;

                StringBuffer response_songs = new StringBuffer();
                while ((output_songs = in_songs.readLine()) != null) {
                    response_songs.append(output_songs);
                }
                in_songs.close();
                // printing result from response
                //log.warn("Response_songs:-" + response_songs.toString());
                //List<List<String>> listSong = deparseSongList(response_songs.toString());
                //log.warn("song after parse : " + listSong.toString());
                 */
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

}