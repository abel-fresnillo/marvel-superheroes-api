package dev.abel.marvelapi.service;

import dev.abel.marvelapi.dto.HeroDTO;
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

    public HeroDTO findHeroById(int id) {
        HeroDTO heroDTO = new HeroDTO();

        RestResponse apiResponse = restTemplate.getForObject(getHeroUrl() + "&id=" + id, RestResponse.class);

        if (apiResponse != null && apiResponse.getCode().equals("200")) {
            heroDTO = apiResponse.getData().getResults()[0];
        }

        return heroDTO;
    }

    public List<HeroDTO> findHeroByName(String name) {
        List<HeroDTO> heroDTOList = new ArrayList<>();
        RestResponse apiResponse = restTemplate.getForObject(getHeroUrl() + "&nameStartsWith=" + name, RestResponse.class);

        if (apiResponse != null && apiResponse.getCode().equals("200")) {
            heroDTOList = Arrays.asList(apiResponse.getData().getResults());
        }

        return heroDTOList;
    }

    private String getHeroUrl() {
        long ts = System.currentTimeMillis();
        return marvelUrlGenerator.generateHeroUrl(ts);
    }
}
