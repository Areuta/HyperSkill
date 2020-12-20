package tictactoe;//Author Anton   09.12.2020

public class AiPlayerMedium extends Player {

    public AiPlayerMedium(TicTacToe ticTacToe, boolean first) {
        super(ticTacToe, first);
        playerString = "Making move level \"medium\"";
    }

    @Override
    public void move() {
        super.move();
        char rivalChar = getPlayerChar() == 'X' ? 'O' : 'X';
        int checkingSum = (int) getPlayerChar() * 2 + (int) '_';
        if (ticTacToe.getBoardGame().checkTriples(getPlayerChar(), checkingSum)) {
            ticTacToe.getBoardGame().getWinningMove().setC(getPlayerChar());
            return;
        }

        checkingSum = (int) rivalChar * 2 + (int) '_';
        if (ticTacToe.getBoardGame().checkTriples(rivalChar, checkingSum)) {
            ticTacToe.getBoardGame().getWinningMove().setC(getPlayerChar());
            return;
        }
        ticTacToe.getBoardGame().setWinningMove(null);
        doRandomMove();

    }
}
