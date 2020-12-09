package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

public interface IWeapon {

    /**
     * Equips an IWeapon to a Knight c.
     */
    void equipToKnight(Knight c);

    /**
     * Equips an IWeapon to an Engineer c.
     */
    void equipToEngineer(Engineer c);

    /**
     * Equips an IWeapon to a Thief c.
     */
    void equipToThief(Thief c);

    /**
     * Equips an IWeapon to a WhiteMage c.
     */
    void equipToWhiteMage(WhiteMage c);

    /**
     * Equips an IWeapon to a BlackMage c.
     */
    void equipToBlackMage(BlackMage c);

    int getWeight();

    int getDamage();

    String getName();
}
