package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.handlers.*;
import com.github.cc3002.finalreality.controller.phases.*;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that creates the controller of the game.
 * @author Camila Labarca
 */
public class GameController {
    private final ArrayList<IPlayerCharacter> party;
    private final ArrayList<Enemy> enemies;
    private final ArrayList<IWeapon> inventory;
    private final BlockingQueue<ICharacter> turns;
    public ICharacter actualCharacter;
    private Phase phase;

    IEventHandler enemyOutHandler = new EnemyOutHandler(this);
    IEventHandler playerCharacterOutHandler= new PlayerCharacterOutHandler(this);
    IEventHandler meetsTimerHandler = new MeetsTimerHandler(this);
    IEventHandler endTurnHandler = new EndTurnHandler(this);


    public GameController() {
        party = new ArrayList<>();
        enemies = new ArrayList<>();
        inventory = new ArrayList<>();
        turns = new LinkedBlockingQueue<>();
        actualCharacter = null;
        this.setPhase(new PollPhase());
    }

    /**
     * Returns the list with the player's characters.
     */
    public ArrayList<IPlayerCharacter> getParty(){
        return party;
    }

    /**
     * Returns the list with the game's enemies.
     */
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    /**
     * Returns the list with the inventory.
     */
    public ArrayList<IWeapon> getInventory() {
        return inventory;
    }

    /**
     * Returns the BlockingQueue for the turns.
     */
    public BlockingQueue<ICharacter> getTurns() {
        return turns;
    }

    /**
     * Creates a Knight and adds it to the party.
     */
    public void createKnight(String name, int points, int defense) {
        Knight knight = new Knight(name, points, defense);
        party.add(knight);
        turns.add(knight);
        knight.addListener(playerCharacterOutHandler);
        knight.addListener1(meetsTimerHandler,endTurnHandler);
    }

    /**
     * Creates an Engineer and adds it to the party.
     */
    public void createEngineer(String name, int points, int defense) {
        Engineer engineer = new Engineer(name, points, defense);
        party.add(engineer);
        turns.add(engineer);
        engineer.addListener(playerCharacterOutHandler);
        engineer.addListener1(meetsTimerHandler,endTurnHandler);
    }

    /**
     * Creates a Thief and adds it to the party.
     */
    public void createThief(String name, int points, int defense) {
        Thief thief = new Thief(name, points, defense);
        party.add(thief);
        turns.add(thief);
        thief.addListener(playerCharacterOutHandler);
        thief.addListener1(meetsTimerHandler,endTurnHandler);
    }

    /**
     * Creates a BlackMage and adds it to the party.
     */
    public void createBlackMage(String name, int points, int defense, int mana) {
        BlackMage blackMage = new BlackMage(name, points, defense, mana);
        party.add(blackMage);
        turns.add(blackMage);
        blackMage.addListener(playerCharacterOutHandler);
        blackMage.addListener1(meetsTimerHandler,endTurnHandler);
    }

    /**
     * Creates a WhiteMage and adds it to the party.
     */
    public void createWhiteMage(String name, int points, int defense, int mana) {
        WhiteMage whiteMage = new WhiteMage(name, points, defense, mana);
        party.add(whiteMage);
        turns.add(whiteMage);
        whiteMage.addListener(playerCharacterOutHandler);
        whiteMage.addListener1(meetsTimerHandler,endTurnHandler);
    }

    /**
     * Creates a Sword and adds it to the inventory.
     */
    public void createSword(String name, int damage, int weight){
        Sword sword = new Sword(name, damage, weight);
        inventory.add(sword);
    }

    /**
     * Creates an Axe and adds it to the inventory.
     */
    public void createAxe(String name, int damage, int weight){
        Axe axe = new Axe(name, damage, weight);
        inventory.add(axe);
    }

    /**
     * Creates a Knife and adds it to the inventory.
     */
    public void createKnife(String name, int damage, int weight){
        Knife knife = new Knife(name, damage, weight);
        inventory.add(knife);
    }

    /**
     * Creates a Staff and adds it to the inventory.
     */
    public void createStaff(String name, int damage, int weight, int magicDamage){
        Staff staff = new Staff(name, damage, weight, magicDamage);
        inventory.add(staff);
    }

    /**
     * Creates a Bow and adds it to the inventory.
     */
    public void createBow(String name, int damage, int weight){
        Bow bow = new Bow(name, damage, weight);
        inventory.add(bow);
    }

    /**
     * Creates an Enemy and adds it to the enemies list.
     */
    public void createEnemy(String name, int points, int defense, int weight, int damage){
        Enemy enemy = new Enemy(name, points, defense, weight, damage);
        enemies.add(enemy);
        turns.add(enemy);
        enemy.addListener(enemyOutHandler);
        enemy.addListener1(meetsTimerHandler,endTurnHandler);
    }

    /**
     * Equips a player with a weapon of the inventory with index i.
     * If the character is able to equip this weapon the weapon is removed from the inventory.
     * If the previous weapon is not null, this weapon is added back to the inventory
     */
    public void equipCharacter(IPlayerCharacter character, int i){
        IWeapon actualWeapon = character.getEquippedWeapon();
        IWeapon weaponToEquip = inventory.get(i);
        character.equip(weaponToEquip);
        if (character.getEquippedWeapon() == weaponToEquip){
            inventory.remove(i);
            if (actualWeapon != null){
                inventory.add(actualWeapon);
            }
        }
    }

    /**
     * Attack between characters
     */
    public void attack(ICharacter attacker, ICharacter attacked){
        attacker.attack(attacked);
    }

    /**
     * Takes the first character of the queue and updates the actual character
     */
    public void startTurn(){
        this.actualCharacter = turns.poll();

    }

    /**
     * Ends the turn of actual character adding it pack to the queue and the actual character goes
     * back to null
     */
    public void endTurn(ICharacter character){
        character.waitTurn();
        this.actualCharacter = null;
    }

    /**
     * Adds the character that finished its waiting time to the queue
     */
    public void characterMeetsTimer(ICharacter source){
        if (source.isAlive()){
            turns.add(source);
        }
    }

    /**
     * Removes an enemy from the enemies list if the enemy is out of action
     */
    public void enemyOut(Enemy enemy) {
        enemies.remove(enemy);
        turns.remove(enemy);
    }

    /**
     * Removes a player character party list if the player character is out of action
     */
    public void playerCharacterOut(IPlayerCharacter playerCharacter) {
        party.remove(playerCharacter);
        turns.remove(playerCharacter);
    }

    /**
     * Returns true if the enemies list is empty
     */
    public boolean playerWon(){
        return (this.enemies.isEmpty());
    }

    /**
     * Return true if the party list is empty
     */
    public boolean playerLost(){
        return (this.party.isEmpty());
    }

    /**
     * Sets the actual phase to the controller
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * Returns the actual phase of the controller
     */
    public Phase getPhase(){
        return this.phase;
    }

    /**
     * Return true if the character is in the party, which means it's not an enemy
     */
    public boolean isPlayer(ICharacter character){
        return this.getParty().contains(character);
    }

    /**
     * Does the task that corresponds to the current phase
     */
    public void task() throws InvalidMovementException {
        phase.task();
    }

    /**
     * Tries to equip a character
     */
    public void tryToEquip(IPlayerCharacter character, int i) {
        try {
            phase.equipWeapon(character, i);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tries to attack a character
     */
    public void tryToAttack(ICharacter character, ICharacter opponent) {
        try {
            phase.attack(character, opponent);
        } catch (InvalidMovementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a random number so that the enemy can a attack a random character
     */
    public int attackTo(){
        Random rand = new Random();
        return rand.nextInt(getParty().size());
    }
}
