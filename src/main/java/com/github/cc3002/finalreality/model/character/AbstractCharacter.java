package com.github.cc3002.finalreality.model.character;


import java.beans.PropertyChangeEvent;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.controller.IEventHandler;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  public int points;
  protected final int defense;
  protected ScheduledExecutorService scheduledExecutor;
  public boolean alive;

  private IEventHandler characterOut;

  protected AbstractCharacter(@NotNull String name, int points, int defense, @NotNull BlockingQueue<ICharacter> turnsQueue) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.points = points;
    this.defense = defense;
    this.alive = true;
  }

  /**
   * Adds this character to the turns queue.
   */
  @Override
  public void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPoints() {
    return points;
  }

  public void setPoints(int points){
    this.points = points;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(AbstractCharacter.class, getName());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractCharacter)) {
      return false;
    }
    final AbstractCharacter that = (AbstractCharacter) o;
    return getName().equals(that.getName());
  }


  public void addListener(IEventHandler eventHandler){
    this.characterOut = eventHandler;
  }

  public void attackedBy(int damage){
    if (damage >= this.getPoints()){
      this.setPoints(0);
      this.alive = false;
      if (this.characterOut != null){
        (this.characterOut).propertyChange(new PropertyChangeEvent(this, "deadCharacter",null, null));
      }
    }else{
      this.setPoints(this.getPoints()-damage);
    }
  }

  /**
   * Returns if the character is alive or not.
   */
  public boolean isAlive(){
    return this.alive;
  }
}