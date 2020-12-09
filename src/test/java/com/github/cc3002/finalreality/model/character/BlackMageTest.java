package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Set of tests for the {@code BlackMage} class.
 *
 * @author Camila Labarca
 * @see BlackMage
 */

public class BlackMageTest extends AbstractPlayerCharacterTest{

    private static final String BLACK_MAGE_NAME = "Vivi";
    private BlackMage vivi;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        vivi = new BlackMage(BLACK_MAGE_NAME, 10,10,turns, 10);
    }

    @Test
    void waitTurnTest() {
        vivi.equip(staff);
        checkWaitTurn(vivi);
    }

    @Test
    void constructorTest() {
        checkConstruction(new BlackMage(BLACK_MAGE_NAME, 10, 10, turns, 10),
                vivi,
                new BlackMage("Different name",10, 10, turns, 10),
                new Knight(BLACK_MAGE_NAME,10, 10, turns));
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
        checkEquippedWeapon(vivi, knife);
    }

    @Test
    void equippedStaffTest() {
        checkEquippedWeapon(vivi, staff);
    }

    @Test
    void equippedBowTest() {
        checkNotEquippedWeapon(vivi, bow);
    }

    @Test
    void equipDeadBlackMage(){
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 20, turns);
        enemy.attack(vivi);
        vivi.equip(staff);
        assertNull(vivi.getEquippedWeapon());
    }
}
