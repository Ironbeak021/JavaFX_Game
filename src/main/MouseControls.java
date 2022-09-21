package main;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseControls {

    //private static SetTheStage setTheStage;
    private double x = 0;
    private double y = 0;

    //Getters
    public double getX() { return x; }
    public double getY() { return y; }

    //Setters
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public MouseControls() {
        //this.setTheStage = setTheStage;

//        setTheStage.scene.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override public void handle(MouseEvent event) {
//                System.out.println("Entered: "+event.getX()+", "+event.getY());
//            }
//        });
        SetTheStage.scene.setOnMousePressed(event -> {
            setX(event.getX());
            setY(event.getY());
//                System.out.println("Pressed: "+event.getX()+", "+event.getY());
        });
        SetTheStage.scene.setOnMouseMoved(event -> {
            setX(event.getX());
            setY(event.getY());
//                System.out.println("Moved: "+event.getX()+", "+event.getY());
        });
        SetTheStage.scene.setOnMouseDragged(event -> {
            setX(event.getX());
            setY(event.getY());
//                System.out.println("Dragged: "+event.getX()+", "+event.getY());
        });
    }

}