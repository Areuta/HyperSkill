package tictactoe;

import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private char[][] gameMatrix;
    private byte countMoves = 0;
    private String warningString = "";

    private enum Situation {IMPOSSIBLE, GAME_NOT_FINISHED, X_WINS, O_WINS, DRAW}

    public static void main(String[] args) {
        Main main = new Main();
        main.scanner = new Scanner(System.in);
        main.gameMatrix = main.gameMatrixCreate();
        main.printField();

        Situation now;
        do {
            main.doMove();
            now = main.checkMatrixState();
        } while (now == Situation.GAME_NOT_FINISHED);

        System.out.println(createPrintingStateString(now));

    }

    private void doMove() {
        String moveX;
        String moveY;
        do {
            System.out.println("Enter the coordinates: >");
            moveX = scanner.next();
            moveY = scanner.next();

            if (checkInputValue(moveX) && checkInputValue(moveY) &&
                    checkMoveIsCorrect(moveX, moveY)) {
                char signPlayer = countMoves % 2 == 0 ? 'X' : 'O';
                countMoves++;

                gameMatrix[3 - Integer.parseInt(moveY)][Integer.parseInt(moveX) - 1] = signPlayer;
                printField();
                warningString = "";
            } else {
                System.out.println(warningString);

            }
        } while (!warningString.equals(""));
    }

    private boolean checkMoveIsCorrect(String inputX, String inputY) {
        int x = 3 - Integer.parseInt(inputY);
        int y = Integer.parseInt(inputX) - 1;
        if (gameMatrix[x][y] == 'X' || gameMatrix[x][y] == 'O') {
            warningString = "This cell is occupied! Choose another one!";
            return false;
        }
        return true;
    }

    private boolean checkInputValue(String input) {
        if (!input.matches("[0-9]+")) {
            warningString = "You should enter numbers!";
            return false;
        } else {
            int number = Integer.parseInt(input);
            if (number > 3 || number < 0) {
                warningString = "Coordinates should be from 1 to 3!";
                return false;
            } else {
                return true;
            }
        }
    }

    private static String createPrintingStateString(Situation now) {
        String output;
        switch (now) {
            case IMPOSSIBLE:
                output = "Impossible";
                break;
            case X_WINS:
                output = "X wins";
                break;
            case O_WINS:
                output = "O wins";
                break;
            case DRAW:
                output = "Draw";
                break;
            case GAME_NOT_FINISHED:
                output = "Game not finished";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + now);
        }
        return output;
    }

    private Situation checkMatrixState() {
        if (have3cell('X')) return Situation.X_WINS;
        if (have3cell('O')) return Situation.O_WINS;
        if (countMoves == 9) return Situation.DRAW;
        return Situation.GAME_NOT_FINISHED;
    }

    private boolean have3cell(char c) {
        boolean res;
        for (int i = 0; i < 3; i++) {
            res = true;
            for (int j = 0; j < 3; j++) {
                if (gameMatrix[i][j] != c) {
                    res = false;
                    break;
                }
            }
            if (res) return true;

            res = true;
            for (int j = 0; j < 3; j++) {
                if (gameMatrix[j][i] != c) {
                    res = false;
                    break;
                }
            }
            if (res) return true;
        }

        // checking diagonal
        res = true;
        for (int i = 0; i < 3; i++) {
            if (gameMatrix[i][i] != c) {
                res = false;
                break;
            }
        }

        if (res) return true;

        res = true;
        for (int i = 0; i < 3; i++) {
            if (gameMatrix[i][2 - i] != c) {
                res = false;
                break;
            }
        }

        return res;
    }

    private char[][] gameMatrixCreate() {
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
            }
        }
        return matrix;
    }

    private void printField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String cellString = String.valueOf(gameMatrix[i][j]);
                if (cellString.equals("_")) {
                    cellString = " ";
                }
                switch (j) {
                    case (0):
                        System.out.printf("| %s ", cellString);
                        break;
                    case (1):
                        System.out.printf("%s ", cellString);
                        break;
                    case (2):
                        System.out.printf("%s |\n", cellString);
                        break;
                }
            }
        }
        System.out.println("---------");
    }

}
