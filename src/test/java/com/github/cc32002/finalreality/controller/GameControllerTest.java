package com.github.cc32002.finalreality.controller;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.controller.phases.*;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

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
        knight = new Knight("Knight", 10, 10);
        engineer = new Engineer("Engineer", 10, 10);
        thief = new Thief("Thief", 10, 10);
        blackMage = new BlackMage("BlackMage", 10, 10, 10);
        whiteMage = new WhiteMage("WhiteMage", 10, 10,  10);
        sword = new Sword("Sword", 15, 10);
        axe = new Axe("Axe", 15, 10);
        knife = new Knife("Knife", 15, 10);
        staff = new Staff("Staff", 15, 10, 15);
        bow = new Bow("Bow", 15, 10);
        enemy = new Enemy("Enemy", 10,10,10,10);
    }

    /**
     * Checks the construction of the game's controller
     */
    @Test
    void checkConstruction(){
        assertTrue(controller.getParty().isEmpty());
        assertTrue(controller.getEnemies().isEmpty());
        assertTrue(controller.getInventory().isEmpty());
        assertTrue(controller.getTurns().isEmpty());
    }

    /**
     * Checks the creation of the players, enemies and weapons of the game with the controller
     */
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

    /**
     * Checks that the character equips correctly and takes it from the inventory
     */
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

    /**
     * Checks the attack
     */
    @Test
    public void checkAttack(){
        controller.createKnight("Knight", 10, 10);
        controller.createEnemy("Enemy", 10,10,10,11);
        Knight testKnight = (Knight) controller.getParty().get(0);
        Enemy testEnemy = controller.getEnemies().get(0);
        controller.attack(testEnemy, testKnight);
        assertEquals(9, testKnight.getPoints());
    }

    /**
     * Checks the game phases
     */
    @Test
    public void checkPhases() {
        assertTrue(controller.getTurns().isEmpty());
        controller.createEnemy("Enemy",15,4,20,10);
        assertEquals(1, controller.getTurns().size());
        controller.createKnight("Knight", 10, 9);
        assertEquals(2, controller.getTurns().size());
        controller.createAxe("Axe", 5, 30);
        assertEquals(controller.getPhase().toString(), "Poll Phase");

        try {
            controller.task();
            assertEquals(controller.getPhase().toString(), "Play Enemy Phase");
            assertEquals(new Enemy("Enemy",15,4,20,10), controller.actualCharacter);
            int i = controller.attackTo();
            controller.tryToAttack(controller.actualCharacter, controller.getParty().get(i));
            assertEquals(controller.getPhase().toString(), "Poll Phase");
            assertEquals(9, controller.getParty().get(0).getPoints());
            Thread.sleep(200);
            assertEquals(1, controller.getTurns().size());
            assertNull(controller.actualCharacter);
            Thread.sleep(2000);
            assertEquals(2, controller.getTurns().size());
            controller.task();
            assertEquals(controller.getPhase().toString(), "Play Character Phase");
            assertEquals(1, controller.getTurns().size());
            assertEquals(new Knight("Knight", 9, 9), controller.actualCharacter);
            controller.tryToEquip((IPlayerCharacter) controller.actualCharacter, 0);
            assertEquals(new Axe("Axe", 5, 30), ((IPlayerCharacter) controller.actualCharacter).getEquippedWeapon());
            controller.tryToAttack(controller.actualCharacter, controller.getEnemies().get(0));
            assertEquals(controller.getPhase().toString(), "Poll Phase");
            assertEquals(14, controller.getEnemies().get(0).getPoints());
            controller.task();
            assertEquals(new Enemy("Enemy",15,4,20,10), controller.actualCharacter);
            int j = controller.attackTo();
            controller.tryToAttack(controller.actualCharacter, controller.getParty().get(j));
            Thread.sleep(200);
            assertEquals(controller.getPhase().toString(), "Wait Queue Phase");
            Thread.sleep(3000);
            controller.task();
            assertEquals(controller.getPhase().toString(), "Poll Phase");
            controller.getTurns().remove(controller.getEnemies().get(0));
            assertEquals(1, controller.getTurns().size());
            controller.task();
            controller.tryToAttack(controller.actualCharacter, controller.getEnemies().get(0));
            Thread.sleep(200);
            assertEquals(controller.getPhase().toString(), "Wait Queue Phase");
            controller.task();
            assertEquals(controller.getPhase().toString(), "Wait Queue Phase");
            Thread.sleep(3000);
            controller.task();
            assertEquals(controller.getPhase().toString(), "Poll Phase");
        } catch (InvalidMovementException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks that a dead character is not added back to the queue
     */
    @Test
    public void deadCharacter(){
        controller.createKnight("Knight", 5, 0);
        controller.createAxe("Axe", 0, 60);
        controller.createEnemy("Enemy", 11, 10, 10, 10);
        try {
            controller.task();
            controller.tryToEquip((IPlayerCharacter) controller.actualCharacter, 0);
            controller.tryToAttack(controller.actualCharacter, controller.getEnemies().get(0));
            controller.task();
            Thread.sleep(200);
            controller.tryToAttack(controller.actualCharacter, controller.getParty().get(0));
            Thread.sleep(7000);
            assertEquals(1, controller.getTurns().size());
        } catch (InvalidMovementException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks when the player wins
     */
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

    /**
     * Checks when the player loses
     */
    @Test
    public void checkPlayerLost(){
        controller.createKnight("Knight", 10, 0);
        controller.createEnemy("Enemy",10,10,10,10);
        Enemy attacker = controller.getEnemies().get(0);
        attacker.attack( controller.getParty().get(0));
        assertTrue(controller.getParty().isEmpty());
        assertTrue(controller.playerLost());
    }

    /**
     * Checks the transition exception
     */
    @Test
    public void testInvalidTransitionException(){
        InvalidTransitionException e;
        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 10);
        Thief thief = new Thief("Thief", 10, 10);

        PollPhase pollPhase = new PollPhase();

        e = assertThrows(InvalidTransitionException.class, pollPhase::toPollPhase);
        assertEquals("Can't change from Poll Phase to Poll Phase", e.getMessage());

        e = assertThrows(InvalidTransitionException.class, pollPhase::toWaitQueuePhase);
        assertEquals("Can't change from Poll Phase to Wait Queue Phase", e.getMessage());

        PlayEnemyPhase playEnemyPhase =  new PlayEnemyPhase(enemy);

        e =  assertThrows(InvalidTransitionException.class, () -> playEnemyPhase.toPlayEnemyPhase(enemy));
        assertEquals("Can't change from Play Enemy Phase to Play Enemy Phase", e.getMessage());

        e =  assertThrows(InvalidTransitionException.class, () -> playEnemyPhase.toPlayCharacterPhase(thief));
        assertEquals("Can't change from Play Enemy Phase to Play Character Phase", e.getMessage());

        PlayCharacterPhase playCharacterPhase =  new PlayCharacterPhase(thief);

        e =  assertThrows(InvalidTransitionException.class, () -> playCharacterPhase.toPlayCharacterPhase(thief));
        assertEquals("Can't change from Play Character Phase to Play Character Phase", e.getMessage());

        e =  assertThrows(InvalidTransitionException.class, () -> playCharacterPhase.toPlayEnemyPhase(enemy));
        assertEquals("Can't change from Play Character Phase to Play Enemy Phase", e.getMessage());

        WaitQueuePhase waitQueuePhase = new WaitQueuePhase();

        e = assertThrows(InvalidTransitionException.class, waitQueuePhase::toWaitQueuePhase);
        assertEquals("Can't change from Wait Queue Phase to Wait Queue Phase", e.getMessage());

        e =  assertThrows(InvalidTransitionException.class, () -> waitQueuePhase.toPlayCharacterPhase(thief));
        assertEquals("Can't change from Wait Queue Phase to Play Character Phase", e.getMessage());

        e =  assertThrows(InvalidTransitionException.class, () -> waitQueuePhase.toPlayEnemyPhase(enemy));
        assertEquals("Can't change from Wait Queue Phase to Play Enemy Phase", e.getMessage());
    }

    /**
     * Checks the movement exceptions
     */
    @Test
    public void testInvalidMovementException(){
        InvalidMovementException e;

        Enemy enemy = new Enemy("Enemy", 10, 10, 10, 10);
        Thief thief = new Thief("Thief", 10, 10);

        PollPhase pollPhase = new PollPhase();

        e =  assertThrows(InvalidMovementException.class, () -> pollPhase.attack(enemy, thief));
        assertEquals("You can't attack", e.getMessage());

        e =  assertThrows(InvalidMovementException.class, () -> pollPhase.equipWeapon(thief, 0));
        assertEquals("You can't equip", e.getMessage());

        PlayEnemyPhase playEnemyPhase = new PlayEnemyPhase(enemy);

        e = assertThrows(InvalidMovementException.class, playEnemyPhase::task);
        assertEquals("Can't do this task in Play Enemy Phase", e.getMessage());

    }

}
