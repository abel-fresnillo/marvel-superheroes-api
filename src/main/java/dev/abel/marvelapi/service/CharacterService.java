package dev.abel.marvelapi.service;

import dev.abel.marvelapi.domain.Character;
import dev.abel.marvelapi.dto.RestResponse;
import dev.abel.marvelapi.util.MarvelUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CharacterService {
    private final RestTemplate restTemplate;

    @Autowired
    MarvelUrlGenerator marvelUrlGenerator;

    public CharacterService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Character findCharacterById(int id) {
        Character character = new Character();

        RestResponse apiResponse = restTemplate.getForObject(getCharacterUrl() + "&id=" + id, RestResponse.class);

        if (apiResponse != null) {
            character = apiResponse.getData().getResults()[0];
        }

        return character;
    }

    public List<Character> findCharacterByName(String name) {
        List<Character> characterList = new ArrayList<>();
        RestResponse apiResponse = restTemplate.getForObject(getCharacterUrl() + "&nameStartsWith=" + name, RestResponse.class);

        if (apiResponse != null) {
            characterList = Arrays.asList(apiResponse.getData().getResults());
        }

        return characterList;
    }

    private String getCharacterUrl() {
        long ts = System.currentTimeMillis();
        return marvelUrlGenerator.generateCharacterUrl(ts);
    }
}
