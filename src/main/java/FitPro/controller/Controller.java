package FitPro.controller;


import FitPro.models.Exercise;
import FitPro.services.ExerciseAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ExerciseAPIService exerciseAPIService;

    @GetMapping
    public String showHomepage(Model model) throws Exception {
//        Exercise exercise1 = Exercise.builder()
//                .id(1)
//                .name("Bench Press")
//                .difficulty("beginner")
//                .equipment("Bell bar")
//                .instructions("Press the bar up with your arms.")
//                .muscle("Chest")
//                .type("Strength")
//                .build();
//
//        Exercise exercise2 = Exercise.builder()
//                .id(2)
//                .name("Pull Up")
//                .difficulty("beginner")
//                .equipment("Pull Up bar")
//                .instructions("Pull your body up with your arms.")
//                .muscle("Biceps")
//                .type("Strength")
//                .build();
//        List<Exercise> exerciseList = List.of(new Exercise[]{exercise1, exercise2});

        List<Exercise> exerciseList = exerciseAPIService.getExercises();
        System.out.println(exerciseList);

        model.addAttribute("exerciseList", exerciseList);

        return "home";
    }
}
