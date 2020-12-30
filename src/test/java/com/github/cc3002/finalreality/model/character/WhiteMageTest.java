package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Set of tests for the {@code WhiteMage} class.
 *
 * @author Camila Labarca
 * @see WhiteMage
 */

public class WhiteMageTest extends AbstractPlayerCharacterTest {

    private static final String WHITE_MAGE_NAME = "Vivi";
    private WhiteMage vivi;

    @BeforeEach
    void setUp() {
        vivi = new WhiteMage(WHITE_MAGE_NAME, 10,10, 10);
    }

    /**
     * Checks the construction of a white mage
     */
    @Test
    void constructorTest() {
        checkConstruction(new WhiteMage(WHITE_MAGE_NAME, 10, 10, 10),
                vivi,
                new WhiteMage("Different name",10, 10, 10),
                new Knight(WHITE_MAGE_NAME,10, 10));
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
     * Checks it doesn't equip a knife
     */
    @Test
    void equippedKnifeTest() {
        checkNotEquippedWeapon(vivi, knife);
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
     * Checks a dead white mage doesn't equip
     */
    @Test
    void equipDeadWhiteMage(){
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 20);
        enemy.attack(vivi);
        vivi.equip(staff);
        assertNull(vivi.getEquippedWeapon());
    }
}
