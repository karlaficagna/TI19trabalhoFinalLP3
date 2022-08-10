package com.ficagna.pokedexapiLP3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Table(schema = "pokedex")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column
    private int height;

    @Column
    private int weight;

    public Pokemon(List<Pokemon> pokemons) {
    }


//    private List<Type> types;
//    private List<Move> moves;
}
