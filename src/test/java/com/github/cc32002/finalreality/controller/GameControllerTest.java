package com.github.cc32002.finalreality.controller;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for the {@code GameController} class.
 *
 * @author Camila Labarca
 * @see GameController
 */

public class GameControllerTest {
    private GameController controller;
    private Knight knight;
    private Engineer engineer;
    private Thief thief;
    private BlackMage blackMage;
    private WhiteMage whiteMage;
    private Sword sword;
    private Axe axe;
    private Knife knife;
    private Staff staff;
    private Bow bow;
    private Enemy enemy;

    @BeforeEach
    void setUp(){
        controller = new GameController();
        knight = new Knight("Knight", 10, 10, controller.getTurns());
        engineer = new Engineer("Engineer", 10, 10, controller.getTurns());
        thief = new Thief("Thief", 10, 10, controller.getTurns());
        blackMage = new BlackMage("BlackMage", 10, 10, controller.getTurns(), 10);
        whiteMage = new WhiteMage("WhiteMage", 10, 10, controller.getTurns(), 10);
        sword = new Sword("Sword", 15, 10);
        axe = new Axe("Axe", 15, 10);
        knife = new Knife("Knife", 15, 10);
        staff = new Staff("Staff", 15, 10, 15);
        bow = new Bow("Bow", 15, 10);
        enemy = new Enemy("Enemy", 10,10,10,10, controller.getTurns());
    }

    @Test
    void checkConstruction(){
        assertTrue(controller.getParty().isEmpty());
        assertTrue(controller.getEnemies().isEmpty());
        assertTrue(controller.getInventory().isEmpty());
        assertTrue(controller.getTurns().isEmpty());
    }

    @Test
    void checkCreation(){
        controller.createKnight("Knight", 10, 10);
        assertEquals(knight, controller.getParty().get(0));
        controller.createEngineer("Engineer", 10, 10);
        assertEquals(engineer, controller.getParty().get(1));
        controller.createThief("Thief", 10, 10);
        assertEquals(thief, controller.getParty().get(2));
        controller.createBlackMage("BlackMage", 10, 10, 10);
        assertEquals(blackMage, controller.getParty().get(3));
        controller.createWhiteMage("WhiteMage", 10, 10, 10);
        assertEquals(whiteMage, controller.getParty().get(4));
        controller.createSword("Sword", 15, 10);
        assertEquals(sword, controller.getInventory().get(0));
        controller.createAxe("Axe", 15, 10);
        assertEquals(axe, controller.getInventory().get(1));
        controller.createKnife("Knife", 15, 10);
        assertEquals(knife, controller.getInventory().get(2));
        controller.createStaff("Staff", 15, 10, 15);
        assertEquals(staff, controller.getInventory().get(3));
        controller.createBow("Bow", 15, 10);
        assertEquals(bow, controller.getInventory().get(4));
        controller.createEnemy("Enemy", 10,10,10,10);
        assertEquals(enemy, controller.getEnemies().get(0));
    }

    @Test
    public void checkEquip(){
        controller.createKnight("Knight", 10, 10);
        controller.createSword("Sword", 15, 10);
        controller.createAxe("Axe", 15, 10);
        controller.createStaff("Staff", 15, 10, 15);
        Knight testKnight = (Knight) controller.getParty().get(0);
        assertEquals(3, controller.getInventory().size());
        assertNull(testKnight.getEquippedWeapon());
        controller.equipCharacter(testKnight, 0);
        assertEquals(sword, testKnight.getEquippedWeapon());
        assertEquals(2, controller.getInventory().size());
        controller.equipCharacter(testKnight, 0);
        assertEquals(axe, testKnight.getEquippedWeapon());
        assertEquals(2, controller.getInventory().size());
        controller.equipCharacter(testKnight, 0);
        assertEquals(axe, testKnight.getEquippedWeapon());
        assertEquals(2, controller.getInventory().size());
    }

    @Test
    public void checkAttack(){
        controller.createKnight("Knight", 10, 10);
        controller.createEnemy("Enemy", 10,10,10,11);
        Knight testKnight = (Knight) controller.getParty().get(0);
        Enemy testEnemy = controller.getEnemies().get(0);
        controller.attack(testEnemy, testKnight);
        assertEquals(9, testKnight.getPoints());
    }

    @Test
    public void checkTurns(){
        controller.createKnight("Knight", 10, 10);
        assertNull(controller.actualCharacter);
        controller.startTurn();
        assertNull(controller.actualCharacter);
        Knight testKnight = (Knight) controller.getParty().get(0);
        testKnight.equip(sword);
        Assertions.assertTrue(controller.getTurns().isEmpty());
        testKnight.waitTurn();
            try {
                // Thread.sleep is not accurate so this values may be changed to adjust the
                // acceptable error margin.
                // We're testing that the character waits approximately 1 second.
                Thread.sleep(900);
                Assertions.assertEquals(0, controller.getTurns().size());
                Thread.sleep(200);
                Assertions.assertEquals(1, controller.getTurns().size());
                controller.startTurn();
                assertTrue(controller.getTurns().isEmpty());
                Assertions.assertEquals(testKnight, controller.actualCharacter);
                controller.endTurn();
                assertNull(controller.actualCharacter);
                controller.endTurn();
                assertNull(controller.actualCharacter);
                assertFalse(controller.getTurns().isEmpty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    @Test
    public void checkPlayerWon(){
        controller.createKnight("Knight", 10, 10);
        controller.createEnemy("Enemy",15,0,10,10);
        Knight attacker = (Knight) controller.getParty().get(0);
        attacker.equip(sword);
        attacker.attack(controller.getEnemies().get(0));
        assertTrue(controller.getEnemies().isEmpty());
        assertTrue(controller.playerWon());
    }

    @Test
    public void checkPlayerLost(){
        controller.createKnight("Knight", 10, 0);
        controller.createEnemy("Enemy",10,10,10,10);
        Enemy attacker = controller.getEnemies().get(0);
        attacker.attack((ICharacter) controller.getParty().get(0));
        assertTrue(controller.getParty().isEmpty());
        assertTrue(controller.playerLost());
    }


}
