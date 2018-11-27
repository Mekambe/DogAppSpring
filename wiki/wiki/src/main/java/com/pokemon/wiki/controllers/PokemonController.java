package com.pokemon.wiki.controllers;

import com.pokemon.wiki.dao.PokemonRepository;
import com.pokemon.wiki.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PokemonController {

  PokemonRepository pokemonRepository;

  @Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }



}
