package com.github.cc3002.finalreality.model.character.player;

import ...
import com.github.cc3002.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Mage extends PlayerCharacter{
    private String type;
    private int mana;

    public Mage(String name, int points, String defense, String type, int mana){
        super(name, points, defense);
        this.type = type;
        this.mana = mana;
    }

    public String getType(){
        return type;
    }

    public int getMana(){
        return mana;
    }
}
