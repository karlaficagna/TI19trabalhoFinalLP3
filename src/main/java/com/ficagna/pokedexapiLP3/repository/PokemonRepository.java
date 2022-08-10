package com.ficagna.pokedexapiLP3.repository;

import com.ficagna.pokedexapiLP3.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query("SELECT pk FROM Pokemon pk WHERE pk.weight = :weight")
    List<Pokemon> findByPokemonWeight(@Param("weight") int weight);

    @Query("SELECT pk FROM Pokemon pk WHERE pk.id = :id")
    Optional<Pokemon> findById(@Param("id") Long id);

    @Query("SELECT pk FROM Pokemon pk WHERE pk.name LIKE %:name%")
    Optional<Pokemon> findByName(@Param("name") String name);

    @Query("SELECT pk FROM Pokemon pk WHERE pk.name LIKE %:name% AND pkdeleted = false")
    Optional<Pokemon> findByNameAndNotDeleted(@Param("name") String name);

    @Query("SELECT count(pk) FROM Pokemon pk WHERE pk.name LIKE %:name%")
    Integer pokeAlreadyExistsInternallyByName(@Param("name") String name);

    void deleteByName(String name);

    Pokemon delete(String pokemon);
}
