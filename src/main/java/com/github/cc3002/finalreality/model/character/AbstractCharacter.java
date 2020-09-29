package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected final int points;
  protected final String defense;
  protected final ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, int points, String defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.points = points;
    this.defense = defense;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

  }

  /**
   * Adds this character to the turns queue.
   */
  @Override
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPoints() {
      return points;
  }

  @Override
  public String getDefense() {
      return defense;
  }

