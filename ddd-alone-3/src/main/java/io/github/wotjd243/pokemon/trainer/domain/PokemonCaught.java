package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class PokemonCaught {
    private int number;
    private String nickname;

    protected PokemonCaught() {
    }

    public PokemonCaught(final int number, final String nickname) {
        this.number = number;
        this.nickname = nickname;
    }

    public int getNumber() {
        return number;
    }

    public String getNickname() {
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
