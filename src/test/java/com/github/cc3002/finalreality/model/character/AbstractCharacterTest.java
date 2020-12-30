package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 * @see ICharacter
 */

public abstract class AbstractCharacterTest {

  /**
   * Checks the construction of a character
   */
  protected void checkConstruction(final ICharacter expectedCharacter,
                                   final ICharacter testEqualCharacter,
                                   final ICharacter sameClassDifferentCharacter,
                                   final ICharacter differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
    assertEquals(expectedCharacter.getDefense(), testEqualCharacter.getDefense());
  }

  /**
   * Checks a character's attack
   */
  protected void checkAttack(ICharacter attacker, ICharacter attacked){
    assertTrue(attacker.isAlive());
    assertTrue(attacked.isAlive());
    attacker.attack(attacked);

  }

}
