package io.github.wotjd243.pokemon.game.domain.pokemon;

import io.github.wotjd243.pokemon.game.domain.pokeball.PokeBall;
import io.github.wotjd243.pokemon.game.domain.pokeball.PokeBallRepository;
import io.github.wotjd243.pokemon.game.domain.trainer.Trainer;
import io.github.wotjd243.pokemon.game.domain.trainer.TrainerRepository;
import io.github.wotjd243.pokemon.utils.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class CatchService {
    private static final int CENT = 100;
    private static final int MINIMUM_CAPTURE_RATE = 255;

    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;
    private final PokeBallRepository pokeBallRepository;

    public CatchService(
            final TrainerRepository trainerRepository,
            final PokemonRepository pokemonRepository,
            final PokeBallRepository pokeBallRepository
    ) {
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokeBallRepository = pokeBallRepository;
    }

    public boolean catches(final String trainerId, final Integer number, final Long pokeBallId) {
        final Trainer trainer = getTrainer(trainerId);
        final Pokemon pokemon = getPokemon(number);
        final PokeBall pokeBall = getPokeBall(pokeBallId);

        final boolean catchable = catchable(trainer, pokemon, pokeBall);
        if (catchable) {
            trainer.addPokemon(pokemon.getNumber(), pokemon.getName());
        }
        return catchable;
    }

    private boolean catchable(final Trainer trainer, final Pokemon pokemon, final PokeBall pokeBall) {
        return RandomUtils.nextInt(1, 100)
                <= percentage(pokemon.getCaptureRate() * pokeBall.getMultiplier() * trainer.bonus());
    }

    private double percentage(final double rate) {
        return rate * CENT / MINIMUM_CAPTURE_RATE;
    }

    private Trainer getTrainer(final String trainerId) {
        return trainerRepository.findById(trainerId)
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    private Pokemon getPokemon(final Integer number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }

    private PokeBall getPokeBall(final Long pokeBallId) {
        return pokeBallRepository.findById(pokeBallId)
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
