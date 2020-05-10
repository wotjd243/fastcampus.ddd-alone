package io.github.wotjd243.pokemon.game.ui;

import io.github.wotjd243.pokemon.game.application.PokemonService;
import io.github.wotjd243.pokemon.game.domain.pokemon.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonRestController {
    private final PokemonService pokemonService;

    public PokemonRestController(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/api/pokemons/{number}")
    public ResponseEntity<Pokemon> find(@PathVariable final Integer number) {
        return ResponseEntity.ok()
                .body(pokemonService.find(number))
                ;
    }
}
