package project.spotEEfy.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import project.spotEEfy.core.entity.Like;
import project.spotEEfy.core.entity.Playlist;
import project.spotEEfy.core.service.LikeService;
import project.spotEEfy.core.service.PlaylistService;
import project.spotEEfy.core.service.UserService;
import project.spotEEfy.web.controller.LoginController;

import java.util.ArrayList;
import java.util.List;

import static project.spotEEfy.web.controller.LoginController.sessionUser;

@Controller
public class HomeController {

    private UserService userService;
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    private PlaylistService playlistService;
    private LikeService likeService;

    //TODO: add playlist in js or java and the user name would be cool too
    @GetMapping("/home")
    public String homePage(ModelMap model){
        //if(sessionUser.getID_User().length() < 2) return "home";
        model.addAttribute("session_user", sessionUser);
        return "home";
    }

    @GetMapping("/library")
    public String goToLibrary(ModelMap model) {
        //if(sessionUser.getID_User().length() < 2) return "login";
        model.addAttribute("session_user", sessionUser);

        Boolean isEmpty=true;
        try {
            playlistService.doesUserHaveNoPlaylist(sessionUser);
            likeService.doesUserHaveNoLike(sessionUser);
            isEmpty=false;
        } catch (Exception e) {

        }
        if(isEmpty) return "empty_library";
        model.addAttribute("created_playlists", playlistService.getAllPlaylistFromUser(sessionUser.getID_User()));
        List<Like> likedByUser=likeService.getAllLikesFromUser(sessionUser);
        List<Playlist> playlistLiked= new ArrayList<>();
        for(Like like : likedByUser) {
            playlistLiked.add(like.getPlaylist());
        }
        model.addAttribute("liked_playist", playlistLiked);
        return "library";
    }
}
