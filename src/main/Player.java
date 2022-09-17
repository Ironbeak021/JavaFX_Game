package main;

public class Player {

    public boolean playerUpBool = false;
    public boolean playerDownBool = false;
    public boolean playerLeftBool = false;
    public boolean playerRightBool = false;

    private double x;
    private double y;

    private double velocityX = 0;
    private double velocityY = 0;
    private final double MOVE = 3;

    //Getters
    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public double getX() { return x; }
    public double getY() { return y; }

    //Setters
    public void setVelocityX(double velocityX) { this.velocityX = velocityX; }
    public void setVelocityY(double velocityY) { this.velocityY = velocityY; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public Player() {
        setX(80);
        setY(80);
    }

    public void movePlayer() {
        if (playerUpBool) {
            setY(getY()-MOVE);
        }
        if (playerDownBool) {
            setY(getY()+MOVE);
        }
        if (playerLeftBool) {
            setX(getX()-MOVE);
        }
        if (playerRightBool) {
            setX(getX()+MOVE);
        }
    }

}
