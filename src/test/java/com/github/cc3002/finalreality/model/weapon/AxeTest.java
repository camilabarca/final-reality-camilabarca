package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AxeTest extends AbstractWeaponTest {

    @Test
    void constructorTest() {
        checkConstruction(new Axe(AXE_NAME, DAMAGE, SPEED),
                testAxe,
                new Axe(AXE_NAME, 10, 15),
                new Knife(KNIFE_NAME, DAMAGE, SPEED));
    }
}
