package com.github.cc3002.finalreality.model.character.player;


import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Mage extends PlayerCharacter{

    private final MageType type;
    private final int mana;

    /**
     * Creates a new mage character.
     *
     * @param name
     *     the mage character's name
     * @param points
     *    the mage character's points
     * @param defense
     *     the mage character's defense
     * @param type
     *     the mage character's type
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param mana
     *     the mage character's mana
     */

    public Mage(String name, int points, int defense, MageType type, @NotNull BlockingQueue<ICharacter> turnsQueue,
                int mana){
        super(name, points, defense, turnsQueue);
        this.type = type;
        this.mana = mana;
    }

    /**
     * Returns the type of this mage.
     */
    public MageType getMageType(){
        return type;
    }

    /**
     * Returns the mana of this mage.
     */
    public int getMana(){
        return mana;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mage)) {
            return false;
        }
        final Mage that = (Mage) o;
        return getMageType() == that.getMageType()
                && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMageType(), getName());
    }
}
