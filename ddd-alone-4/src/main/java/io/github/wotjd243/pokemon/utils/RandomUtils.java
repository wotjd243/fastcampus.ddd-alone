package io.github.wotjd243.pokemon.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt(final int from, final int to) {
        return RANDOM.nextInt(from + to) - from + 1;
    }
}
