package project.spotEEfy.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.spotEEfy.core.service.LikeService;
import project.spotEEfy.core.service.PlaylistService;

import static project.spotEEfy.web.controller.LoginController.sessionUser;


@Controller
public class LikeController {

    private LikeService likeService;
    private PlaylistService playlistService;


    @GetMapping("/like")
    public void likingPlaylist(@RequestParam("playlist") Long id) {
        likeService.likePlaylist(playlistService.getPlaylistByID(id),sessionUser );
    }

@GetMapping("/unlike")
    public void unlikePlaylist(@RequestParam("playlist") Long id) {
        likeService.unlikePlaylist(sessionUser, playlistService.getPlaylistByID(id));
    }

}
