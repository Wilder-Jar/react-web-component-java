package nz.co.jar.wilder.application.services;

import nz.co.jar.wilder.application.database.UserRepository;
import nz.co.jar.wilder.application.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        initialiseDB();
    }

    private void initialiseDB() {
        userRepository.save(new User("user", "pass"));
    }
}
