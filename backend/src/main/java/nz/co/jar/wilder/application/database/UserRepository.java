package nz.co.jar.wilder.application.database;

import nz.co.jar.wilder.application.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}
