package io.github.wotjd243.pokemon.trainer.ui;

import io.github.wotjd243.pokemon.trainer.application.TrainerService;
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
    public ResponseEntity join(@PathVariable final String id) {
        return ResponseEntity.created(URI.create("/api/trainers"))
                .body(trainerService.join(id))
                ;
    }

    @GetMapping("/api/trainers/{id}/level-up")
    public ResponseEntity levelUp(@PathVariable final String id) {
        return ResponseEntity.ok()
                .body(trainerService.levelUp(id))
                ;
    }
}
