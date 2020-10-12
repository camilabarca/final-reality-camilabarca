package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;
/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Camila Labarca
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int damage;

  /**
   * Creates a new enemy with a name, points, defense, a weight, damage and the queue
   * with the characters ready to play.
   */
  public Enemy(@NotNull final String name, final int points, final int defense, final int weight, final int damage,
      @NotNull final BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, points, defense);
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the damage of this enemy.
   */
  public int getDamage() {
    return damage;
  }

  @Override
  public void waitTurn(){
    super.waitTurn();
    scheduledExecutor
            .schedule(this::addToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }
  @Override
  public void addToQueue(){
    super.addToQueue();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight() && getDamage() == enemy.getDamage();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight(), Objects.hash(getDamage()));
  }
}
