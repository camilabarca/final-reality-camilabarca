package com.github.cc3002.finalreality.model.character;


import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Adds a character to the list {@code turnsQueue}.
   */
  void addToQueue();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's points.
   */
  int getPoints();

  /**
   * Returns this character defense.
   */
  int getDefense();

  /**
   * Attacks ICharacter c.
   */
  void attack(ICharacter c);

  /**
   * The character was attacked by an Enemy charac.
   */
  void attackedByEnemy(Enemy charac);

  /**
   * The character was attacked by a IPlayerCharacter character.
   */
  void attackedByPlayer(IPlayerCharacter character);

  /**
   * Returns true if the character is still alive.
   */
  boolean isAlive();

}
