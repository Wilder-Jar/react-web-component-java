package nz.co.jar.wilder.application.services;

import nz.co.jar.wilder.application.database.UserRepository;
import nz.co.jar.wilder.application.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        initialiseDB();
    }

    private void initialiseDB() {
        registerNewUser(new User("user", "pass", "email@email.com"));
    }

    public boolean checkUserEmailExists(String email) {
        User userByEmail = userRepository.findByEmail(email);

        return userByEmail!=null;
    }

    public boolean checkUserNameExists(String username) {
        User userByUsername = userRepository.findByUsername(username);

        return userByUsername!=null;
    }

    public void registerNewUser(User user) {
        userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail()));
    }
}
