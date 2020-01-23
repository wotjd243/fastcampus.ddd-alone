package io.github.wotjd243.pokemon.trainer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, String> {
}
