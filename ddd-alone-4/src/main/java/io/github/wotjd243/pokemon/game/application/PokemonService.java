package io.github.wotjd243.pokemon.game.application;

import io.github.wotjd243.pokemon.game.domain.pokemon.NationalPokedexNumber;
import io.github.wotjd243.pokemon.game.domain.pokemon.Pokemon;
import io.github.wotjd243.pokemon.game.domain.pokemon.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon find(final Integer number) {
        return getPokemon(number);
    }

    private Pokemon getPokemon(final Integer number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }
}
