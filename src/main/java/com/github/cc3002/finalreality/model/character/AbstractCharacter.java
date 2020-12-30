package com.github.cc3002.finalreality.model.character;


import java.beans.PropertyChangeEvent;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.controller.handlers.IEventHandler;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final String name;
  public int points;
  protected final int defense;
  protected ScheduledExecutorService scheduledExecutor;
  public boolean alive;

  private IEventHandler characterOut;
  private IEventHandler meetsTimer;
  private IEventHandler endTurn;

  protected AbstractCharacter(@NotNull String name, int points, int defense) {
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
    scheduledExecutor.shutdown();
    if (meetsTimer != null){
      meetsTimer.propertyChange(new PropertyChangeEvent(this, "Character met timer",null, null));
    }
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

  /**
   * Sets the character's points.
   */
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

  /**
   * Adds listener for the death of a character.
   */
  public void addListener(IEventHandler eventHandler){
    this.characterOut = eventHandler;
  }

  /**
   * Adds listeners for when the character is added to the queue and for when the character
   * attacks and its turn ends.
   */
  public void addListener1(IEventHandler timer, IEventHandler turn){
    this.meetsTimer = timer;
    this.endTurn = turn;
  }

  /**
   * A character receives de damage caused by the attack of its attacker.
   */
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

  @Override
  public void attack(ICharacter character){
    if (endTurn != null){
      endTurn.propertyChange(new PropertyChangeEvent(this, "Character ended turn", null, null));
    }
  }

  /**
   * Returns if the character is alive or not.
   */
  public boolean isAlive(){
    return this.alive;
  }
}