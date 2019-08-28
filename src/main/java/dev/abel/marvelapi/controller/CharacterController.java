package dev.abel.marvelapi.controller;

import dev.abel.marvelapi.domain.Character;
import dev.abel.marvelapi.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/character/{id}")
    public Character findCharactersByName(@PathVariable int id) {
        return characterService.findCharacterById(id);
    }

    @GetMapping("/character")
    public List<Character> findCharactersByName(@RequestParam String name) {
        return characterService.findCharacterByName(name);
    }
}
