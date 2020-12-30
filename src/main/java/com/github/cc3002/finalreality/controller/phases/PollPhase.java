package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class for the phase when a character is taken from the blocking queue
 * @author Camila Labarca
 */
public class PollPhase extends Phase{

    @Override
    public void toPlayCharacterPhase(IPlayerCharacter character){
        changePhase(new PlayCharacterPhase(character));
    }

    @Override
    public void toPlayEnemyPhase(Enemy character){
        changePhase(new PlayEnemyPhase(character));
    }

    @Override
    public String toString() {
        return "Poll Phase";
    }

    @Override
    public void task() {
        controller.startTurn();
        if (controller.isPlayer(controller.actualCharacter)){
            toPlayCharacterPhase((IPlayerCharacter) controller.actualCharacter);
        }else{
            toPlayEnemyPhase((Enemy) controller.actualCharacter);
            }
    }

}
