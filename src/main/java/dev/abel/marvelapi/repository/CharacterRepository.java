package dev.abel.marvelapi.repository;

import dev.abel.marvelapi.domain.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {

}
