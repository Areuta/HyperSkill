package tictactoe;//Author Anton   05.12.2020

import java.util.Random;

public class Player {
    private char playerChar;
    public TicTacToe ticTacToe;
    public String warningString;
    public String playerString; // informs about the player before the move

    public Player(TicTacToe ticTacToe, boolean first) {
        this.ticTacToe = ticTacToe;
        this.playerChar = first ? 'X' : 'O';
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public void move() {
        warningString = "";
        System.out.println(playerString);
    }

    public void doRandomMove() {
        int x, y;
        Random random = new Random(1000);

        do {
            x = random.nextInt(3) + 1;
            y = random.nextInt(3) + 1;
            if (cellIsFree(x, y)) {
                warningString = "";
            }
        } while (!"".equals(warningString));

        ticTacToe.getBoardGame().getSpot(x, y).setC(getPlayerChar());
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
