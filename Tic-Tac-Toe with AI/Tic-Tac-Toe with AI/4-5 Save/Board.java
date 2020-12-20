package tictactoe;//Author Anton   30.11.2020

import java.util.ArrayList;

public class Board {
    private final ArrayList<Spot> spots = new ArrayList<>(9);

    private Spot winningMove = null;

    public Spot getWinningMove() {
        return winningMove;
    }

    public void setWinningMove(Spot winningMove) {
        this.winningMove = winningMove;
    }

    //    create a game board from the input line
    public Board(String input) {
        if (inputOk(input)) {
            for (int i = 0; i < 9; i++) {
                Spot spot = new Spot(i / 3 + 1, i % 3 + 1, input.charAt(i));
                spots.add(spot);
            }
        }
    }

    //check if the string can set the state of the game board
    public static boolean inputOk(String input) {
        if (!input.matches("[XO_]{9}")) return false;
        int countXMove = 0;
        int countOMove = 0;
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'X': {
                    countXMove++;
                    break;
                }
                case 'O': {
                    countOMove++;
                    break;
                }
            }
        }
        return Math.abs(countXMove - countOMove) <= 1 && countXMove >= countOMove;
    }

    public ArrayList<Spot> getSpots() {
        return spots;
    }

    public Spot getSpot(int x, int y) {
        if (x > 0 && y > 0 && x < 4 && y < 4) {
            return spots.get(x + 3 * y - 4);
        }
        return null;
    }

    public void printBoard() {
        System.out.println("---------");
        System.out.printf("| %s %s %s |\n", spots.get(6), spots.get(7), spots.get(8));
        System.out.printf("| %s %s %s |\n", spots.get(3), spots.get(4), spots.get(5));
        System.out.printf("| %s %s %s |\n", spots.get(0), spots.get(1), spots.get(2));
        System.out.println("---------");
    }
    //    checks if the game board has three 'c' symbols on one line

    public boolean checkTriples(char c, int checkingSum) {

        return checkTripleState(c, spots.get(0), spots.get(1), spots.get(2), checkingSum) ||
                checkTripleState(c, spots.get(3), spots.get(4), spots.get(5), checkingSum) ||
                checkTripleState(c, spots.get(6), spots.get(7), spots.get(8), checkingSum) ||
                checkTripleState(c, spots.get(0), spots.get(3), spots.get(6), checkingSum) ||
                checkTripleState(c, spots.get(1), spots.get(4), spots.get(7), checkingSum) ||
                checkTripleState(c, spots.get(2), spots.get(5), spots.get(8), checkingSum) ||
                checkTripleState(c, spots.get(0), spots.get(4), spots.get(8), checkingSum) ||
                checkTripleState(c, spots.get(2), spots.get(4), spots.get(6), checkingSum);

    }

    private boolean checkTripleState(char c, Spot spot1, Spot spot2, Spot spot3, int checkingSum) {
        boolean res = checkingSum == (int) spot1.getC() + (int) spot2.getC() + (int) spot3.getC();

        if (spot1.getC() == '_') {
            setWinningMove(spot1);
        }
        if (spot2.getC() == '_') {
            setWinningMove(spot2);
        }
        if (spot3.getC() == '_') {
            setWinningMove(spot3);
        }
        return res;
    }

}
