package project.spotEEfy.web.API;


import project.spotEEfy.core.service.UserService;
import project.spotEEfy.web.controller.RestController;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;


@Named
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class UserApi implements RestController {
    private UserService userService;



}
