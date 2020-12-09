package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class WhiteMage extends PlayerCharacter{

    protected int mana;
    /**
     * Creates a new WhiteMage character.
     *
     * @param name       the mage character's name
     * @param points     the mage character's points
     * @param defense    the mage character's defense
     * @param turnsQueue the queue with the characters waiting for their turn
     * @param mana       the mage character´s mana
     */
    public WhiteMage(String name, int points, int defense, @NotNull BlockingQueue<ICharacter> turnsQueue, int mana) {
        super(name, points, defense, turnsQueue);
        this.mana = mana;
    }

    public int getMana(){
        return mana;
    }

    @Override
    public void equip(IWeapon weapon){
        if (this.isAlive()){
        weapon.equipToWhiteMage(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        return o instanceof WhiteMage && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), WhiteMage.class);
    }

}
