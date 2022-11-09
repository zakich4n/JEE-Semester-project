package project.spotEEfy.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//      import project.spotEEfy.core.service.UserService;

import javax.ws.rs.Path;

@Controller
public class LoginController {


   /* private UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    */



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
}