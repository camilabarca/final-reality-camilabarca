package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds all the behaviour of all the player characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 */
public abstract class PlayerCharacter extends AbstractCharacter implements IPlayerCharacter{

  private Weapon equippedWeapon = null;

  public PlayerCharacter(@NotNull String name, int points, int defense,
      @NotNull BlockingQueue<ICharacter> turnsQueue) {
    super(turnsQueue, name, points, defense);
  }

  @Override
  public void equip(Weapon weapon){
    this.equippedWeapon = weapon;
  }

  @Override
  public Weapon getEquippedWeapon(){
    return equippedWeapon;
  }

  @Override
  public void waitTurn(){
    super.waitTurn();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);

  }

}
