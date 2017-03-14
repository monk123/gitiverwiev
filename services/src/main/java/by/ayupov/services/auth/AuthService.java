package by.ayupov.services.auth;

import by.ayupov.entity.Role;
import by.ayupov.entity.User;
import by.ayupov.enums.State;
import by.ayupov.services.interfaces.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserDetailsService} interface
 *
 * @author Vadim Ayupov
 */
@Service("authService")
@Log
public class AuthService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByName(email);
        log.info("User: " + user);
        if (user == null) {
            log.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }

        return new MvcUser(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(),
        State.ACTIVE.getState().equals(user.getState()),true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : user.getUserRole()) {
            log.info("PersonProfile : " + role);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
