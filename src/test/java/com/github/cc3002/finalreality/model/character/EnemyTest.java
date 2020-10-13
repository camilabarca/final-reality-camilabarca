package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Comunes;
import com.github.cc3002.finalreality.model.character.player.ComunesType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Enemy} class.
 *
 * @author Camila Labarca
 * @see Enemy
 */

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10,10, 10, 10, turns));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10,10, 10, 10,turns),
            testCharacters.get(0),
            new Enemy(ENEMY_NAME, 11, 11,11,11,turns),
            new Comunes(ENEMY_NAME,11, 11,  ComunesType.THIEF, turns));
  }

  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    super.waitTurnTest();
  }
}