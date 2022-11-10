package project.spotEEfy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ReviewController {

    @GetMapping("/comment")
    public void postComment(@RequestParam("playlist") String id){}

}
