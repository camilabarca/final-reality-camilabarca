package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class for the phase when a player of the game is playing
 * @author Camila Labarca
 */

public class PlayCharacterPhase extends Phase{
    private final IPlayerCharacter character;

    public PlayCharacterPhase(IPlayerCharacter character) {
        this.character = character;
        this.canEquip = true;
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
        return "Play Character Phase";
    }

    @Override
    public void equipWeapon(IPlayerCharacter character, int i) throws InvalidMovementException {
        super.equipWeapon(character, i);
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
