package ru.neoflex.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.neoflex.banking.dao.UserDao;
import ru.neoflex.banking.model.User;

@Component
public class SpringSecurityUserContext  {

    @Autowired
    private UserDao userDao;



    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        }

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
        String name = user.getUsername();
        if (name == null) {
            return null;
        }
        User result = userDao.findUserByName(name);
        if (result == null) {
            throw new IllegalStateException(
                    "Spring Security is not in synch with User. Could not find user with email " + name);
        }
        return result;
    }



}
