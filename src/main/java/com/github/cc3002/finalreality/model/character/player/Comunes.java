package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Comunes extends PlayerCharacter{

    private final ComunesType type;

    /**
     * Creates a new common character.
     *
     * @param name
     *     the common character's name
     * @param points
     *    the common character's points
     * @param defense
     *     the common character's defense
     * @param type
     *     the common character's type
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */

    public Comunes(String name, int points, int defense, ComunesType type, @NotNull BlockingQueue<ICharacter> turnsQueue){
        super(name, points, defense, turnsQueue);
        this.type = type;
    }

    /**
     * Returns the type of this common character.
     */
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

