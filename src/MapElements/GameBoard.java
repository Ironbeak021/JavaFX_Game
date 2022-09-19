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
            System.out.println("Error Caught: ArrayIndexOutOfBoundsException");
        }
    }

    private final int[][] gameBoardTilesArray = new int
            [SetTheStage.GAME_BOARD_WIDTH][SetTheStage.GAME_BOARD_HEIGHT];
    //0-10 = non-boundary tile
    //10+ = boundary tile

    public GameBoard() throws FileNotFoundException {
        initializeGameBoard();
    }

    private void initializeGameBoard() throws FileNotFoundException {
        for (int x = 0; x < SetTheStage.GAME_BOARD_WIDTH; x++) {
            for (int y = 0; y < SetTheStage.GAME_BOARD_HEIGHT; y++) {
                setGameBoardTilesArray(x, y, 3);
                paintImageTile(x, y);
            }
        }
    }

    private void paintImageTile(int x, int y) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("textures/ground/Grass_3.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(x * SetTheStage.RATIO_TILE_TO_PIXELS);
        imageView.setY(y * SetTheStage.RATIO_TILE_TO_PIXELS);
        imageView.setFitHeight(SetTheStage.RATIO_TILE_TO_PIXELS);
        imageView.setFitWidth(SetTheStage.RATIO_TILE_TO_PIXELS);
        SetTheStage.group.getChildren().add(imageView);
    }


}
