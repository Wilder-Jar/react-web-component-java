package nz.co.jar.wilder.application.controllers;


import nz.co.jar.wilder.application.components.security.UserDetailsImpl;
import nz.co.jar.wilder.application.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/name")
    public String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object myUser = (auth != null) ? auth.getPrincipal() : null;

        String userName = "";

        if (myUser instanceof UserDetailsImpl) {
            userName = ((UserDetailsImpl) myUser).getUsername();
            //get details from model object
        }

        return userName;
    }
}
