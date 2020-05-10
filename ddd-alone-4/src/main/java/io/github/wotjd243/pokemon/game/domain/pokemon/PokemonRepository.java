package io.github.wotjd243.pokemon.game.domain.pokemon;

public interface PokemonRepository {
    Pokemon findById(NationalPokedexNumber number);
}
