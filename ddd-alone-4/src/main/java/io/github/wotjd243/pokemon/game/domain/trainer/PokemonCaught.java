package io.github.wotjd243.pokemon.game.domain.trainer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PokemonCaught {
    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String nickname;

    protected PokemonCaught() {
    }

    public PokemonCaught(final int number, final String nickname) {
        this.number = number;
        this.nickname = nickname;
    }

    int getNumber() {
        return number;
    }

    String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PokemonCaught that = (PokemonCaught) o;
        return number == that.number &&
                Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, nickname);
    }
}
