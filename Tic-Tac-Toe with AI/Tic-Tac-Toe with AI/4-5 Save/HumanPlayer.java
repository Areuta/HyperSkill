package tictactoe;//Author Anton   05.12.2020

import static tictactoe.Main.scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(TicTacToe ticTacToe, boolean b) {
        super(ticTacToe, b);
        playerString = "Enter the coordinates: ";
    }

    @Override
    public void move() {
        super.move();

        int x = 0, y = 0;

        do {
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");

            if (inputs.length != 2 || !checkNumber(inputs[0]) || !checkNumber(inputs[1])) {
                warningString = "You should enter numbers!";
                System.out.println(warningString);
                continue;
            }

            x = Integer.parseInt(inputs[0]);
            y = Integer.parseInt(inputs[1]);
            if (checkNumbersInRange(x, y) && cellIsFree(x, y)) {
                warningString = "";
            } else {
                System.out.println(warningString);
            }
        } while (!"".equals(warningString));

        ticTacToe.getBoardGame().getSpot(x, y).setC(getPlayerChar());
    }


}
