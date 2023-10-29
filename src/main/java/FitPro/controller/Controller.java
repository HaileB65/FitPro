package FitPro.controller;


import FitPro.models.Exercise;
import FitPro.models.ExerciseAPIResponse;
import FitPro.services.ExerciseAPIService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    //TODO
    // Fix BeanCreationException error when trying to autowire the exerciseAPIService.
    // U.
    // se @ComponentScan(basePackages = {"com.baeldung.dependency.exception"}) annotation in spring boot class?
    @Autowired
    ExerciseAPIService exerciseAPIService;

    @GetMapping
    public String showHomepage(Model model) throws IOException, InterruptedException {
        List<Exercise> exercises = exerciseAPIService.getExercises();

        model.addAttribute("exercises", exercises);

        return "home";
    }
}
