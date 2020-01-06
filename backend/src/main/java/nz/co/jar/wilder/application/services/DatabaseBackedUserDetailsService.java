package nz.co.jar.wilder.application.services;

import nz.co.jar.wilder.application.components.security.UserDetailsImpl;
import nz.co.jar.wilder.application.database.UserRepository;
import nz.co.jar.wilder.application.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseBackedUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public DatabaseBackedUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(user);
    }
}
