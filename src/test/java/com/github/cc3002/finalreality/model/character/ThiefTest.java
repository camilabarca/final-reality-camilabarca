package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.character.player.WhiteMage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Set of tests for the {@code Thief} class.
 *
 * @author Camila Labarca
 * @see Thief
 */

public class ThiefTest extends AbstractPlayerCharacterTest {

    private static final String THIEF_NAME = "Vivi";
    private Thief vivi;

    @BeforeEach
    void setUp() {
        vivi = new Thief(THIEF_NAME, 10,10);
    }

    /**
     * Checks the construction of a thief
     */
    @Test
    void constructorTest() {
        checkConstruction(new Thief(THIEF_NAME, 10, 10),
                vivi,
                new Thief("Different name",10, 10),
                new WhiteMage(THIEF_NAME,10, 10, 10));
    }

    /**
     * Checks it equips a sword
     */
    @Test
    void equippedSwordTest() {
        checkEquippedWeapon(vivi, sword);
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
     * Checks it equips a bow
     */
    @Test
    void equippedBowTest() {
        checkEquippedWeapon(vivi, bow);
    }

    /**
     * Checks that a dead thief doesn't equip
     */
    @Test
    void equipDeadThief(){
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 20);
        enemy.attack(vivi);
        vivi.equip(sword);
        assertNull(vivi.getEquippedWeapon());
    }
}
