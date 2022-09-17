package main;

import javafx.animation.AnimationTimer;

import java.util.HashSet;

public class GameLoop {

    public static HashSet<String> currentlyActiveKeys = new HashSet<>();

    private static final long TICKS = 10_000_000; //How often game updates. default = 10_000_000 = 100fps; 1 second = 1_000_000_000;

    public GameLoop(SetTheStage setTheStage) {

        new AnimationTimer() {
            private long lastUpdate = 0 ;
            @Override
            public void handle(long nanotime) {
                if (nanotime - lastUpdate >= TICKS) {
                    lastUpdate = nanotime ;
                    gameTick(setTheStage);
                }
            }
        }.start();
    }

    private void gameTick(SetTheStage setTheStage) {
        KeyBinder.detectKeyPresses();
        setTheStage.player1.movePlayer();
        setTheStage.circle.relocate(setTheStage.player1.getX(),setTheStage.player1.getY());
//        setTheStage.circle.setCenterX(setTheStage.player1.getX());
//        setTheStage.circle.setCenterY(setTheStage.player1.getY());
//        System.out.println(setTheStage.player1.getX() + ", " + setTheStage.player1.getY() + "; " +
//                 setTheStage.circle.getCenterX() + ", " + setTheStage.circle.getCenterY());
    }

}
