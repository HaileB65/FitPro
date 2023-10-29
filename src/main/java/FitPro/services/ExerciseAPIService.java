package FitPro.services;

import FitPro.models.Exercise;
import FitPro.repositories.ExerciseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

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
        List<Exercise> exerciseList = mapper.readValue(exercisesJSONString, new TypeReference<List<Exercise>>(){});

        System.out.println(exerciseList);

        return exerciseList;
    }

    public Exercise saveExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
        return exercise;
    }

}
