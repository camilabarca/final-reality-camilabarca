package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Sword} class.
 *
 * @author Camila Labarca
 * @see Sword
 */

public class SwordTest extends AbstractWeaponTest{

    @Test
    void constructorTest() {
        checkConstruction(new Sword(SWORD_NAME, DAMAGE, SPEED),
                testSword,
                new Sword(SWORD_NAME, 10, 15),
                new Bow(BOW_NAME, DAMAGE, SPEED));
    }
}
