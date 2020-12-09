package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class PlayerCharacterOutHandler implements IEventHandler{
    private final GameController gameController;

    public PlayerCharacterOutHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.playerCharacterOut((IPlayerCharacter) evt.getSource());
    }
}
