package io.github.wotjd243.pokemon.game.domain.pokemon;

import java.util.Objects;

public class CaptureRate {
    private static final int MINIMUM_RATE = 3;
    private static final int MAXIMUM_RATE = 255;

    private final int rate;

    private CaptureRate(final int rate) {
        validate(rate);
        this.rate = rate;
    }

    static CaptureRate valueOf(final int captureRate) {
        return new CaptureRate(captureRate);
    }

    int toInt() {
        return rate;
    }

    private void validate(final int rate) {
        if (rate < MINIMUM_RATE || rate > MAXIMUM_RATE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CaptureRate that = (CaptureRate) o;
        return rate == that.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }
}
