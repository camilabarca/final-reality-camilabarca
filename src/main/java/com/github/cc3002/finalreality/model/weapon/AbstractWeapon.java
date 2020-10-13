package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * An abstract class that holds the common behaviour of all the weapons
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 */
public abstract class AbstractWeapon {

  private final String name;
  private final int damage;
  private final int weight;

  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * Returns the weapon's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the weapon's damage.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weapon's weight.
   */
  public int getWeight() {
    return weight;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight());
  }
}
