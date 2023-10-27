package FitPro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExerciseAPIService {
    @Autowired
    RestTemplate restTemplate;

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
}
