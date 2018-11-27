package com.pokemon.wiki.dao;

import com.pokemon.wiki.dto.PokemonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends JpaRepository<PokemonDto, Long> {
}
