package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("user", "easy", "medium", "hard"));
//        Arrays.stream(PlayerTypes.values()).map(PlayerTypes::getTitle)
        do {
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            String[] inputs = input.split(" ");
            if (inputs.length == 3 && inputs[0].equals("start") &&
                    players.contains(inputs[1]) && players.contains(inputs[2])) {
                Board board = new Board("_________");

                PlayerFactory playerFactory = new PlayerFactory();
                PlayerTypes type1 = PlayerTypes.valueOf(inputs[1].toUpperCase());
                PlayerTypes type2 = PlayerTypes.valueOf(inputs[2].toUpperCase());
                Player player1 = playerFactory.getPlayer(type1, true);
                Player player2 = playerFactory.getPlayer(type2, false);

                TicTacToe ticTacToe = new TicTacToe(board, player1, player2);

                board.printBoard();
                while (board.checkGameState() == StateGame.GAME_NOT_FINISHED) {
                    ticTacToe.doNextMove();
                    board.printBoard();
                }

                System.out.println(board.checkGameState().getTitle());

            } else {
                System.out.println("Bad parameters!");
            }
        } while (true);
        scanner.close();
    }

}
