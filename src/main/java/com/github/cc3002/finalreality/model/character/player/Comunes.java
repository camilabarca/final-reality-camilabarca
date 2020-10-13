package com.github.cc3002.finalreality.model.character.player;

public class Comunes extends PlayerCharacter{
    private String type;

    public Comunes(String name, int points, String defense, String type, int mana){
        super(name, points, defense);
        this.type = type;
    }

    public String getType(){
        return type;
    }

}

