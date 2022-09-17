package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SetTheStage extends Application {


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
        primaryStage.setTitle("JavaFX Application");

        circle = new Circle(player1.getX(),player1.getY(),10, Color.BLACK);
        group = new Group(circle);
        scene = new Scene(group,600,400, Color.YELLOW);

        new KeyBinder(setTheStage);

        primaryStage.setScene(scene);
        primaryStage.show();

        new GameLoop(setTheStage);
    }

}
