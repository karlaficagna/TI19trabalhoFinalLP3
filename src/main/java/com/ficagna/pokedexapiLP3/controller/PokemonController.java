package com.ficagna.pokedexapiLP3.controller;

import com.ficagna.pokedexapiLP3.model.Pokemon;
import com.ficagna.pokedexapiLP3.repository.PokemonRepository;
import com.ficagna.pokedexapiLP3.service.PokemonIntegrationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("api/v1/pokemons")
public class PokemonController {

    @Autowired
    private PokemonIntegrationService pokemonIntegrationService;
    private PokemonRepository pokemonRepository;

    public PokemonController(PokemonIntegrationService pokemonIntegrationService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findById(@PathVariable Long id) {
        return (ResponseEntity<Pokemon>) ResponseEntity.ok(this.pokemonIntegrationService.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Pokemon> findByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pokemonIntegrationService.findByName(name));

    }
    @GetMapping
    public List <PokemonDto> list(int weight){
        if(weight <= 50) {
            List<Pokemon> pokemons = pokemonRepository.findAll();
            return PokemonDto.converter(pokemons);
        } else {
            List<Pokemon> pokemons = pokemonRepository.findByPokemonWeight(weight);
            return PokemonDto.converter(pokemons);
        }
    }

    @PostMapping
    public ResponseEntity<Pokemon> create(@RequestBody @Valid Pokemon pokemon) {
       return new ResponseEntity<>(pokemonIntegrationService.create(pokemon), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Pokemon> remove(@PathVariable String name) {
        pokemonRepository.deleteByName(name);
        return ResponseEntity.ok().build();
    }

}
