package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.Objects;

public class Thief extends PlayerCharacter {
    /**
     * Creates a new Thief character.
     *
     * @param name       the common character's name
     * @param points     the common character's points
     * @param defense    the common character's defense
     */
    public Thief(String name, int points, int defense) {
        super(name, points, defense);
    }

    @Override
    public void equip(IWeapon weapon){
        if(this.isAlive()){
            weapon.equipToThief(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        return o instanceof Thief && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Thief.class);
    }

}
