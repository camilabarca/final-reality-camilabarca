package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

public class StaffTest extends AbstractWeaponTest{

    @Test
    void constructorTest() {
        checkConstruction(new Staff(STAFF_NAME, DAMAGE, SPEED, 15),
                testStaff,
                new Staff(STAFF_NAME, 10, 15, 15),
                new Sword(SWORD_NAME, DAMAGE, SPEED));
    }
}
