package nz.co.jar.wilder.application.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)

    private String hash;

    public User(String username, String hash) {
        this.username = username;
        this.hash = hash;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        return new ArrayList<>();
    }

    public boolean getAccountExpired() {
        return false;
    }

    public boolean getAccountLocked() {
        return false;
    }

    public boolean getCredentialsLocked() {
        return false;
    }

    public boolean getEnabled() {
        return true;
    }
}
