package com.pokemon.wiki.domain;

import com.pokemon.wiki.dto.PokemonDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class SpeciesDomain {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String url;

    @OneToOne
    @JoinColumn(name = "pokemonDomain_id")
    private PokemonDomain pokemonDomain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PokemonDomain getPokemonDomain() {
        return pokemonDomain;
    }

    public void setPokemonDomain(PokemonDomain pokemonDomain) {
        this.pokemonDomain = pokemonDomain;
    }

    public SpeciesDomain(String name, String url, PokemonDomain pokemonDomain) {
        this.name = name;
        this.url = url;
        this.pokemonDomain = pokemonDomain;
    }


}
