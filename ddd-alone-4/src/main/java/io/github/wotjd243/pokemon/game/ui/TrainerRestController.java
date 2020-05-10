package io.github.wotjd243.pokemon.game.ui;

import io.github.wotjd243.pokemon.game.application.TrainerService;
import io.github.wotjd243.pokemon.game.domain.trainer.Trainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class TrainerRestController {
    private final TrainerService trainerService;

    public TrainerRestController(final TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/api/trainers/{id}")
    public ResponseEntity<Trainer> join(@PathVariable final String id) {
        final Trainer created = trainerService.join(id);
        final URI uri = URI.create("/api/trainers/" + created.getId());
        return ResponseEntity.created(uri)
                .body(created)
                ;
    }
}
