package FitPro.services;

import FitPro.models.Exercise;
import jakarta.annotation.PostConstruct;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExerciseAPIService {

    public String getExercises() throws IOException, InterruptedException {
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create("https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?muscle=biceps"))
                .header("X-RapidAPI-Key", "b61a5a7435msh866977d946919afp1c7620jsn64158120fd4f")
                .header("X-RapidAPI-Host", "exercises-by-api-ninjas.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
    }

    //TODO
    // Get createJSONObjectList method to work
//    @PostConstruct
//    public static void createJSONObjectList(){
//        JSONArray jsonArr = new JSONArray("[Your json string array]");
//        List<Exercise> listOfExercises = new ArrayList<>();
//        for (int i = 0; i < jsonArr.length(); i++) {
//            JSONObject jsonObj = jsonArr.getJSONObject(i);
//            Exercise exercise = new Exercise();
//            exercise.setName(jsonObj.getString("name"));
//            exercise.setType(jsonObj.getString("type"));
//            exercise.setMuscle(jsonObj.getString("muscle"));
//            exercise.setEquipment(jsonObj.getString("equipment"));
//            exercise.setInstructions(jsonObj.getString("instructions"));
//            listOfExercises.add(exercise);
//        }
//        System.out.println(listOfExercises);
//    }

}
