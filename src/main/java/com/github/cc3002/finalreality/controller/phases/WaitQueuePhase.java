package com.github.cc3002.finalreality.controller.phases;

/**
 * A class for the phase when waiting for a character to enter the queue
 * @author Camila Labarca
 */
public class WaitQueuePhase extends Phase{


    @Override
    public void toPollPhase(){
        changePhase(new PollPhase());
    }

    @Override
    public String toString() {
        return "Wait Queue Phase";
    }

    @Override
    public void task() {
        if(!controller.getTurns().isEmpty()){
            toPollPhase();
        }
    }

}
