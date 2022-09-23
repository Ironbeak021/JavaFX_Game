package MapElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.SetTheStage;

public class GameBoard {

    //private final int MAX_TILE_TYPES = 20;

    public static int getGameBoardTilesArray(int x, int y) {
        try {
            return gameBoardTilesArray[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error Caught: ArrayIndexOutOfBoundsException; GameBoard class");
            System.out.println(x + ", " + y + "; Bigger than, " +
                    getGameBoardTilesArray().length + ", " + getGameBoardTilesArray()[0].length);
            return 1;
        }
    }
    public static int[][] getGameBoardTilesArray() {
        return gameBoardTilesArray;
    }

    public static void setGameBoardTilesArray(int x, int y, int tileType) {
        try {
            gameBoardTilesArray[x][y] = tileType;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error Caught: ArrayIndexOutOfBoundsException; GameBoard class");
            System.out.println(x + ", " + y + "; Bigger than, " +
                    getGameBoardTilesArray().length + ", " + getGameBoardTilesArray()[0].length);
        }
    }

    private static final int[][] gameBoardTilesArray = new int
            [SetTheStage.GAME_BOARD_WIDTH][SetTheStage.GAME_BOARD_HEIGHT];
    //0-10 = non-boundary tile
    //10+ = boundary tile

    public GameBoard(SetTheStage setTheStage) {
        new MapGeneration();
        initializeGameBoard();
        paintGameBoard(setTheStage);
    }

    private void initializeGameBoard() {
        int totalX = getGameBoardTilesArray().length;
        for (int x = 0; x < getGameBoardTilesArray().length ;x++) {
            if (x % (int)(totalX/20) == 0) {
                System.out.println("Generation 1: " + (int)(((double)x/totalX)*100) +"%");
            }
            for (int y = 0; y < getGameBoardTilesArray()[0].length ;y++) {
                setGameBoardTilesArray(x, y, MapGeneration.generation(x, y, getGameBoardTilesArray()));
            }
        }
        System.out.println("Generation 1: 100%\n");

        for (int i = 0; i < 2; i++) {
            MapGeneration.fillInHolesBlockTypes(getGameBoardTilesArray());
        }
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

                paintImageTile(x, y, MapGeneration.tileType(getGameBoardTilesArray(
                        (x-(int)setTheStage.player1.getGameBoardCoordsX())/SetTheStage.RATIO_TILE_TO_PIXELS,
                        (y-(int)setTheStage.player1.getGameBoardCoordsY())/SetTheStage.RATIO_TILE_TO_PIXELS)));
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

    private void paintImageTile(int x, int y, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(SetTheStage.RATIO_TILE_TO_PIXELS);
        imageView.setFitWidth(SetTheStage.RATIO_TILE_TO_PIXELS);
        imageView.setX(x);
        imageView.setY(y);
        SetTheStage.tileGroup.getChildren().add(imageView);
    }


}
