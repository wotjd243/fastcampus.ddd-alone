package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.ElementCollection;
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

    @ElementCollection
    private List<PokemonCaught> party = new ArrayList<>();

    protected Trainer() {
    }

    public Trainer(final String id) {
        this(id, Level.ONE, new ArrayList<>());
    }

    public Trainer(final String id, final Level level, final List<PokemonCaught> party) {
        this.id = id;
        this.level = level;
        this.party = new ArrayList<>(party);
    }

    public void addPokemon(final int number, final String name) {
        party.add(new PokemonCaught(number, name));
        levelUp();
    }

    public void levelUp() {
        level = level.up();
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level.toInt();
    }

    public List<PokemonCaught> getParty() {
        return new ArrayList<>(party);
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
