package io.github.wotjd243.pokemon.pokemon.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PokemonService(
            final PokemonRepository pokemonRepository,
            final ApplicationEventPublisher applicationEventPublisher
    ) {
        this.pokemonRepository = pokemonRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Pokemon find(final int number) {
        return getPokemon(number);
    }

    @Transactional
    public boolean capture(final int number, final int captureRate) {
        final Pokemon pokemon = getPokemon(number);
        final boolean caught = pokemon.isCaught(captureRate);
        if (caught) {
            applicationEventPublisher.publishEvent(new CaughtPokemonEvent(pokemon.getNumber(), pokemon.getName()));
        }
        return caught;
    }

    private Pokemon getPokemon(final int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }
}
