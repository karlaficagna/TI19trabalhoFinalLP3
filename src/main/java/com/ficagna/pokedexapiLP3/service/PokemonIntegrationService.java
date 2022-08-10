package com.ficagna.pokedexapiLP3.service;

import com.ficagna.pokedexapiLP3.controller.PokemonDto;
import com.ficagna.pokedexapiLP3.model.Pokemon;
import com.ficagna.pokedexapiLP3.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Getter
@AllArgsConstructor
public class PokemonIntegrationService {

    private final RestTemplate restTemplate;
    private final String uri;

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.uri = "https://pokeapi.co/api/v2/pokemon";
    }

    public PokemonDto findById(Long id) {
        String url = generateURLIntegration(id);
        return this.restTemplate.getForObject(url, PokemonDto.class);
    }

    private String generateURLIntegration(Long id) {

        return this.uri + "/" + id;
    }

    private String generateURLIntegration(String name) {

        return this.uri + "/" + name;
    }

    public Pokemon findByName(String name) {
        String url = generateURLIntegration(name);
        return this.restTemplate.getForObject(url, Pokemon.class);
    }

    public Pokemon create(@Valid Pokemon pokemonSalvo) {
        return pokemonRepository.save(pokemonSalvo);
    }

    public Pokemon exclui(String pokemon) {
        return pokemonRepository.delete(pokemon);
    }

    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }
}
