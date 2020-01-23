package io.github.wotjd243.pokemon.pokemon.infra;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Repository;

@Repository
public class PokeApiPokemonRepository implements PokemonRepository {
    @Override
    public Pokemon findById(final NationalPokedexNumber number) {
        final PokeApi pokeApi = new PokeApiClient();
        final PokemonSpecies pokemonSpecies = pokeApi.getPokemonSpecies(number.toInt());
        return new Pokemon(pokemonSpecies.getId(), pokemonSpecies.getName(), pokemonSpecies.getCaptureRate());
    }
}
