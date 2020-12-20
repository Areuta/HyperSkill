package tictactoe;//Author Anton   09.12.2020

public class AiPlayerMedium extends Player {

    public AiPlayerMedium(boolean first) {
        super(first);
        playerString = "Making move level \"medium\"\n";
    }

    @Override
    public void move() {
        char rivalChar = playerCharAlternate(getPlayerChar());

        numberNextMove = -1;
        for (int i = 0; i < ticTacToe.getBoardGame().getEmptySpots().size(); i++) {
            Spot currentSpot = ticTacToe.getBoardGame().getEmptySpots().get(i);

            currentSpot.setC(getPlayerChar());
            StateGame stateGameNextMove = ticTacToe.getBoardGame().checkGameState();
            StateGame stateGameCurrentPlayerWin = StateGame.valueOf(getPlayerChar() + "_WINS");
            currentSpot.setC('_');

            if (stateGameCurrentPlayerWin.equals(stateGameNextMove)) {
                numberNextMove = i;
                break;
            }
        }

        if (numberNextMove == -1) {
            for (int i = 0; i < ticTacToe.getBoardGame().getEmptySpots().size(); i++) {
                Spot currentSpot = ticTacToe.getBoardGame().getEmptySpots().get(i);

                currentSpot.setC(rivalChar);
                StateGame stateGameNextMove = ticTacToe.getBoardGame().checkGameState();
                StateGame stateGameCurrentPlayerWin = StateGame.valueOf(rivalChar + "_WINS");
                currentSpot.setC('_');

                if (stateGameCurrentPlayerWin.equals(stateGameNextMove)) {
                    numberNextMove = i;
                    break;
                }
            }
        }

        if (numberNextMove == - 1) {
            doRandomMove();
        }


        /*int checkingSum = (int) getPlayerChar() * 2 + (int) '_';
        if (ticTacToe.getBoardGame().checkTriples(getPlayerChar(), checkingSum)) {
            ticTacToe.getBoardGame().getWinningMove().setC(getPlayerChar());
            return;
        }

        checkingSum = (int) rivalChar * 2 + (int) '_';
        if (ticTacToe.getBoardGame().checkTriples(rivalChar, checkingSum)) {
            ticTacToe.getBoardGame().getWinningMove().setC(getPlayerChar());
            return;
        }*/
        super.move();
//        ticTacToe.getBoardGame().setWinningMove(null);

    }
}
