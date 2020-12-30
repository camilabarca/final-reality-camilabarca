package com.github.cc3002.finalreality.model.weapon;


import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Sword} class.
 *
 * @author Camila Labarca
 * @see Sword
 */

public class SwordTest extends AbstractWeaponTest{

    /**
     * Checks the construction of a sord
     */
    @Test
    void constructorTest() {
        checkConstruction(new Sword(SWORD_NAME, DAMAGE, SPEED),
                testSword,
                new Sword(SWORD_NAME, DAMAGE, 15),
                testBow, sameSword);
        checkConstruction(new Sword(SWORD_NAME, DAMAGE, SPEED),
                testSword,
                new Sword(SWORD_NAME, 10, SPEED),
                testBow, sameSword);
        checkConstruction(new Sword(SWORD_NAME, DAMAGE, SPEED),
                testSword,
                new Sword("Sword", DAMAGE, SPEED),
                testBow, sameSword);

    }


}
