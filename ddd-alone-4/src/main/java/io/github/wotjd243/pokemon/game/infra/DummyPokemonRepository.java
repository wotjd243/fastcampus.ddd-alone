package io.github.wotjd243.pokemon.game.infra;

import io.github.wotjd243.pokemon.game.domain.pokemon.NationalPokedexNumber;
import io.github.wotjd243.pokemon.game.domain.pokemon.Pokemon;
import io.github.wotjd243.pokemon.game.domain.pokemon.PokemonRepository;

public class DummyPokemonRepository implements PokemonRepository {
    @Override
    public Pokemon findById(final NationalPokedexNumber number) {
        return DummyPokemonData.get(number);
    }
}
