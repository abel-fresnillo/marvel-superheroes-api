package dev.abel.marvelapi.repository;

import dev.abel.marvelapi.domain.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
