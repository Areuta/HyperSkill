package tictactoe;//Author Anton   05.12.2020

import static tictactoe.Main.scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(boolean b) {
        super(b);
    }

    @Override
    public void move() {
        playerString = "Enter the coordinates: \n";
        System.out.print(playerString);
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
            if (!checkNumbersInRange(x, y) || !cellIsFree(x, y)) {
                System.out.println(warningString);
            } else {
//                warningString = "";
                break;
            }
        } while (true);
//        } while (!"".equals(warningString));
        playerString = "";
        numberNextMove = ticTacToe.getBoardGame().getEmptySpots().indexOf(ticTacToe.getBoardGame().getSpot(x, y));
        super.move();

//        ticTacToe.getBoardGame().getSpot(x, y).setC(getPlayerChar());
    }


}
