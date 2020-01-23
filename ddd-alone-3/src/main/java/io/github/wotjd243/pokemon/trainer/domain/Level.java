package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Level {
    private static final int MINIMUM_LEVEL = 1;
    private static final int MAXIMUM_LEVEL = 30;

    static final Level ONE = new Level(MINIMUM_LEVEL);

    private int level;

    protected Level() {
    }

    public Level(final int level) {
        validate(level);
        this.level = level;
    }

    Level up() {
        if (level < MAXIMUM_LEVEL) {
            return new Level(level + 1);
        }
        return this;
    }

    int toInt() {
        return level;
    }

    private void validate(final int level) {
        if (level < MINIMUM_LEVEL || level > MAXIMUM_LEVEL) {
            throw new IllegalArgumentException();
        }
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
