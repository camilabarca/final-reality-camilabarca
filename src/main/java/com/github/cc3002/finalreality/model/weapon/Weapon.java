package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class Weapon {

  private final String name;
  private final int damage;
  private final int magicdamage;
  private final int weight;
  private final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @see WeaponType
   */
  public Weapon(final String name, final int damage, final int magicdamage, final int weight,
      final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.magicdamage = magicdamage;
    this.weight = weight;
    this.type = type;
  }

  private String getName() {
    return name;
  }

  private int getDamage() {
    return damage;
  }

  private int getMagicdamage() {return magicdamage; }

  public int getWeight() {
    return weight;
  }

  private WeaponType getType() {
    return type;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getDamage() == weapon.getDamage() && getMagicdamage() == weapon.getMagicdamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()) &&
        getType() == weapon.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getMagicdamage(), getWeight(), getType());
  }
}
