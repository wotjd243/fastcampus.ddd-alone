package io.github.wotjd243.pokemon.game.infra;

import io.github.wotjd243.pokemon.game.domain.pokemon.NationalPokedexNumber;
import io.github.wotjd243.pokemon.game.domain.pokemon.Pokemon;
import io.github.wotjd243.pokemon.game.domain.pokemon.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Repository;

@Repository
public class PokeApiPokemonRepository implements PokemonRepository {
    @Override
    public Pokemon findById(final NationalPokedexNumber number) {
        final PokeApiClient pokeApiClient = new PokeApiClient();
        final PokemonSpecies pokemonSpecies = pokeApiClient.getPokemonSpecies(number.toInt());
        return new Pokemon(pokemonSpecies.getId(), pokemonSpecies.getName(), pokemonSpecies.getCaptureRate());
    }
}
