package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code Knight} class.
 *
 * @author Camila Labarca
 * @see Knight
 */

public class KnightTest extends AbstractPlayerCharacterTest {


    private static final String KNIGHT_NAME = "Vivi";
    private Knight vivi;

    @BeforeEach
    void setUp() {
        vivi = new Knight(KNIGHT_NAME, 10,10);
    }

    /**
     * Checks the construction of a knight
     */
    @Test
    void constructorTest() {
        checkConstruction(new Knight(KNIGHT_NAME, 10, 10),
                vivi,
                new Knight("Different name",10, 10),
                new Thief(KNIGHT_NAME,10, 10));
    }

    /**
     * Checks it equips a sword
     */
    @Test
    void equippedSwordTest() {
        checkEquippedWeapon(vivi, sword);
    }

    /**
     * Checks it equips an axe
     */
    @Test
    void equippedAxeTest() {
        checkEquippedWeapon(vivi, axe);
    }

    /**
     * Checks it equips a knife
     */
    @Test
    void equippedKnifeTest() {
        checkEquippedWeapon(vivi, knife);
    }

    /**
     * Checks it doesn't equip a staff
     */
    @Test
    void equippedStaffTest() {
        checkNotEquippedWeapon(vivi, staff);
    }

    /**
     * Checks it doesn't equip a bow
     */
    @Test
    void equippedBowTest() {
        checkNotEquippedWeapon(vivi, bow);
    }

    /**
     * Checks a dead knight doesn't equip
     */
    @Test
    void equipDeadKnight(){
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 20);
        enemy.attack(vivi);
        vivi.equip(sword);
        assertNull(vivi.getEquippedWeapon());
    }

    /**
     * Checks a knight attacks and receives the attack correctly
     */
    @Test
    void attackTest() {
        Knight knight = new Knight("knight", 10,0);
        Thief thief = new Thief("knight", 1,0);
        knight.equip(sword);
        checkAttack(knight, thief);
        assertEquals(0, thief.getPoints());
        assertFalse(thief.isAlive());
        thief.attack(knight);
        assertEquals(10, knight.getPoints());
        assertTrue(knight.isAlive());
    }
}
