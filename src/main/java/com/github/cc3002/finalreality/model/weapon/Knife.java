package com.github.cc3002.finalreality.model.weapon;

public class Knife extends AbstractWeapon {

    /**
     * Creates a new knife.
     *
     * @param name
     *     the knife's name
     * @param damage
     *    the knife's points
     * @param weight
     *     the knife's defense
     */

    public Knife(final String name, final int damage, final int weight) {
        super(name, damage,weight);

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Knife)) {
            return false;
        }
        final Knife weapon = (Knife) o;
        return getDamage() == weapon.getDamage()  &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }

}
