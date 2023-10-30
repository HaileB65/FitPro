package FitPro.controller;


import FitPro.models.Exercise;
import FitPro.services.ExerciseAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ExerciseAPIService exerciseAPIService;

    @GetMapping
    public String showHomepage(Model model) throws Exception {
//        Exercise exercise = exerciseAPIService.getExerciseByName("Incline Hammer Curls");

        Exercise exercise1 = Exercise.builder()
                .name("Bench Press")
                .difficulty("beginner")
                .equipment("Bell bar")
                .instructions("Press the bar up with your arms.")
                .muscle("Chest")
                .type("Strength")
                .build();

        System.out.println(exercise1.toString());

        model.addAttribute("exercise", exercise1);

        //TODO
        // create table to display exercises

        //TODO
        // display exercises on home page.
        return "home";
    }

    @GetMapping("/saveExercises")
    public String showExercises(Model model) throws IOException, InterruptedException {
        List<Exercise> exercises = exerciseAPIService.getExercises();
        exerciseAPIService.saveExercises(exercises);

        model.addAttribute("exercises", exercises);
        return "home";
    }
}
