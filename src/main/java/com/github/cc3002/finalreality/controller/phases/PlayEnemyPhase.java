package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;


/**
 * A class for the phase when a enemy of the game is playing
 * @author Camila Labarca
 */
public class PlayEnemyPhase extends Phase{
    private final Enemy character;

    public PlayEnemyPhase(Enemy character) {
        this.character = character;
        this.canEquip = false;
        this.canAttack = true;
    }

    @Override
    public void toWaitQueuePhase(){
        changePhase(new WaitQueuePhase());
    }

    @Override
    public void toPollPhase(){
        changePhase(new PollPhase());
    }

    @Override
    public String toString() {
        return "Play Enemy Phase";
    }


    @Override
    public void attack(ICharacter character, ICharacter opponent) throws InvalidMovementException {
        super.attack(character, opponent);
        if (controller.getTurns().isEmpty()){
            toWaitQueuePhase();
        } else {
            toPollPhase();
        }
    }


}
