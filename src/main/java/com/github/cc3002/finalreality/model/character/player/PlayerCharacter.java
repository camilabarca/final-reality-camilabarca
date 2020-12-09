package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds all the behaviour of all the player characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 */
public abstract class PlayerCharacter extends AbstractCharacter implements IPlayerCharacter{

  public IWeapon equippedWeapon = null;

  public PlayerCharacter(@NotNull String name, int points, int defense,
                         @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(name, points, defense, turnsQueue);
  }

  @Override
  public IWeapon getEquippedWeapon(){
    return equippedWeapon;
  }

  @Override
  public void waitTurn() {
    super.waitTurn();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public int hashCode() {
    return Objects
            .hash(super.hashCode(), PlayerCharacter.class, getEquippedWeapon());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return Objects.equals(getEquippedWeapon(), that.getEquippedWeapon());
  }


  @Override
  public void attack(ICharacter c) {
    if (this.isAlive()){
      c.attackedByPlayer(this);
    }
  }

  @Override
  public void attackedByEnemy(Enemy charac) {
    this.attackedBy((charac.damage - this.defense));
  }

  @Override
  public void attackedByPlayer(IPlayerCharacter charac) {
    this.attackedBy((charac.getEquippedWeapon().getDamage() - this.defense));
  }

}
