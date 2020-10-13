package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.Comunes;
import com.github.cc3002.finalreality.model.character.player.ComunesType;
import com.github.cc3002.finalreality.model.character.player.Mage;
import com.github.cc3002.finalreality.model.character.player.MageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowTest extends AbstractWeaponTest{

    @Test
    void constructorTest() {
        checkConstruction(new Bow(BOW_NAME, DAMAGE, SPEED),
                testBow,
                new Bow(BOW_NAME, 10, 15),
                new Axe(AXE_NAME, DAMAGE, SPEED));
    }
}


