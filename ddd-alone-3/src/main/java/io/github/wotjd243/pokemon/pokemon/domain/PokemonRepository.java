package io.github.wotjd243.pokemon.pokemon.domain;

public interface PokemonRepository {
    Pokemon findById(NationalPokedexNumber number);
}
