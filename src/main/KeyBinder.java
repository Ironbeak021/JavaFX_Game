package main;


public class KeyBinder {

    private static SetTheStage setTheStage;

    public KeyBinder(SetTheStage setTheStage) {
        this.setTheStage = setTheStage;

        setTheStage.scene.setOnKeyPressed(keyEvent -> {
            GameLoop.currentlyActiveKeys.add(keyEvent.getCode().toString());
        });
        setTheStage.scene.setOnKeyReleased(keyEvent -> {
            GameLoop.currentlyActiveKeys.remove(keyEvent.getCode().toString());
        });
    }

    public static void detectKeyPresses() {
        if (GameLoop.currentlyActiveKeys.contains("W")) {
            setTheStage.player1.playerUpBool = true;
        } else {
            setTheStage.player1.playerUpBool = false;
        }
        if (GameLoop.currentlyActiveKeys.contains("A")) {
            setTheStage.player1.playerLeftBool = true;
        } else {
            setTheStage.player1.playerLeftBool = false;
        }
        if (GameLoop.currentlyActiveKeys.contains("S")) {
            setTheStage.player1.playerDownBool = true;
        } else {
            setTheStage.player1.playerDownBool = false;
        }
        if (GameLoop.currentlyActiveKeys.contains("D")) {
            setTheStage.player1.playerRightBool = true;
        } else {
            setTheStage.player1.playerRightBool = false;
        }
    }

}
