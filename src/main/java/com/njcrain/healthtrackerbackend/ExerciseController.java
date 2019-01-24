package com.njcrain.healthtrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepo;

    @Autowired
    private AppUserRepository appUserRepo;

    @GetMapping("/exercises")
    public Iterable<Exercise> getExercises() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = appUserRepo.findByUsername((String) authentication.getPrincipal());

        return user.getExercises();

    }

    @PostMapping("/exercises")
    public void addExercise(Exercise e) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = appUserRepo.findByUsername((String) authentication.getPrincipal());
        e.setUser(user);
        if (e.getTimestamp() == null) {
            LocalDateTime now = LocalDateTime.now();
            e.setTimestamp(now.format(DateTimeFormatter.ofPattern("M/d/yy h:mma")));
        }

        exerciseRepo.save(e);
    }
}
