package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends AbstractWeapon {

    private final int magicdamage;

    /**
     * Creates a new staff.
     *
     * @param name
     *     the staff's name
     * @param damage
     *    the staff's damage
     * @param weight
     *     the staff's defense
     * @param magicdamage
     *     the staff's magicdamage
     */

    public Staff(final String name, final int damage, final int weight, final int magicdamage) {
        super(name, damage, weight);
        this.magicdamage = magicdamage;

    }

    public int getMagicdamage() {
        return magicdamage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff weapon = (Staff) o;
        return getDamage() == weapon.getDamage()  &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName()) && getMagicdamage() == weapon.getMagicdamage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight(), getMagicdamage());
    }
}




