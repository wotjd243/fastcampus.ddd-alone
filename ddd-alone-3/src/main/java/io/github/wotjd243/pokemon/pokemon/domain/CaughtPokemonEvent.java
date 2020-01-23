package io.github.wotjd243.pokemon.pokemon.domain;

public class CaughtPokemonEvent {
    private int number;
    private String name;

    public CaughtPokemonEvent(final int number, final String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
