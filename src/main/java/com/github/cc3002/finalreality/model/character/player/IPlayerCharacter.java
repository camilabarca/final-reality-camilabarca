package com.github.cc3002.finalreality.model.character.player;

/**
 * This represents a player character from the game.
 * A character can be controlled only by the player.
 *
 * @author Camila Labarca
 */

import com.github.cc3002.finalreality.model.weapon.Weapon;

public interface IPlayerCharacter {

    /**
     * Equips the character with a weapon.
     */
    void equip(Weapon weapon);

    /**
     * Returns the weapon equipped by the character.
     */
    Weapon getEquippedWeapon();
}
