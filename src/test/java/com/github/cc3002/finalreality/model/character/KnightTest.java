package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.BlackMage;
import com.github.cc3002.finalreality.model.character.player.Engineer;
import com.github.cc3002.finalreality.model.character.player.Knight;
import com.github.cc3002.finalreality.model.character.player.Thief;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Staff;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest extends AbstractPlayerCharacterTest {


    private static final String KNIGHT_NAME = "Vivi";
    private Knight vivi;

    @BeforeEach
    void setUp() {
        super.basicSetUp();
        vivi = new Knight(KNIGHT_NAME, 10,10,turns);
    }

    @Test
    void waitTurnTest() {
        vivi.equip(axe);
        checkWaitTurn(vivi);
    }

    @Test
    void constructorTest() {
        checkConstruction(new Knight(KNIGHT_NAME, 10, 10, turns),
                vivi,
                new Knight("Different name",10, 10, turns),
                new Thief(KNIGHT_NAME,10, 10, turns));
    }


    @Test
    void equippedSwordTest() {
        checkEquippedWeapon(vivi, sword);
    }
    @Test
    void equippedAxeTest() {
        checkEquippedWeapon(vivi, axe);
    }
    @Test
    void equippedKnifeTest() {
        checkEquippedWeapon(vivi, knife);
    }

    @Test
    void equippedStaffTest() {
        checkNotEquippedWeapon(vivi, staff);
    }

    @Test
    void equippedBowTest() {
        checkNotEquippedWeapon(vivi, bow);
    }

    @Test
    void attackTest() {
        Knight knight = new Knight("knight", 10,0, turns);
        Thief thief = new Thief("knight", 1,0, turns);
        knight.equip(sword);
        checkAttack(knight, thief);
        assertEquals(1 - (knight.getEquippedWeapon().getDamage()- thief.getDefense()), thief.getPoints());
        assertFalse(thief.isAlive());
        assertTrue(knight.isAlive());
    }
}
