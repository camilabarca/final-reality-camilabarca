package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A common class for the phases of the game.
 * @author Camila Labarca
 */

public class Phase {
    protected GameController controller;
    protected boolean canEquip = false;
    protected boolean canAttack = false;

    /**
     * Sets the controller
     */
    public void setController(GameController controller){
        this.controller = controller;
    }

    /**
     * Changes the phase
     */
    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * Moves to the poll phase
     */
    public void toPollPhase() throws InvalidTransitionException{
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to Poll Phase");
    }

    /**
     * Moves to the phase of an empty queue
     */
    public void toWaitQueuePhase() throws InvalidTransitionException{
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to Wait Queue Phase");
    }

    /**
     * Moves to the phase of a character playing
     */
    public void toPlayCharacterPhase(IPlayerCharacter character) throws InvalidTransitionException{
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to Play Character Phase");
    }

    /**
     * Moves to the phase of an enemy playing
     */
    public void toPlayEnemyPhase(Enemy character) throws InvalidTransitionException{
        throw new InvalidTransitionException(
                "Can't change from " + this.toString() + " to Play Enemy Phase");
    }

    /**
     * Does the task that corresponds to the phase
     */
    public void task() throws InvalidMovementException {
        throw new InvalidMovementException(
                "Can't do this task in " + this.toString());
    }

    /**
     * Equips a character if it's in the correct phase
     */
    public void equipWeapon(IPlayerCharacter character, int i) throws InvalidMovementException {
        if (!canEquip) {
            throw new InvalidMovementException("You can't equip");
        }
        controller.equipCharacter(character, i);
    }

    /**
     * Attacks a character if it's in the correct phase
     */
    public void attack(ICharacter character, ICharacter opponent) throws InvalidMovementException {
        if (!canAttack) {
            throw new InvalidMovementException("You can't attack");
        }
        controller.attack(character, opponent);
    }

}
