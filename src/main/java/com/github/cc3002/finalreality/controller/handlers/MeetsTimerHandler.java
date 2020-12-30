package com.github.cc3002.finalreality.controller.handlers;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;

public class MeetsTimerHandler implements IEventHandler{
    private final GameController controller;

    public MeetsTimerHandler(GameController controller){
        this.controller = controller;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.characterMeetsTimer((ICharacter) evt.getSource());

    }
}
