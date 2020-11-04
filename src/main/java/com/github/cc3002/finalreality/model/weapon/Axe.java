package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

public class Axe extends AbstractWeapon {

    /**
     * Creates a new axe.
     *
     * @param name
     *     the axe's name
     * @param damage
     *    the axe's points
     * @param weight
     *     the axe's defense
     */

    public Axe(final String name, final int damage, final int weight) {
        super(name, damage,weight);

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Axe)) {
            return false;
        }
        final Axe weapon = (Axe) o;
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
        c.equippedWeapon = this;
    }

    @Override
    public void equipToThief(Thief c) {

    }

    @Override
    public void equipToWhiteMage(WhiteMage c) {

    }

    @Override
    public void equipToBlackMage(BlackMage c) {

    }
}
