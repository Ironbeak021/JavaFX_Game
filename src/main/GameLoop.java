package main;

import MapElements.GameBoard;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

import java.util.HashSet;

public class GameLoop {

    public static HashSet<String> currentlyActiveKeys = new HashSet<>();

    private static final long TICKS = 10_000_000; //How often game updates. default = 10_000_000 = 100fps = 100ticks per sec;
                                                    // 1 second = 1_000_000_000;

    public GameLoop(SetTheStage setTheStage, GameBoard gameBoard, Circle circle) {

        new AnimationTimer() {
            private long lastUpdate = 0 ;
            @Override
            public void handle(long nanotime) {
                if (nanotime - lastUpdate >= TICKS) {
                    SetTheStage.textFPS.setText(1000000000/(nanotime - lastUpdate) + " fps, "
                            + (double)(nanotime - lastUpdate)/1000000 + " mspf"); //Miliseconds per Frame, 1s=1000ms
                    long temp = nanotime - lastUpdate;
                    lastUpdate = nanotime ;
                    gameTick(setTheStage, gameBoard, circle, nanotime, temp);
                }
            }
        }.start();
    }

    private void gameTick(SetTheStage setTheStage, GameBoard gameBoard, Circle circle, long nanotime, long totalTime) {
        updateGameBoard(setTheStage, gameBoard);
        SetTheStage.textPlayerGameBoardCoords.setText(
                "Player: " + setTheStage.player1.getPlayerOnGameBoardX() + ", " + setTheStage.player1.getPlayerOnGameBoardY() +
                "\nGameBoard(0,0): " + setTheStage.player1.getGameBoardCoordsX() + ", " + setTheStage.player1.getGameBoardCoordsY() +
                "\n" + (((System.nanoTime() - nanotime)))/1000 + ", "+((double)(System.nanoTime() - nanotime))/1000000 +
                "\n" + (double)((int)(((double)(System.nanoTime() - nanotime)/(double)totalTime)*10000))/100 + "%" +
                "\nMouse: " + setTheStage.mouseControls.getX() + ", " + setTheStage.mouseControls.getY());
//        SetTheStage.textPlayerScreenCoords.setText("PlayerGB: " + setTheStage.player1.getGameBoardCoordsX() + ", " + setTheStage.player1.getGameBoardCoordsY());
        SetTheStage.textMouseCoords.setText("");
        KeyControls.detectKeyPresses();
        setTheStage.player1.movePlayer();
        circle.setOpacity(setTheStage.player1.getTransparency());
    }

    private void updateGameBoard(SetTheStage setTheStage, GameBoard gameBoard) {
        //only updates if player has moved
        if (setTheStage.player1.previousX != setTheStage.player1.getGameBoardCoordsX() ||
                setTheStage.player1.previousY != setTheStage.player1.getGameBoardCoordsY()) {
            gameBoard.paintGameBoard(setTheStage);

            setTheStage.player1.previousX = setTheStage.player1.getGameBoardCoordsX();
            setTheStage.player1.previousY = setTheStage.player1.getGameBoardCoordsY();
        }
    }

}
