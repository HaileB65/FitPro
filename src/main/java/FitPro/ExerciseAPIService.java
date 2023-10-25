package FitPro;

import FitPro.models.ExerciseAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpHeaders;

@Service
public class ExerciseAPIService {
    @Autowired
    RestTemplate restTemplate;

    public ExerciseAPIResponse getExercise(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Rapidapi-Host", "exercises-by-api-ninjas.p.rapidapi.com");
        headers.add("X-Rapidapi-Key", "b61a5a7435msh866977d946919afp1c7620jsn64158120fd4f");

        String url = "https://api-ninjas.p.rapidapi.com/v1/exercises?muscle=biceps";

        String body = "";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        //TODO
        // Make rest template work
        ResponseEntity<ExerciseAPIResponse> response = restTemplate.postForEntity(url, request, ExerciseAPIResponse.class);
        response.getBody();

        return response.getBody();
    }

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
