package io.github.wotjd243.pokemon.game.domain.trainer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Level {
    private static final int MINIMUM_LEVEL = 1;
    private static final int MAXIMUM_LEVEL = 30;
    private static final int BONUS_LEVEL = 11;

    static final Level ONE = new Level(MINIMUM_LEVEL);

    @Column(nullable = false)
    private int level;

    protected Level() {
    }

    Level(final int level) {
        validate(level);
        this.level = level;
    }

    Level up() {
        if (level < MAXIMUM_LEVEL) {
            return new Level(level + 1);
        }
        return this;
    }

    int bonus() {
        if (hasBonus()) {
            return calculatedBonus();
        }
        return 1;
    }

    int toInt() {
        return level;
    }

    private void validate(final int level) {
        if (level < MINIMUM_LEVEL || level > MAXIMUM_LEVEL) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasBonus() {
        return level >= BONUS_LEVEL;
    }

    private int calculatedBonus() {
        return level / 10;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Level level1 = (Level) o;
        return level == level1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
