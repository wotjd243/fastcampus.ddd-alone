package io.github.wotjd243.pokemon.pokemon.infra;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;

public class DummyPokemonRepository implements PokemonRepository {
    @Override
    public Pokemon findById(final NationalPokedexNumber number) {
        return DummyPokemonData.get(number);
    }
}
