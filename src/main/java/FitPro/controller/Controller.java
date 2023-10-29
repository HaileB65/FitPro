package FitPro.controller;


import FitPro.models.Exercise;
import FitPro.models.ExerciseAPIResponse;
import FitPro.repositories.ExerciseRepository;
import FitPro.services.ExerciseAPIService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ExerciseAPIService exerciseAPIService;

    @GetMapping
    public String showHomepage(Model model) throws IOException, InterruptedException {
        List<Exercise> exercises = exerciseAPIService.getExercises();

        model.addAttribute("exercises", exercises);

        return "home";
    }

    @PostMapping("/saveExercises")
    public String saveExercises(@ModelAttribute("exercises") List<Exercise> exercises) {
        for(Exercise exercise: exercises) {
            exerciseAPIService.saveExercise(exercise);
        }

        return "redirect:/myTrips";
    }
}
