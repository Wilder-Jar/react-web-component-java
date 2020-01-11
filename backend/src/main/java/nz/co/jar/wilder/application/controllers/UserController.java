package nz.co.jar.wilder.application.controllers;


import nz.co.jar.wilder.application.components.security.UserDetailsImpl;
import nz.co.jar.wilder.application.models.RegistrationResponse;
import nz.co.jar.wilder.application.models.User;
import nz.co.jar.wilder.application.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerNewUser(@RequestBody User user) {
        ResponseEntity<RegistrationResponse> response;

        boolean emailUsed = userService.checkUserEmailExists(user.getEmail());
        boolean usernameUsed = userService.checkUserNameExists(user.getUsername());

        if (emailUsed) {
            response = new ResponseEntity<RegistrationResponse>(new RegistrationResponse(false, "Error", "Email is already in use"), HttpStatus.CONFLICT);
        } else if (usernameUsed) {
            response = new ResponseEntity<RegistrationResponse>(new RegistrationResponse(false, "Error", "Username is already in use"), HttpStatus.CONFLICT);
        } else {
            userService.registerNewUser(user);
            response = new ResponseEntity<RegistrationResponse>(new RegistrationResponse(true, "Message", "Account created successfully"), HttpStatus.CREATED);
        }

        return response;
    }
}
