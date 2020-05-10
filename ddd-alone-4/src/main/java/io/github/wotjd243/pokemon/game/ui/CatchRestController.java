package io.github.wotjd243.pokemon.game.ui;

import io.github.wotjd243.pokemon.game.application.PokemonCatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatchRestController {
    private final PokemonCatchService pokemonCatchService;

    public CatchRestController(final PokemonCatchService pokemonCatchService) {
        this.pokemonCatchService = pokemonCatchService;
    }

    @GetMapping("/api/trainers/{trainerId}/catches/{number}/with/{pokeBallId}")
    public ResponseEntity<Boolean> catches(
            @PathVariable final String trainerId,
            @PathVariable final Integer number,
            @PathVariable final Long pokeBallId
    ) {
        return ResponseEntity.ok()
                .body(pokemonCatchService.catches(trainerId, number, pokeBallId))
                ;
    }
}
