package io.github.wotjd243.pokemon.trainer.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaughtPokemonEvent;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(final TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Transactional
    public Trainer join(final String id) {
        return trainerRepository.save(new Trainer(id));
    }

    @Transactional
    public Trainer levelUp(final String id) {
        final Trainer trainer = getTrainer(id);
        trainer.levelUp();
        return trainer;
    }

    @EventListener
    public void addPokemon(final CaughtPokemonEvent event) {
        final Trainer trainer = getTrainer("jason");
        trainer.addPokemon(event.getNumber(), event.getName());
    }

    private Trainer getTrainer(final String id) {
        return trainerRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
