package io.github.wotjd243.pokemon.game.application;

import io.github.wotjd243.pokemon.game.domain.trainer.Trainer;
import io.github.wotjd243.pokemon.game.domain.trainer.TrainerRepository;
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
}
