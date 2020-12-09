package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * This represents a player character from the game.
 * A character can be controlled only by the player.
 *
 * @author Camila Labarca
 *
 */

public interface IPlayerCharacter {

    /**
     * Equips the character with a weapon.
     */
    void equip(IWeapon weapon);

    /**
     * Returns the weapon equipped by the character.
     * @return IWeapon
     */
    IWeapon getEquippedWeapon();
}