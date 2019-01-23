package com.njcrain.healthtrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Implementation of the UserDetailService for proper security/auth with spring
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppUserRepository appUserRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = this.appUserRepo.findByUsername(username);

        if(user == null){
            System.out.println("User: " + username + " not found.");
            throw new UsernameNotFoundException("User (" + username + ") was not found in database.");
        }

        System.out.println("Found User: " + user);

        return user;
    }

}