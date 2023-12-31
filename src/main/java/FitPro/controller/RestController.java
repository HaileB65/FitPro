package FitPro.controller;

import FitPro.services.ExerciseAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    ExerciseAPIService exerciseAPIService;

    @PostMapping("/exercises")
    public ResponseEntity<?> findExercises() {
        try {
            return ResponseEntity.ok(exerciseAPIService.getExercises());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
