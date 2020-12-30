package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Knife} class.
 *
 * @author Camila Labarca
 * @see Knife
 */

public class KnifeTest extends AbstractWeaponTest {

    /**
     * Checks the construction of a knife
     */
    @Test
    void constructorTest() {
        checkConstruction(new Knife(KNIFE_NAME, DAMAGE, SPEED),
                testKnife,
                new Knife(KNIFE_NAME, 10, 15),
                new Staff(STAFF_NAME, DAMAGE, SPEED, 15), sameKnife);
        checkConstruction(new Knife(KNIFE_NAME, DAMAGE, SPEED),
                testKnife,
                new Knife(KNIFE_NAME, DAMAGE, 15),
                new Staff(STAFF_NAME, DAMAGE, SPEED, 15), sameKnife);
        checkConstruction(new Knife(KNIFE_NAME, DAMAGE, SPEED),
                testKnife,
                new Knife(KNIFE_NAME, 10, SPEED),
                new Staff(STAFF_NAME, DAMAGE, SPEED, 15), sameKnife);
        checkConstruction(new Knife(KNIFE_NAME, DAMAGE, SPEED),
                testKnife,
                new Knife("Knife", DAMAGE, SPEED),
                new Staff(STAFF_NAME, DAMAGE, SPEED, 15), sameKnife);
    }
}
