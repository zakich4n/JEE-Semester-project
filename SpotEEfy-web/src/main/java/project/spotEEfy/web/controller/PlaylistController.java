package project.spotEEfy.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.spotEEfy.core.service.CommentService;
import project.spotEEfy.core.service.PlaylistService;
import project.spotEEfy.core.entity.Playlist;


import static project.spotEEfy.web.controller.LoginController.sessionUser;

public class PlaylistController {

    private PlaylistService playlistService;
    private CommentService commentService;


    @GetMapping("/playlist")
    public String getLibrary(@RequestParam("id") String id, ModelMap model) {
        Boolean isLoggedIn=false;
        try{
            sessionUser.getID_User().length();
        }
        catch (Exception e) {}
        isLoggedIn=true;
        if(isLoggedIn) return "login";
        model.addAttribute("session_user", sessionUser);
        Playlist playlist= playlistService.getPlaylistByID(id);
        model.addAttribute("playlist",playlist);
        model.addAttribute("song_list",playlist.getSongs());
        model.addAttribute("comment_list", commentService.getCommentsFromPlaylist(playlist));
        return "library";
    }
}
   