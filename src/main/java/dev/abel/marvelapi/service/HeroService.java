package dev.abel.marvelapi.service;

import dev.abel.marvelapi.domain.Hero;
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
public class HeroService {
    private final RestTemplate restTemplate;

    @Autowired
    MarvelUrlGenerator marvelUrlGenerator;

    public HeroService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Hero findHeroById(int id) {
        Hero hero = new Hero();

        RestResponse apiResponse = restTemplate.getForObject(getHeroUrl() + "&id=" + id, RestResponse.class);

        if (apiResponse != null) {
            hero = apiResponse.getData().getResults()[0];
        }

        return hero;
    }

    public List<Hero> findHeroByName(String name) {
        List<Hero> heroList = new ArrayList<>();
        RestResponse apiResponse = restTemplate.getForObject(getHeroUrl() + "&nameStartsWith=" + name, RestResponse.class);

        if (apiResponse != null) {
            heroList = Arrays.asList(apiResponse.getData().getResults());
        }

        return heroList;
    }

    private String getHeroUrl() {
        long ts = System.currentTimeMillis();
        return marvelUrlGenerator.generateHeroUrl(ts);
    }
}
