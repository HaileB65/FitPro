package FitPro.services;

import FitPro.models.ExerciseAPIResponse;
import jakarta.annotation.PostConstruct;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ExerciseAPIService {
    @Autowired
    RestTemplate restTemplate;

//    @PostConstruct
//    public static String getExercise(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Rapidapi-Host", "exercises-by-api-ninjas.p.rapidapi.com");
//        headers.add("X-Rapidapi-Key", "b61a5a7435msh866977d946919afp1c7620jsn64158120fd4f");
//
//        String url = "https://api-ninjas.p.rapidapi.com/v1/exercises?muscle=biceps";
//
//        String body = "";
//
//        HttpEntity<String> request = new HttpEntity<>(body, headers);
//
//        //TODO
//        // Make rest template work
//        ResponseEntity<ExerciseAPIResponse> response = restTemplate.postForEntity(url, request, ExerciseAPIResponse.class);
//
//        return response.getBody();
//    }

    public static URI makeURI(String url){
        URI myUri = null;

        try {
           myUri = new URI(url);
        } catch (URISyntaxException e) {
            e.getMessage();
        }

        return myUri;
    }
}
