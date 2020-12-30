package com.github.cc3002.finalreality.controller.handlers;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

public class EnemyOutHandler implements IEventHandler {
    private final GameController gameController;

    public EnemyOutHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.enemyOut((Enemy) evt.getSource());
    }
}
