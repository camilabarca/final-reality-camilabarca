package com.github.cc3002.finalreality.model.weapon;



import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Staff} class.
 *
 * @author Camila Labarca
 * @see Staff
 */

public class StaffTest extends AbstractWeaponTest{

    @Test
    void constructorTest() {
        checkConstruction(new Staff(STAFF_NAME, DAMAGE, SPEED, 15),
                testStaff,
                new Staff(STAFF_NAME, 10, SPEED, 15),
                new Sword(SWORD_NAME, DAMAGE, SPEED), sameStaff);
        checkConstruction(new Staff(STAFF_NAME, DAMAGE, SPEED, 15),
                testStaff,
                new Staff(STAFF_NAME, DAMAGE, 15, 15),
                new Sword(SWORD_NAME, DAMAGE, SPEED), sameStaff);
        checkConstruction(new Staff(STAFF_NAME, DAMAGE, SPEED, 15),
                testStaff,
                new Staff("Staff", DAMAGE, SPEED, 15),
                new Sword(SWORD_NAME, DAMAGE, SPEED), sameStaff);
        checkConstruction(new Staff(STAFF_NAME, DAMAGE, SPEED, 15),
                testStaff,
                new Staff(STAFF_NAME, DAMAGE, SPEED, 10),
                new Sword(SWORD_NAME, DAMAGE, SPEED), sameStaff);
    }
    @Test
    void MagicdamageTest() {
        Assertions.assertEquals(15, (testStaff.getMagicdamage()));
        Assertions.assertNotEquals(10, testStaff.getMagicdamage());
    }
    @Test
    void DamageTest() {
        Assertions.assertEquals(15, (testStaff.getDamage()));
        Assertions.assertNotEquals(10, testStaff.getDamage());
    }

}
