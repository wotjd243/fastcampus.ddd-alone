package io.github.wotjd243.pokemon.game.domain.pokeball;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PokeBall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double multiplier;

    protected PokeBall() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PokeBall pokeBall = (PokeBall) o;
        return Objects.equals(id, pokeBall.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
