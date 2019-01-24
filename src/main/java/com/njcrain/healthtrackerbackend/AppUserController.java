package com.njcrain.healthtrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void addUsers(AppUser user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        appUserRepo.save(user);
    }

    @GetMapping("/user")
    public HashMap<String, Object> getUserInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser fullUser = appUserRepo.findByUsername((String) authentication.getPrincipal());
        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", fullUser.getUsername());
        userInfo.put("avatarUri", fullUser.getAvatarUri());
        userInfo.put("id", fullUser.getId());
        userInfo.put("homePageVisits", fullUser.getHomePageVisits());
        userInfo.put("clickerScore", fullUser.getClickerScore());
        return userInfo;


    }

    @GetMapping("/")
    public String home() {
        return "Hello";
    }
}
