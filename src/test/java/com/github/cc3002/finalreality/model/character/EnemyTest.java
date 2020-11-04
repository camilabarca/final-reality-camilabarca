package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Enemy} class.
 *
 * @author Camila Labarca
 * @see Enemy
 */

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private Enemy enemy;

  @BeforeEach
  void setUp() {
    super.basicSetUp();
    enemy = new Enemy(ENEMY_NAME, 10,10, 10, 10, turns);

  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, 10,10, 10, turns),
            enemy,
            new Enemy(ENEMY_NAME, 11,11, 11, 11, turns),
            new Knight(ENEMY_NAME, 10,10, turns));
  }

  @Test
  void waitTurnTest() {
    checkWaitTurn(enemy);
  }

  @Test
  void attackTest() {
    Knight knight = new Knight(ENEMY_NAME, 10,0, turns);
    checkAttack(enemy, knight);
    assertEquals(10 - (enemy.getDamage() - knight.getDefense()), knight.getPoints());
    assertFalse(knight.isAlive());
    assertTrue(enemy.isAlive());
  }

  @Test
  void attackedByEnemyTest() {
    Enemy enemy1 = new Enemy("enemy", 10,2,10, 20, turns);
    checkAttack(enemy1, enemy);
    assertEquals(10 - (enemy1.getDamage() - enemy.getDefense()), enemy.getPoints());
    assertFalse(enemy.isAlive());
    assertTrue(enemy1.isAlive());
  }

  @Test
  void attackedByPlayerTest() {
    Knight knight = new Knight(ENEMY_NAME, 10,0, turns);
    Sword sword = new Sword("sword",20, 10);
    knight.equip(sword);
    checkAttack(knight, enemy);
    assertEquals(10 - (knight.getEquippedWeapon().getDamage()- enemy.getDefense()), enemy.getPoints());
    assertFalse(enemy.isAlive());
    assertTrue(knight.isAlive());
  }

}