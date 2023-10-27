package FitPro;

import FitPro.models.ExerciseAPIResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExerciseAPIService {
    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    public ExerciseAPIResponse getExercise(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Rapidapi-Host", "exercises-by-api-ninjas.p.rapidapi.com");
        headers.add("X-Rapidapi-Key", "b61a5a7435msh866977d946919afp1c7620jsn64158120fd4f");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        String url = "https://api-ninjas.p.rapidapi.com/v1/exercises?muscle=abdominals";
//        String url = "https://api-ninjas.p.rapidapi.com/v1/exercises";

//        String uri = UriComponentsBuilder.fromHttpUrl(url)
//                .queryParam("muscle", "abdominals")
//                .encode()
//                .toUriString();

        HttpEntity<String> request = new HttpEntity<>(headers);

        //TODO
        // Make rest template work
        ResponseEntity<ExerciseAPIResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, ExerciseAPIResponse.class);


        return response.getBody();
    }

    public void messageConverters(){
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
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
