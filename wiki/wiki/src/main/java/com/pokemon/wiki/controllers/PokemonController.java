package com.pokemon.wiki.controllers;

import com.pokemon.wiki.dao.PokemonDomainRepository;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.dto.PokemonDto;
import com.pokemon.wiki.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController {

    private PokemonDomainRepository pokemonDomainRepository;
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonDomainRepository pokemonDomainRepository, PokemonService pokemonService) {
        this.pokemonDomainRepository = pokemonDomainRepository;
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public PokemonDomain returnPokemonById (@RequestParam (value = "id") Long id){
        Optional<PokemonDomain> byId = pokemonDomainRepository.findById( id);

        if (byId.isPresent()){
            return byId.get();
        }else {
            PokemonDto pokemonFromApi = pokemonService.getPokemonFromApi(id);
            PokemonDomain pokemonDomain = pokemonService.convertPokemon(pokemonFromApi);
            PokemonDomain save = pokemonDomainRepository.save(pokemonDomain);
            return save;
        }


    }

    @RequestMapping("/pokemonAll")
    public List<PokemonDomain> findAllPokemon (){

        List<PokemonDomain> all = pokemonDomainRepository.findAll();
        return all;
    }

}
