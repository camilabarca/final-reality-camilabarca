package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code Axe} class.
 *
 * @author Camila Labarca
 * @see Axe
 */

public class AxeTest extends AbstractWeaponTest {

    @Test
    void constructorTest() {
        checkConstruction(new Axe(AXE_NAME, DAMAGE, SPEED),
                testAxe,
                new Axe(AXE_NAME, 10, 15),
                new Knife(KNIFE_NAME, DAMAGE, SPEED), sameAxe);
        checkConstruction(new Axe(AXE_NAME, DAMAGE, SPEED),
                testAxe,
                new Axe(AXE_NAME, DAMAGE, 15),
                new Knife(KNIFE_NAME, DAMAGE, SPEED), sameAxe);
        checkConstruction(new Axe(AXE_NAME, DAMAGE, SPEED),
                testAxe,
                new Axe(AXE_NAME, 10, SPEED),
                new Knife(KNIFE_NAME, DAMAGE, SPEED), sameAxe);
        checkConstruction(new Axe(AXE_NAME, DAMAGE, SPEED),
                testAxe,
                new Axe("Axe", DAMAGE, SPEED),
                new Knife(KNIFE_NAME, DAMAGE, SPEED), sameAxe);
    }
}
