package main;


public class KeyControls {

    private static SetTheStage setTheStage;

    public KeyControls(SetTheStage setTheStage) {
        this.setTheStage = setTheStage;

        setTheStage.scene.setOnKeyPressed(keyEvent ->
            GameLoop.currentlyActiveKeys.add(keyEvent.getCode().toString()));
            //System.out.println(keyEvent.getCode().toString());

        setTheStage.scene.setOnKeyReleased(keyEvent ->
                GameLoop.currentlyActiveKeys.remove(keyEvent.getCode().toString()));
    }

    public static void detectKeyPresses() {

        //WASD. Moves player
        setTheStage.player1.playerUpBool = GameLoop.currentlyActiveKeys.contains("W");
        setTheStage.player1.playerLeftBool = GameLoop.currentlyActiveKeys.contains("A");
        setTheStage.player1.playerDownBool = GameLoop.currentlyActiveKeys.contains("S");
        setTheStage.player1.playerRightBool = GameLoop.currentlyActiveKeys.contains("D");

        //Space Bar.
        setTheStage.player1.playerTransparencyBool = GameLoop.currentlyActiveKeys.contains("SPACE");
    }

}
