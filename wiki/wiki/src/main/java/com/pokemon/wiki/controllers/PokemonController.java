package com.pokemon.wiki.controllers;

import com.pokemon.wiki.dao.PokemonDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

  PokemonDomainRepository pokemonRepository;

  @Autowired
    public PokemonController(PokemonDomainRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }



}
