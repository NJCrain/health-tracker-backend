package com.njcrain.healthtrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/exercises")
    public Iterable<Exercise> getExercises() {
        return exerciseRepo.findAll();
    }

    @PostMapping("/exercises")
    public void addExercise(Exercise e) {
        LocalDateTime now = LocalDateTime.now();
        e.setTimestamp(now.format(DateTimeFormatter.ofPattern("M/d/yy h:mma")));
        exerciseRepo.save(e);
    }
}
