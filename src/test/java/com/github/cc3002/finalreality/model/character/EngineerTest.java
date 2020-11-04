package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.weapon.Axe;

import com.github.cc3002.finalreality.model.weapon.Bow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Vivi";
    private Engineer vivi;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        vivi = new Engineer(ENGINEER_NAME, 10,10,turns);
    }

    @Test
    void waitTurnTest() {
        vivi.equip(axe);
        checkWaitTurn(vivi);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Engineer(ENGINEER_NAME, 10, 10, turns),
                vivi,
                new Engineer("Different name",10, 10, turns),
                new Knight(ENGINEER_NAME,10, 10, turns));
    }


    @Test
    void equippedSwordTest() {
        checkNotEquippedWeapon(vivi, sword);
    }
    @Test
    void equippedAxeTest() {
        checkEquippedWeapon(vivi, axe);
    }
    @Test
    void equippedKnifeTest() {
        checkNotEquippedWeapon(vivi, knife);
    }

    @Test
    void equippedStaffTest() {
        checkNotEquippedWeapon(vivi, staff);
    }

    @Test
    void equippedBowTest() {
        checkEquippedWeapon(vivi, bow);
    }
}
