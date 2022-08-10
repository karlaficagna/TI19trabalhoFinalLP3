package com.ficagna.pokedexapiLP3.controller;

import com.ficagna.pokedexapiLP3.model.Pokemon;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PokemonDto {

    private Long id;
    private String name;
    @Setter
    private int hight;
    private int weight;

    public PokemonDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.hight = pokemon.getHeight();
        this.weight = pokemon.getWeight();
    }

    public static List<PokemonDto> converter(List<Pokemon> pokemons) {
        return pokemons.stream().map(PokemonDto::new).collect(Collectors.toList());
    }

}
