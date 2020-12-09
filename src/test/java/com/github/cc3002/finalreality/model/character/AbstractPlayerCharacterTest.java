package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Abstract class containing the common tests for all the types of player characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 * @see IPlayerCharacter
 */

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {

  public Sword sword = new Sword("sword",1, 10);
  public Axe axe = new Axe("axe", 1,10);
  public Knife knife = new Knife("knife", 1, 10);
  public Staff staff = new Staff("staff", 1, 10, 1);
  public Bow bow = new Bow("bow",1 , 10);


  /**
   * Checks that the character equips correctly.
   */

  protected void checkEquippedWeapon(IPlayerCharacter character, IWeapon weapon) {
    assertNull(character.getEquippedWeapon());
    character.equip(weapon);
    assertEquals(weapon, character.getEquippedWeapon());
  }

  protected void checkNotEquippedWeapon(IPlayerCharacter character, IWeapon weapon){
    assertNull(character.getEquippedWeapon());
    character.equip(weapon);
    assertNull(character.getEquippedWeapon());
  }


}
