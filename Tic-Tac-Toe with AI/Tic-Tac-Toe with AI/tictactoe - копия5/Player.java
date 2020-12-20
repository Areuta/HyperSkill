package tictactoe;//Author Anton   05.12.2020

import java.util.Random;

public class Player {
    private char playerChar;
    //    private Spot winningMove = null;
    protected TicTacToe ticTacToe;
    public String warningString;
    public String playerString; // informs about the player before the move


    public TicTacToe getTicTacToe() {
        return ticTacToe;
    }

    public void setTicTacToe(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    static char playerCharAlternate(char playerChar) {
        return playerChar == 'X' ? 'O' : 'X';
    }


/*    public Spot getWinningMove() {
        return winningMove;
    }

    public void setWinningMove(Spot winningMove) {
        this.winningMove = winningMove;
    }*/

    public Player(boolean first) {
        this.playerChar = first ? 'X' : 'O';
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public void move() {
        warningString = "";
        System.out.println(playerString);
    }

    //choose a random move from the list of available moves
    public void doRandomMove() {
        Random random = new Random(1000);
        int l = ticTacToe.getBoardGame().getEmptySpots().size();
        l = random.nextInt(l);
        ticTacToe.getBoardGame().getEmptySpots().get(l).setC(getPlayerChar());

    }


    public boolean cellIsFree(int x, int y) {
        warningString = "This cell is occupied! Choose another one!";
        return ticTacToe.getBoardGame().getSpot(x, y).getC() == '_';
    }

    public boolean checkNumbersInRange(int x, int y) {
        warningString = "Coordinates should be from 1 to 3!";
        return x > 0 && y > 0 && x < 4 && y < 4;
    }

    public boolean checkNumber(String xString) {
        warningString = "You should enter numbers!";
        return xString.matches("\\d+");
    }
}
