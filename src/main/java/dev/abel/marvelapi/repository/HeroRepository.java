package dev.abel.marvelapi.repository;

import dev.abel.marvelapi.domain.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

}
