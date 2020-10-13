package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Bow} class.
 *
 * @author Camila Labarca
 * @see Bow
 */

public class BowTest extends AbstractWeaponTest{

    @Test
    void constructorTest() {
        checkConstruction(new Bow(BOW_NAME, DAMAGE, SPEED),
                testBow,
                new Bow(BOW_NAME, 10, 15),
                new Axe(AXE_NAME, DAMAGE, SPEED));
    }
}


