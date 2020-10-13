package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

public class KnifeTest extends AbstractWeaponTest {

    @Test
    void constructorTest() {
        checkConstruction(new Knife(KNIFE_NAME, DAMAGE, SPEED),
                testKnife,
                new Knife(KNIFE_NAME, 10, 15),
                new Staff(STAFF_NAME, DAMAGE, SPEED, 15));
    }
}
