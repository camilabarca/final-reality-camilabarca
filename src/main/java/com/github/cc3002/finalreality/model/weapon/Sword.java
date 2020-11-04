package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

public class Sword extends AbstractWeapon {

    /**
     * Creates a new sword.
     *
     * @param name
     *     the sword's name
     * @param damage
     *    the sword's points
     * @param weight
     *     the sword's defense
     */

    public Sword(final String name, final int damage, final int weight) {
        super(name, damage,weight);

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sword)) {
            return false;
        }
        final Sword weapon = (Sword) o;
        return getDamage() == weapon.getDamage()  &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }


    @Override
    public void equipToKnight(Knight c) {
        c.equippedWeapon = this;
    }

    @Override
    public void equipToEngineer(Engineer c) {

    }

    @Override
    public void equipToThief(Thief c) {
        c.equippedWeapon = this;
    }

    @Override
    public void equipToWhiteMage(WhiteMage c) {

    }

    @Override
    public void equipToBlackMage(BlackMage c) {

    }
}
