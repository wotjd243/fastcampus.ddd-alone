package io.github.wotjd243.pokemon.game.application;

import io.github.wotjd243.pokemon.game.domain.pokemon.CatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonCatchService {
    private final CatchService catchService;

    public PokemonCatchService(final CatchService catchService) {
        this.catchService = catchService;
    }

    @Transactional
    public boolean catches(final String trainerId, final Integer number, final Long pokeBallId) {
        return catchService.catches(trainerId, number, pokeBallId);
    }
}
