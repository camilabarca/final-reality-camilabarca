package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.*;

public interface IWeapon {

    void equipToKnight(Knight c);
    void equipToEngineer(Engineer c);
    void equipToThief(Thief c);
    void equipToWhiteMage(WhiteMage c);
    void equipToBlackMage(BlackMage c);

    int getWeight();

    int getDamage();

    String getName();
}
