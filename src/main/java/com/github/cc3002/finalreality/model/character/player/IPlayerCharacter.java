package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.weapon.Weapon;

public interface IPlayerCharacter {

    void equip(Weapon weapon);

    Weapon getEquippedWeapon();
}
