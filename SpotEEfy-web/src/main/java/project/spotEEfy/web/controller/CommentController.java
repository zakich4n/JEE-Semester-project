package project.spotEEfy.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.spotEEfy.core.service.UserService;
import project.spotEEfy.core.service.CommentService;
import project.spotEEfy.core.service.PlaylistService;

import static project.spotEEfy.web.controller.LoginController.sessionUser;


@Controller
public class CommentController {

    private CommentService commentService;
    private PlaylistService playlistService;
    private UserService userService;


    @PostMapping("/comment")  // {"id_playlist": "XXX", "user":"YYY" ,"comment":"ZZZ"}
    public void commentingPlaylist(@RequestBody String payload, HttpServletResponse res) {
        JSONObject data= new JSONObject(payload);
        Comment comment= new Comment(
                userService.getUserById(data.user),
                playlistService.getPlaylistByID(data.id_playlist),
                data.comment
        );
        commentService.saveComment(comment);
        res.setStatus(HttpServletResponse.SC_OK);
        res.flush;
    }



}
