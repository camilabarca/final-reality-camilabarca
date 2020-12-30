package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.Sword;

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
    enemy = new Enemy(ENEMY_NAME, 10,10, 10, 10);

  }

  /**
   * Checks the construction of an enemy
   */
  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, 10,10, 10),
            enemy,
            new Enemy(ENEMY_NAME, 11,11, 11, 11),
            new Knight(ENEMY_NAME, 10,10));
    assertEquals(10, enemy.getDamage());
  }

  /**
   * Checks an enemy attacks correctly
   */
  @Test
  void attackTest() {
    Knight knight = new Knight(ENEMY_NAME, 10,0);
    checkAttack(enemy, knight);
    assertEquals(0, knight.getPoints());
    assertFalse(knight.isAlive());
    assertTrue(enemy.isAlive());
  }

  /**
   * Checks an enemy receives the attack from another enemy correctly
   */
  @Test
  void attackedByEnemyTest() {
    Enemy enemy1 = new Enemy("enemy", 10,2,10, 20);
    checkAttack(enemy1, enemy);
    assertEquals(0, enemy.getPoints());
    assertFalse(enemy.isAlive());
    enemy.attack(enemy1);
    assertEquals(10, enemy1.getPoints());
    assertTrue(enemy1.isAlive());
  }

  /**
   * Checks an enemy receives the attack from a player correctly
   */
  @Test
  void attackedByPlayerTest() {
    Knight knight = new Knight(ENEMY_NAME, 10,0);
    Sword sword = new Sword("sword",20, 10);
    knight.equip(sword);
    checkAttack(knight, enemy);
    assertEquals(0, enemy.getPoints());
    assertFalse(enemy.isAlive());
    assertTrue(knight.isAlive());
  }

}