package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Comunes extends PlayerCharacter{
    private final ComunesType type;

    public Comunes(String name, int points, int defense, ComunesType type, @NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name, points, defense, turnsQueue);
        this.type = type;
    }

    public ComunesType getComunesType(){
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Comunes)) {
            return false;
        }
        final Comunes that = (Comunes) o;
        return getComunesType() == that.getComunesType()
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComunesType(), getName());
    }

}

