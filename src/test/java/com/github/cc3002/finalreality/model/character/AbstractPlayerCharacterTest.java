package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.github.cc3002.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.weapon.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code GameCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 * @see PlayerCharacter
 */
public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {
  protected List<IPlayerCharacter> testPlayerCharacters;
  protected Weapon testWeapon;

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip((IPlayerCharacter) testCharacters.get(0));
    super.waitTurnTest();
  }

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
    testWeapon = new Weapon("Test", 15,10, WeaponType.AXE);
    testPlayerCharacters = new ArrayList<>();

  }

}
