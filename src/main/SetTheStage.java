package main;

import MapElements.GameBoard;
import MovingObjects.Player;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class SetTheStage extends Application {

    //Goal: Make a game like

    public static final String APPLICATION_NAME = "JavaFX Application";
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;
    public static final int RATIO_TILE_TO_PIXELS = 16; //1 chunk on map = 16 pixels
    public static final int GAME_BOARD_WIDTH = 60;
    public static final int GAME_BOARD_HEIGHT = 40;

    public Player player1 = new Player();
    public static Circle circle;
    public static Group group;
    public static Scene scene;

    public SetTheStage() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        SetTheStage setTheStage = new SetTheStage();

        //Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(APPLICATION_NAME);


        circle = new Circle(player1.getX(),player1.getY(),10, Color.BLACK);
        circle.setOpacity(player1.getTransparency());
        group = new Group();
        new GameBoard();

        group.getChildren().add(circle);
        scene = new Scene(group,SCREEN_WIDTH, SCREEN_HEIGHT, Color.YELLOW);

        new KeyControls(setTheStage);
        new MouseControls(setTheStage);

        primaryStage.setScene(scene);
        primaryStage.show();

        new GameLoop(setTheStage);
    }

}
