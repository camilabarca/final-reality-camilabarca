package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.GameController;
import com.github.cc3002.finalreality.controller.phases.InvalidMovementException;
import com.github.cc3002.finalreality.controller.phases.PollPhase;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Main entry point for the application.
 * <p>
 * The game starts with all the characters already in the queue.
 * With the poll button you get the first character from the queue.
 * If the character corresponds to an enemy you have to press the Attack Player button and it
 * will attack a random player.
 * If the character is a player from the game you have to press the Equip Button and then choose
 * the weapon you want to equip. A label will show which weapon you have equipped. Once this
 * label is not None you have to press the Attack button and choose an enemy to attack.
 * If once the character ends its turn the queue is empty you will have to wait and once the
 * queue gets a character you have to press next to poll the next character.
 * At any moment of the game you can press the "Restart Game" button to start all over again,
 * but the queue has to be full.
 *
 * @author Ignacio Slater Muñoz.
 * @author Camila Labarca
 *
 */
public class FinalReality extends Application {
  private final GameController controller = new GameController();
  private Button pollButton;
  private Button equipButton;
  private Button attackPlayerButton;
  private Button next;
  private Button attackEnemy;

  private Label players;
  private Label enemies;
  private Label turns;
  private Label actualCharacter;
  private Label points;
  private Label weapon;

  private Label win;

  private static final String RESOURCE_PATH = "src/main/resources/";

  public static void main(String[] args){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    startGame(primaryStage);

  }

  /**
   * Initialisation of the game
   */
  public void startGame(Stage stage) throws FileNotFoundException {
    controller.createAxe("Axe", 5, 10);
    controller.createSword("Sword", 7, 20);
    controller.createKnife("Knife", 6, 50);
    controller.createStaff("Staff", 8, 60, 10);
    controller.createBow("Bow", 6, 10);
    controller.createKnife("Knife1", 5, 30);
    controller.createStaff("Staff1", 6, 20, 10);

    controller.createEnemy("Enemy1", 10, 1, 20, 5);
    controller.createKnight("Knight", 10, 2);
    controller.createEnemy("Enemy2", 10, 1, 10, 8);
    controller.createEngineer("Engineer", 10, 3);
    controller.createEnemy("Enemy3", 10, 2, 30, 5);
    controller.createThief("Thief", 10, 1);
    controller.createEnemy("Enemy4", 10, 3, 60, 7);
    controller.createWhiteMage("WhiteMage", 10, 4, 10);
    controller.createEnemy("Enemy5", 10, 4, 80, 6);
    controller.createBlackMage("BlackMage", 10, 4, 10);

    stage.setTitle("Final Reality");
    stage.setResizable(false);

    Group root1 = new Group();

    Scene scene = new Scene(root1, 600, 600);

    var background =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background1.png")));
    background.setFitHeight(600);
    background.setFitWidth(600);
    root1.getChildren().add(background);

    var enemyImage =
            new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "ghost.png")));
    enemyImage.setFitWidth(75);
    enemyImage.setFitHeight(75);
    enemyImage.setX(250);
    enemyImage.setY(100);

    var characterImage =
           new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "personaje.png")));
    characterImage.setFitWidth(75);
    characterImage.setFitHeight(75);
    characterImage.setX(250);
    characterImage.setY(100);

    enemies = createLabel(10, 10);
    players = createLabel(10, 30);
    turns = createLabel(10, 50);
    actualCharacter = createLabel(250, 60);
    points = createLabel(250, 75);
    weapon = createLabel(250, 90);

    win = createLabel(100, 100);

    pollButton = new Button("Poll Character");
    pollButton.setLayoutX(250);
    pollButton.setLayoutY(250);

    equipButton = new Button("Equip");
    equipButton.setLayoutX(250);
    equipButton.setLayoutY(250);

    attackPlayerButton = new Button("Attack Player");
    attackPlayerButton.setLayoutX(250);
    attackPlayerButton.setLayoutY(250);

    next = new Button("Next");
    next.setLayoutX(400);
    next.setLayoutY(250);

    attackEnemy = new Button("Attack");
    attackEnemy.setLayoutX(450);
    attackEnemy.setLayoutY(400);

    Button restartGame = new Button("Restart Game");
    restartGame.setLayoutY(400);
    restartGame.setLayoutX(250);

    startAnimator();

    root1.getChildren().addAll(actualCharacter, enemies, players, turns, pollButton, points, win, restartGame);

    equipButton.setOnAction(event -> {root1.getChildren().removeAll(equipButton); createWeaponsButton(root1, characterImage);root1.getChildren().addAll(attackEnemy, weapon);});

    pollButton.setOnAction(event -> {
      try {
        controller.task();
        if (controller.getPhase().toString().equals("Play Enemy Phase")){
          root1.getChildren().removeAll(equipButton, pollButton);
          root1.getChildren().addAll(attackPlayerButton, enemyImage);

        } else{
          root1.getChildren().removeAll(attackPlayerButton,  pollButton);
          root1.getChildren().addAll(equipButton, characterImage);
        }
        scene.setRoot(root1);
      } catch (InvalidMovementException e) {
        e.printStackTrace();
      }
    });

    attackPlayerButton.setOnAction(event -> {controller.tryToAttack(controller.actualCharacter, controller.getParty().get(random()));
    if (controller.getPhase().toString().equals("Wait Queue Phase")){ root1.getChildren().removeAll(attackPlayerButton, enemyImage); root1.getChildren().addAll( next);} else {root1.getChildren().removeAll(attackPlayerButton, enemyImage);root1.getChildren().addAll(pollButton);}
    });

    next.setOnAction(event -> {
      try {
        controller.task();
        if (controller.getPhase().toString().equals("Poll Phase")){

          root1.getChildren().removeAll(next);root1.getChildren().addAll(pollButton);
        }
      } catch (InvalidMovementException e) {
        e.printStackTrace();
      }
    });

    restartGame.setOnAction(e -> {
      try {
        restart(stage);
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      }
    });

    stage.setScene(scene);
    stage.show();
  }

  /**
   * Restarts the game
   */
  void restart(Stage stage) throws FileNotFoundException {
    cleanup();
    startGame(stage);
  }

  /**
   * Empties all the lists and resets to the initial phase, with no actual character
   */
  void cleanup() {
    controller.getParty().clear();
    controller.getEnemies().clear();
    controller.getTurns().clear();
    controller.getInventory().clear();
    controller.setPhase(new PollPhase());
    controller.actualCharacter = null;
  }

  /**
   * Starts animation
   */
  private void startAnimator() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        int p = controller.getParty().size();
        int e = controller.getEnemies().size();
        int t = controller.getTurns().size();
        String name;
        String w;
        int point;
        if (controller.actualCharacter != null){
          name = controller.actualCharacter.getName();
          point = controller.actualCharacter.getPoints();
        } else {
          name = "None";
          point = 0;
        }
        if (controller.isPlayer(controller.actualCharacter)){
          IPlayerCharacter character = (IPlayerCharacter) controller.actualCharacter;
          if (character.getEquippedWeapon() != null){
            w = character.getEquippedWeapon().getName();
          }else{
            w = "None";
          }
          weapon.setText("Actual Weapon: "+w);
        }
        actualCharacter.setText("Actual Character: " + name);
        points.setText("Points: "+ point);
        players.setText("Party: " + p);
        enemies.setText("Enemies " + e);
        turns.setText("Queue: " + t);
        if (p == 0 || e == 0){
          if (controller.playerWon()){
            win.setText("CONGRATULATIONS, YOU WIN");

          } else if (controller.playerLost()){
            win.setText("SORRY, GAME OVER");
          }
        }

      }
    };
    timer.start();
  }

  /**
   * Creates a label
   */
  private @NotNull Label createLabel(int xPos, int yPos) {
    Label label = new Label();
    label.setLayoutX(xPos);
    label.setLayoutY(yPos);
    return label;
  }

  /**
   * Creates a button for each of the enemies that are still alive
   */
  private void createEnemiesButton(Group root, ImageView image){
    ArrayList<Button> buttons = new ArrayList<>();
    for (int i= 0; i<controller.getEnemies().size(); i++){
      Button enemy = new Button("Attack "+controller.getEnemies().get(i).getName());
      enemy.setLayoutX(50 + i*100);
      enemy.setLayoutY(250);
      int finalI = i;
      enemy.setOnAction(event -> {controller.tryToAttack(controller.actualCharacter,controller.getEnemies().get(finalI));
      if (controller.getPhase().toString().equals("Wait Queue Phase")){
        for (Button b : buttons){
          root.getChildren().removeAll(b);
        }
        root.getChildren().addAll(turns, next);
      }
      else {
        for (Button b : buttons){
          root.getChildren().removeAll(b);
        }
        root.getChildren().addAll(pollButton);
        root.getChildren().removeAll(image);
      }});
      root.getChildren().add(enemy);
      buttons.add(enemy);
    }
  }

  /**
   * Creates a button for each of the weapons that are on the inventory
   */
  private void createWeaponsButton(Group root, ImageView image){
    ArrayList<Button> buttons = new ArrayList<>();
    for (int i= 0; i<controller.getInventory().size(); i++){
      Button weapon1 = new Button(controller.getInventory().get(i).getName());
      weapon1.setLayoutX(45 + i*100);
      weapon1.setLayoutY(250);
      int finalI = i;
      weapon1.setOnAction(event -> {controller.tryToEquip((IPlayerCharacter) controller.actualCharacter, finalI);
      for(Button b : buttons){
        root.getChildren().removeAll(b);
      }
      createWeaponsButton(root, image);
      });
      attackEnemy.setOnAction(event -> {root.getChildren().removeAll(attackEnemy, weapon);
        for(Button b : buttons){
          root.getChildren().removeAll(b);
        }
        createEnemiesButton(root, image);
      });
      root.getChildren().add(weapon1);
      buttons.add(weapon1);
    }
  }

  public int random(){
    Random rand = new Random();
    return rand.nextInt(controller.getParty().size());
  }

}



