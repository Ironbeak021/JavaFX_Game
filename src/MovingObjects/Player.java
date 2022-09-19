package MovingObjects;

public class Player {

    public boolean playerUpBool = false;
    public boolean playerDownBool = false;
    public boolean playerLeftBool = false;
    public boolean playerRightBool = false;
    public boolean playerTransparencyBool = false;

    private double x;
    private double y;

    private double velocityX = 0;
    private double velocityY = 0;
    private final double MOVE = 3;
    private final double TRANSPARENCYRATE = 0.02;
    private double transparency = 1.0;

    public final int SIZE_WIDTH = 12;
    public final int SIZE_HEIGHT = 12;

    //Getters
    public double getVelocityX() { return velocityX; }
    public double getVelocityY() { return velocityY; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getTransparency() { return transparency; }

    //Setters
    public void setVelocityX(double velocityX) { this.velocityX = velocityX; }
    public void setVelocityY(double velocityY) { this.velocityY = velocityY; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setTransparency(double transparency) { this.transparency = transparency; }

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
        if (playerTransparencyBool && getTransparency() > TRANSPARENCYRATE) {
            setTransparency(getTransparency() - TRANSPARENCYRATE);
        } else if (!playerTransparencyBool && getTransparency() < 1) {
            setTransparency(getTransparency() + TRANSPARENCYRATE);
        }
    }

}
