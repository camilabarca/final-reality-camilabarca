package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Set of tests for the {@code Engineer} class.
 *
 * @author Camila Labarca
 * @see Engineer
 */

public class EngineerTest extends AbstractPlayerCharacterTest {

    private static final String ENGINEER_NAME = "Vivi";
    private Engineer vivi;

    @BeforeEach
    void setUp() {
        vivi = new Engineer(ENGINEER_NAME, 10,10);
    }

    /**
     * Checks the construction of a engineer
     */
    @Test
    void constructorTest() {
        checkConstruction(new Engineer(ENGINEER_NAME, 10, 10),
                vivi,
                new Engineer("Different name",10, 10),
                new Knight(ENGINEER_NAME,10, 10));
    }

    /**
     * Checks it doesn't equip a sword
     */
    @Test
    void equippedSwordTest() {
        checkNotEquippedWeapon(vivi, sword);
    }

    /**
     * Checks it equips an axe
     */
    @Test
    void equippedAxeTest() {
        checkEquippedWeapon(vivi, axe);
    }

    /**
     * Checks it doesn't equip a knife
     */
    @Test
    void equippedKnifeTest() {
        checkNotEquippedWeapon(vivi, knife);
    }

    /**
     * Checks it doesn't equip a staff
     */
    @Test
    void equippedStaffTest() {
        checkNotEquippedWeapon(vivi, staff);
    }

    /**
     * Checks it equips a bow
     */
    @Test
    void equippedBowTest() {
        checkEquippedWeapon(vivi, bow);
    }

    /**
     * Checks a dead engineer doesn't equip
     */
    @Test
    void equipDeadEngineer(){
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 20);
        enemy.attack(vivi);
        vivi.equip(bow);
        assertNull(vivi.getEquippedWeapon());
    }
}
