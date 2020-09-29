package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class PlayerCharacter extends AbstractCharacter {

  private final CharacterClass characterClass;
  private Weapon equippedWeapon = null;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  public PlayerCharacter(@NotNull String name, String points, String defense,
      @NotNull BlockingQueue<ICharacter> turnsQueue,
      final CharacterClass characterClass) {
    super(turnsQueue, name, points, defense);
    this.characterClass = characterClass;
  }

  public void equip(Weapon weapon){
    this.equippedWeapon = weapon;
  }

  public Weapon getEquippedWeapon(){
    return equippedWeapon;
  }

  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  @Override
  public void waitTurn(){
    super.waitTurn();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);

  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }
}
