package io.github.wotjd243.pokemon.game.domain.trainer;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Trainer {
    @Id
    private String id;

    @Embedded
    private Level level;

    @Embedded
    private Party party;

    protected Trainer() {
    }

    public Trainer(final String id) {
        this(id, Level.ONE, new Party(new ArrayList<>()));
    }

    public Trainer(final String id, final Level level, final Party party) {
        this.id = id;
        this.level = level;
        this.party = party;
    }

    public void addPokemon(final int number, final String name) {
        addPokemon(new PokemonCaught(number, name));
    }

    private void addPokemon(final PokemonCaught pokemonCaught) {
        party.add(pokemonCaught);
        levelUp();
    }

    private void levelUp() {
        level = level.up();
    }

    public int bonus() {
        return level.bonus();
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level.toInt();
    }

    public List<PokemonCaught> getParty() {
        return party.toList();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
