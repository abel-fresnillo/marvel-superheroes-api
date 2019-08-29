package dev.abel.marvelapi.controller;

import dev.abel.marvelapi.domain.Hero;
import dev.abel.marvelapi.service.HeroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {
    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/hero/{id}")
    public Hero findCharactersByName(@PathVariable int id) {
        return heroService.findHeroById(id);
    }

    @GetMapping("/hero")
    public List<Hero> findCharactersByName(@RequestParam String name) {
        return heroService.findHeroByName(name);
    }
}
