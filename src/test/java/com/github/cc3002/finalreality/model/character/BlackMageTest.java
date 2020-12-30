package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Knight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        vivi = new BlackMage(BLACK_MAGE_NAME, 10,10, 10);
    }

    /**
     * Checks the construction of a black mage
     */
    @Test
    void constructorTest() {
        checkConstruction(new BlackMage(BLACK_MAGE_NAME, 10, 10,10),
                vivi,
                new BlackMage("Different name",10, 10, 10),
                new Knight(BLACK_MAGE_NAME,10, 10));
        assertEquals(10, vivi.getMana());
    }

    /**
     * Checks it doesn't equip a sword
     */
    @Test
    void equippedSwordTest() {
        checkNotEquippedWeapon(vivi, sword);
    }

    /**
     * Checks it doesn't equip an axe
     */
    @Test
    void equippedAxeTest() {
        checkNotEquippedWeapon(vivi, axe);
    }

    /**
     * Checks it equips a knife
     */
    @Test
    void equippedKnifeTest() {
        checkEquippedWeapon(vivi, knife);
    }

    /**
     * Checks it equips a staff
     */
    @Test
    void equippedStaffTest() {
        checkEquippedWeapon(vivi, staff);
    }

    /**
     * Checks it doesn't equip a bow
     */
    @Test
    void equippedBowTest() {
        checkNotEquippedWeapon(vivi, bow);
    }

    /**
     * Checks a dead black mage doesn't equip a bow
     */
    @Test
    void equipDeadBlackMage(){
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 20);
        enemy.attack(vivi);
        vivi.equip(staff);
        assertNull(vivi.getEquippedWeapon());
    }
}
