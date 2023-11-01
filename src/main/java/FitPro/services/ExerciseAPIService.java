package FitPro.services;

import FitPro.models.Exercise;
import FitPro.repositories.ExerciseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseAPIService {
    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> getExercises() throws IOException, InterruptedException {
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?muscle=biceps"))
                .header("X-RapidAPI-Key", "b61a5a7435msh866977d946919afp1c7620jsn64158120fd4f")
                .header("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        String exercisesJSONString = response.body();

        ObjectMapper mapper = new ObjectMapper();
        List<Exercise> exerciseList = mapper.readValue(exercisesJSONString, new TypeReference<List<Exercise>>() {
        });

        System.out.println(exerciseList);

        return exerciseList;
    }

    public Exercise saveExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
        return exercise;
    }

    public void saveExercises(List<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            exerciseRepository.save(exercise);
        }
    }

    public Exercise getExerciseByName(String name) throws Exception {
        Optional<Exercise> exercise = exerciseRepository.findByName(name);

        if (exercise.isPresent()) {
            return exercise.get();
        } else throw new Exception("Exercise name not found");
    }

    public JSONArray turnJavaObjectsIntoJSON(List<Exercise> exercises) {
        JSONArray arr = new JSONArray();
        JSONObject tmp;
        try {
            for (int i = 0; i < exercises.size(); i++) {
                tmp = new JSONObject();
                tmp.put("Name", exercises.get(i).getName());
                tmp.put("Difficulty", exercises.get(i).getDifficulty());
                tmp.put("Equipment", exercises.get(i).getEquipment());
                tmp.put("Instructions", exercises.get(i).getInstructions());
                arr.put(tmp);
            }

//            webView.loadUrl("javascript:fetchFriends(" + arr.toString() + ")");
        } catch (JSONException e) {
            //error handling
        }
        System.out.println(arr.toString());
        return arr;
    }
}
