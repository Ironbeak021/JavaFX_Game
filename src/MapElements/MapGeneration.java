package MapElements;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class MapGeneration {

    public static Image GRASS_1;
    public static Image GRASS_2;
    public static Image GRASS_3;
    public static Image BOUNDARY;
    public static Image GOLD_ORE;

    MapGeneration () {
        try {
            GRASS_1 = new Image(new FileInputStream("textures/ground/Grass_1.png"));//creating this a ton is what slows everything down
            GRASS_2 = new Image(new FileInputStream("textures/ground/Grass_2.png"));
            GRASS_3 = new Image(new FileInputStream("textures/ground/Grass_3.png"));
            BOUNDARY = new Image(new FileInputStream("textures/ground/Boundary.png"));
            GOLD_ORE = new Image(new FileInputStream("textures/ground/Gold_Ore.png"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Caught: FileNotFoundException; MapGeneration class");
        }
    }

    public static Image tileType (int type) {
        switch (type) {
            case 1: return GRASS_1;
            case 2: return GRASS_2;
            case 3: return GRASS_3;
            case 4: return BOUNDARY;
            case 5: return GOLD_ORE;
            default: System.out.println("Error: Unknown tile type");
                return GRASS_1;
        }
    }

    public static int generation (int x, int y, int[][] gameBoardTilesArray) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(1000);


        double temp3 = incrementChance(4, x, y, gameBoardTilesArray);
        //double temp2 = incrementChance(2, x, y, gameBoardTilesArray);

        if (randomNumber < temp3) {
            return 4;
        } else if (randomNumber < 0) {
            return 2;
        } else if (randomNumber < 1000) {
            return 1;
        } else {
            return 1;
        }
    }

    private static double incrementChance(int typeSearch, int x, int y, int[][] gameBoardTilesArray) {
        double chance = 2;
        int increment = 350;

        try {
            if (typeSearch == gameBoardTilesArray[x-1][y-1]) {
                //test block above and to left
                chance =+ increment;
            }
        } catch (ArrayIndexOutOfBoundsException e) { }

        try {
            if (typeSearch == gameBoardTilesArray[x][y-1]) {
                //test if same block is ABOVE it
                chance =+ increment * 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) { }
        try {
            if (typeSearch == gameBoardTilesArray[x][y-5] &&
                    typeSearch == gameBoardTilesArray[x][y-4] &&
                    typeSearch == gameBoardTilesArray[x][y-3] &&
                    typeSearch == gameBoardTilesArray[x][y-2] &&
                    typeSearch == gameBoardTilesArray[x][y-1]) {
                //test if same block is ABOVE it
                chance =- increment*1.6;
            }
        } catch (ArrayIndexOutOfBoundsException e) { }

        try {
            if (typeSearch == gameBoardTilesArray[x-1][y]) {
                //test if same block is LEFT of it
                chance =+ increment*1.4;
            }
        } catch (ArrayIndexOutOfBoundsException e) { }

        try {
            if (typeSearch == gameBoardTilesArray[x-1][y+1]) {
                //test block below and to left
                chance =+ increment;
            }
        } catch (ArrayIndexOutOfBoundsException e) { }

        if (chance > 1000) {
            //cant have more than 100.0%
            return 1000;
        } else {
            return chance;
        }
    }

    public static void fillInHolesBlockTypes(int[][] gameBoardTilesArray) {
        int type = 4;

        for (int x = 0; x < gameBoardTilesArray.length ;x++) {
            if (x % (int)(gameBoardTilesArray.length/10) == 0) {
                System.out.println("Generation 2: " + (int)(((double)x/gameBoardTilesArray.length)*100) +"%");
            }
            for (int y = 0; y < gameBoardTilesArray[0].length ;y++) {


                if (fillInHoles(type,x,y,gameBoardTilesArray)) {
                    GameBoard.setGameBoardTilesArray(x, y, type);
                }
            }
        }
        System.out.println("Generation 2: 100%");

//        if(fillInHoles(3,x,y,gameBoardTilesArray)) {
//
//        }
//        return 3;
    }

    private static boolean fillInHoles(int typeSearch, int x, int y, int[][] gameBoardTilesArray) {
        int sidesThatHaveSameBlock = 0;

        try {
            if (typeSearch == gameBoardTilesArray[x+1][y]) {
                sidesThatHaveSameBlock++;
            }
            if (typeSearch == gameBoardTilesArray[x-1][y]) {
                sidesThatHaveSameBlock++;
            }
            if (typeSearch == gameBoardTilesArray[x][y+1]) {
                sidesThatHaveSameBlock++;
            }
            if (typeSearch == gameBoardTilesArray[x][y-1]) {
                sidesThatHaveSameBlock++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        //if 3 or 4 sides of a block is a different block that surrounded block will change
        if (sidesThatHaveSameBlock >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
