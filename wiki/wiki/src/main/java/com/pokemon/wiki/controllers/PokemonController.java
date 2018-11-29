package com.pokemon.wiki.controllers;

import com.pokemon.wiki.dao.PokemonDomainRepository;
import com.pokemon.wiki.domain.AbilitiesDomains;
import com.pokemon.wiki.domain.AbilityDomain;
import com.pokemon.wiki.domain.PokemonDomain;
import com.pokemon.wiki.domain.SpeciesDomain;
import com.pokemon.wiki.dto.AbilitiesDto;
import com.pokemon.wiki.dto.AbilityDto;
import com.pokemon.wiki.dto.PokemonDto;
import com.pokemon.wiki.dto.SpeciesDto;
import com.pokemon.wiki.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addPokemon")
    public int addNewPokemonByBody(@RequestBody PokemonDto pokemonDto){


        SpeciesDto speciesDto = new SpeciesDto();
        AbilitiesDto abilitiesDto = new AbilitiesDto();
        AbilityDto abilityDto = new AbilityDto();




        PokemonDomain pokemonDomain = new PokemonDomain();
        SpeciesDomain speciesDomain = new SpeciesDomain();
        AbilitiesDomains abilitiesDomains = new AbilitiesDomains();
        AbilityDomain abilityDomain = new AbilityDomain();



     pokemonDomain.setName(pokemonDto.getName());
     pokemonDomain.setBaseExperience(pokemonDto.getBaseExperience());
     pokemonDomain.setOrder1(pokemonDto.getOrder());
     pokemonDomain.setSpecies(speciesDomain);
     speciesDomain.setName(speciesDto.getName());
     speciesDomain.setUrl(speciesDto.getUrl());







        PokemonDomain save = pokemonDomainRepository.save(pokemonDomain);

        //return pokemon id after save to db

        return Math.toIntExact(save.getId());
    }

    @PostMapping("/addPokemonUrl")
    public int addNewPokemonByBodyByUrlParams(@RequestParam (value = "name") String name,
                                              @RequestParam (value = "order1") int order1,
                                              @RequestParam (value = "speciesName") String speciesName,
                                              @RequestParam (value = "speciesUrl") String speciesUrl){



        PokemonDomain pokemonDomain = new PokemonDomain();
        pokemonDomain.setName(name);
        pokemonDomain.setOrder1(order1);
        SpeciesDomain speciesDomain = new SpeciesDomain();
        speciesDomain.setName(speciesName);
        speciesDomain.setUrl(speciesUrl);
    pokemonDomain.setSpecies(speciesDomain);
        pokemonDomain.setSpecies(speciesDomain);


        PokemonDomain save = pokemonDomainRepository.save(pokemonDomain);


        return Math.toIntExact(save.getId()) ;
    }

}
