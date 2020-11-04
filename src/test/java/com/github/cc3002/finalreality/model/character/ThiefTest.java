package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Vivi";
    private Thief vivi;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        vivi = new Thief(THIEF_NAME, 10,10,turns);
    }

    @Test
    void waitTurnTest() {
        vivi.equip(sword);
        checkWaitTurn(vivi);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Thief(THIEF_NAME, 10, 10, turns),
                vivi,
                new Thief("Different name",10, 10, turns),
                new WhiteMage(THIEF_NAME,10, 10, turns, 10));
    }


    @Test
    void equippedSwordTest() {
        checkEquippedWeapon(vivi, sword);
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
        checkEquippedWeapon(vivi, bow);
    }
}
