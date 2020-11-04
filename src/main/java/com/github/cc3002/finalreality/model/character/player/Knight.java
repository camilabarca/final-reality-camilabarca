package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Knight extends PlayerCharacter{
    /**
     * Creates a new common character.
     *
     * @param name       the common character's name
     * @param points     the common character's points
     * @param defense    the common character's defense
     * @param turnsQueue
     */
    public Knight(String name, int points, int defense,  @NotNull BlockingQueue<ICharacter> turnsQueue) {
        super(name, points, defense, turnsQueue);
    }

    @Override
    public void equip(IWeapon weapon){
        weapon.equipToKnight(this);
    }

    @Override
    public boolean equals(final Object o) {
        return o instanceof Knight && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Knight.class);
    }

}
