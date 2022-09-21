package MapElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.SetTheStage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameBoard {

    //private final int MAX_TILE_TYPES = 20;

    public int[][] getGameBoardTilesArray() {
        return gameBoardTilesArray;
    }

    public void setGameBoardTilesArray(int x, int y, int tileType) throws ArrayIndexOutOfBoundsException {
        try {
            gameBoardTilesArray[x][y] = tileType;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error Caught: ArrayIndexOutOfBoundsException; GameBoard class");
            System.out.println(x + ", " + y + "; Bigger than, " +
                    getGameBoardTilesArray().length + ", " + getGameBoardTilesArray()[0].length);
        }
    }

    private final int[][] gameBoardTilesArray = new int
            [SetTheStage.GAME_BOARD_WIDTH][SetTheStage.GAME_BOARD_HEIGHT];
    //0-10 = non-boundary tile
    //10+ = boundary tile

    public GameBoard(SetTheStage setTheStage) {
        paintGameBoard(setTheStage);
    }

    public void paintGameBoard(SetTheStage setTheStage) {
        SetTheStage.tileGroup.getChildren().clear();

        for (int x = tileOutsideScreenMin((int)setTheStage.player1.getGameBoardCoordsX());
             x < tileOutsideScreenMax((int)setTheStage.player1.getGameBoardCoordsX() +
                             SetTheStage.GAME_BOARD_WIDTH * SetTheStage.RATIO_TILE_TO_PIXELS,
                     SetTheStage.SCREEN_WIDTH);
             x+=SetTheStage.RATIO_TILE_TO_PIXELS) {

            for (int y = tileOutsideScreenMin((int)setTheStage.player1.getGameBoardCoordsY());
                 y < tileOutsideScreenMax((int)setTheStage.player1.getGameBoardCoordsY() +
                                 SetTheStage.GAME_BOARD_HEIGHT * SetTheStage.RATIO_TILE_TO_PIXELS,
                         SetTheStage.SCREEN_HEIGHT);
                 y+=SetTheStage.RATIO_TILE_TO_PIXELS) {
                //setGameBoardTilesArray(x, y, 3);
                paintImageTile(x, y);
            }
        }
    }
    private int tileOutsideScreenMin(int temp) {
        if (temp < 0) {
            return temp % SetTheStage.RATIO_TILE_TO_PIXELS;
        } else {
            return temp;
        }
    }
    private int tileOutsideScreenMax(int temp, int screenLength) {
        if (temp > screenLength) {
            return (temp % SetTheStage.RATIO_TILE_TO_PIXELS) + screenLength;
        } else {
            return temp;
        }
    }

    private void paintImageTile(int x, int y) {
        try {
            Image image = new Image(new FileInputStream("textures/ground/Grass_3.png"));
            ImageView imageView = new ImageView(image);
            imageView.setX(x);
            imageView.setY(y);
            imageView.setFitHeight(SetTheStage.RATIO_TILE_TO_PIXELS);
            imageView.setFitWidth(SetTheStage.RATIO_TILE_TO_PIXELS);
            SetTheStage.tileGroup.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Caught: FileNotFoundException; GameBoard class");
        }
    }


}
