package FitPro.controller;


import FitPro.models.ExerciseAPIResponse;
import FitPro.services.ExerciseAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ExerciseAPIService exerciseAPIService;

    @GetMapping
    public String showHomepage(Model model) throws IOException, InterruptedException {
        String exercises = exerciseAPIService.getExercises();

        model.addAttribute("exercises", exercises);

        return "home";
    }
}
