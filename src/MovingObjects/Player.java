package MovingObjects;

import main.SetTheStage;

public class Player {

    public boolean playerUpBool = false;
    public boolean playerDownBool = false;
    public boolean playerLeftBool = false;
    public boolean playerRightBool = false;
    public boolean playerTransparencyBool = false;

    private double screenCoordsX = (int)SetTheStage.SCREEN_WIDTH / 2;
    private double screenCoordsY = (int)SetTheStage.SCREEN_HEIGHT / 2;
    private double gameBoardCoordsX;
    private double gameBoardCoordsY;
    public double playerOnGameBoardX;
    public double playerOnGameBoardY;
    public double previousX = 0; //both used to tell if player has moved
    public double previousY = 0;

    private double velocityX = 0;
    private double velocityY = 0;
    private final double MOVE = 2.5;// default 3
    private final double TRANSPARENCY_RATE = 0.02;
    private double transparency = 1.0;

    public final int SIZE_WIDTH = 12;
    public final int SIZE_HEIGHT = 12;
    public final int GAMEBOARD_STARTING_COORDS_X = 130;
    public final int GAMEBOARD_STARTING_COORDS_Y = 130;

    //Getters
    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public double getScreenCoordsX() { return screenCoordsX; }
    public double getScreenCoordsY() { return screenCoordsY; }
    public double getGameBoardCoordsX() { return gameBoardCoordsX; }
    public double getGameBoardCoordsY() { return gameBoardCoordsY; }
    public double getPlayerOnGameBoardX() { return playerOnGameBoardX; }
    public double getPlayerOnGameBoardY() { return playerOnGameBoardY; }
    public double getTransparency() { return transparency; }

    //Setters
    public void setVelocityX(double velocityX) { this.velocityX = velocityX; }
    public void setVelocityY(double velocityY) { this.velocityY = velocityY; }
    public void setScreenCoordsX(double screenCoordsX) { this.screenCoordsX = screenCoordsX; }
    public void setScreenCoordsY(double screenCoordsY) { this.screenCoordsY = screenCoordsY; }
    public void setGameBoardCoordsX(double gameBoardCoordsX) { this.gameBoardCoordsX = gameBoardCoordsX; }
    public void setGameBoardCoordsY(double gameBoardCoordsY) { this.gameBoardCoordsY = gameBoardCoordsY; }
    public void setPlayerOnGameBoardX(double playerOnGameBoardX) { this.playerOnGameBoardX = playerOnGameBoardX; }
    public void setPlayerOnGameBoardY(double playerOnGameBoardY) { this.playerOnGameBoardY = playerOnGameBoardY; }
    public void setTransparency(double transparency) { this.transparency = transparency; }

    public Player() {
        setGameBoardCoordsX(screenCoordsX - GAMEBOARD_STARTING_COORDS_X);
        setGameBoardCoordsY(screenCoordsY - GAMEBOARD_STARTING_COORDS_Y);
        setPlayerOnGameBoardX(GAMEBOARD_STARTING_COORDS_X);
        setPlayerOnGameBoardY(GAMEBOARD_STARTING_COORDS_Y);

    }

    public void movePlayer() {
        if (playerUpBool) {
            setGameBoardCoordsY(getGameBoardCoordsY()+MOVE);
            setPlayerOnGameBoardY(getPlayerOnGameBoardY()+MOVE);
        }
        if (playerDownBool) {
            setGameBoardCoordsY(getGameBoardCoordsY()-MOVE);
            setPlayerOnGameBoardY(getPlayerOnGameBoardY()-MOVE);
        }
        if (playerLeftBool) {
            setGameBoardCoordsX(getGameBoardCoordsX()+MOVE);
            setPlayerOnGameBoardX(getPlayerOnGameBoardX()-MOVE);
        }
        if (playerRightBool) {
            setGameBoardCoordsX(getGameBoardCoordsX()-MOVE);
            setPlayerOnGameBoardX(getPlayerOnGameBoardX()+MOVE);
        }
//        if (playerUpBool) {
//            setScreenCoordsY(getScreenCoordsY()-MOVE);
//        }
//        if (playerDownBool) {
//            setScreenCoordsY(getScreenCoordsY()+MOVE);
//        }
//        if (playerLeftBool) {
//            setScreenCoordsX(getScreenCoordsX()-MOVE);
//        }
//        if (playerRightBool) {
//            setScreenCoordsX(getScreenCoordsX()+MOVE);
//        }
        if (playerTransparencyBool && getTransparency() > TRANSPARENCY_RATE) {
            setTransparency(getTransparency() - TRANSPARENCY_RATE);
        } else if (!playerTransparencyBool && getTransparency() < 1) {
            setTransparency(getTransparency() + TRANSPARENCY_RATE);
        }
    }

}
