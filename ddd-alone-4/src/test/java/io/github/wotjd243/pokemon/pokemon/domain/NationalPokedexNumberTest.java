package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NationalPokedexNumberTest {
    @Test
    void equals() {
        final NationalPokedexNumber actual = NationalPokedexNumber.valueOf(1);
        assertThat(actual).isEqualTo(NationalPokedexNumber.valueOf(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 152})
    void constructor(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> NationalPokedexNumber.valueOf(number));
    }
}
