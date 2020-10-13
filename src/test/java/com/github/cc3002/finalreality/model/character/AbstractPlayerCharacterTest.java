package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.ArrayList;
import java.util.List;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.Axe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of player characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 * @see IPlayerCharacter
 */

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {
  protected List<IPlayerCharacter> testPlayerCharacters;
  protected AbstractWeapon testWeapon;

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip((IPlayerCharacter) testCharacters.get(0));
    super.waitTurnTest();
  }

  /**
   * Checks that the character equips correctly.
   */
  @Test
  void equipWeaponTest() {
    for (var character :
            testPlayerCharacters) {
      assertNull(character.getEquippedWeapon());
      character.equip(testWeapon);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }

  private void tryToEquip(IPlayerCharacter character) {
    character.equip(testWeapon);
  }


  protected void basicSetUp() {
    super.basicSetUp();
    testWeapon = new Axe("Test", 15,10);
    testPlayerCharacters = new ArrayList<>();

  }

}
