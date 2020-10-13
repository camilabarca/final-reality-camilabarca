package com.github.cc3002.finalreality.model.weapon;

public class Bow extends AbstractWeapon {

    /**
     * Creates a new bow.
     *
     * @param name
     *     the bow's name
     * @param damage
     *    the bow's points
     * @param weight
     *     the bow's defense
     */

    public Bow(final String name, final int damage, final int weight) {
        super(name, damage,weight);

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bow)) {
            return false;
        }
        final Bow weapon = (Bow) o;
        return getDamage() == weapon.getDamage()  &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName());
    }

}
