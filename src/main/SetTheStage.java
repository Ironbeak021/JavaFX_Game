package main;

import MapElements.GameBoard;
import MovingObjects.Player;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SetTheStage extends Application {

    //Goal: Make a game like Terraria
    //Todo List
    //1. find faster way to display game board

    public static final String APPLICATION_NAME = "JavaFX Application";
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 400;
    public static final int RATIO_TILE_TO_PIXELS = 16; //1 chunk on map = 16 pixels
    public static final int GAME_BOARD_WIDTH = 16;//60
    public static final int GAME_BOARD_HEIGHT = 12;//40

    public Player player1 = new Player();
    public static Group mainGroup = new Group();
    public static Group tileGroup = new Group();
    public static Text textFPS = new Text("");
    public static Text textPlayerGameBoardCoords = new Text("");
    public static Text textMouseCoords = new Text("");
    public static Scene scene;
    public MouseControls mouseControls;

    public SetTheStage() {

    }

    @Override
    public void start(Stage primaryStage) {
        SetTheStage setTheStage = new SetTheStage();

        //Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(APPLICATION_NAME);

        Circle circle = new Circle(player1.getScreenCoordsX(), player1.getScreenCoordsY(),10, Color.BLACK);
        circle.setOpacity(player1.getTransparency());
        GameBoard gameBoard = new GameBoard(setTheStage);

        mainGroup.getChildren().add(tileGroup);
        mainGroup.getChildren().add(circle);

        mainGroup.getChildren().add(textFPS);
        textFPS.setOpacity(0.7);
        textFPS.setX(5);
        textFPS.setY(15);
        mainGroup.getChildren().add(textPlayerGameBoardCoords);
        textPlayerGameBoardCoords.setOpacity(0.7);
        textPlayerGameBoardCoords.setX(5);
        textPlayerGameBoardCoords.setY(32);
        mainGroup.getChildren().add(textMouseCoords);
        textMouseCoords.setOpacity(0.7);
        textMouseCoords.setX(5);
        textMouseCoords.setY(49);

        scene = new Scene(mainGroup,SCREEN_WIDTH, SCREEN_HEIGHT, Color.YELLOW);
        setTheStage.mouseControls = new MouseControls();
        new KeyControls(setTheStage);

        primaryStage.setScene(scene);
        primaryStage.show();

        new GameLoop(setTheStage, gameBoard, circle);
    }

}
