package io.github.wotjd243.pokemon.game.domain.trainer;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Party {
    private static final int MAXIMUM_MEMBER_SIZE = 6;

    @ElementCollection
    private List<PokemonCaught> members = new ArrayList<>();

    protected Party() {
    }

    Party(final List<PokemonCaught> members) {
        if (members.size() > MAXIMUM_MEMBER_SIZE) {
            throw new IllegalStateException();
        }
        this.members = new ArrayList<>(members);
    }

    void add(final PokemonCaught member) {
        if (members.size() >= MAXIMUM_MEMBER_SIZE) {
            throw new IllegalStateException();
        }
        members.add(member);
    }

    List<PokemonCaught> toList() {
        return new ArrayList<>(members);
    }
}
