package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class WhiteMageTest extends AbstractPlayerCharacterTest {

    private static final String WHITE_MAGE_NAME = "Vivi";
    private WhiteMage vivi;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        vivi = new WhiteMage(WHITE_MAGE_NAME, 10,10,turns, 10);
    }

    @Test
    void waitTurnTest() {
        vivi.equip(staff);
        checkWaitTurn(vivi);
    }

    @Test
    void constructorTest() {
        checkConstruction(new WhiteMage(WHITE_MAGE_NAME, 10, 10, turns, 10),
                vivi,
                new WhiteMage("Different name",10, 10, turns, 10),
                new Knight(WHITE_MAGE_NAME,10, 10, turns));
    }


    @Test
    void equippedSwordTest() {
        checkNotEquippedWeapon(vivi, sword);
    }
    @Test
    void equippedAxeTest() {
        checkNotEquippedWeapon(vivi, axe);
    }
    @Test
    void equippedKnifeTest() {
        checkNotEquippedWeapon(vivi, knife);
    }

    @Test
    void equippedStaffTest() {
        checkEquippedWeapon(vivi, staff);
    }

    @Test
    void equippedBowTest() {
        checkNotEquippedWeapon(vivi, bow);
    }
}
