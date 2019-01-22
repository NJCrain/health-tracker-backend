package com.njcrain.healthtrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@RestController
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void addUsers(AppUser user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

//        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
//                new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        appUserRepo.save(user);
    }
}
