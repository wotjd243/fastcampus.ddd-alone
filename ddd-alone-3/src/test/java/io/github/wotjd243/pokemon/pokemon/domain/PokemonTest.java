package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonTest {
    @Test
    void constructor() {
        // given
        // when
        // then
        new Pokemon(1, "이상해씨", 45);
    }

    @DisplayName("일정 포획률을 초과하면 포켓몬이 포획된다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 200})
    void capture(final int captureRate) {
        // given
        final Pokemon pokemon = new Pokemon(1, "이상해씨", 45);

        // when
        final boolean capture = pokemon.isCaught(captureRate);

        // then
        assertThat(capture).isTrue();
    }
}
