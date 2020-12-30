package com.github.cc3002.finalreality.controller.handlers;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;

public class EndTurnHandler implements IEventHandler {

    private final GameController gameController;

    public EndTurnHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.endTurn((ICharacter) evt.getSource());
    }
}
