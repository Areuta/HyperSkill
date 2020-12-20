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
                player1.setTicTacToe(ticTacToe);
                player2.setTicTacToe(ticTacToe);

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
//input XO_X__OOX    _________  XOXX_OOOX   O_XX_X_OO    O_XX_X_OO  O_XX_XXOO

   /*     String input = scanner.nextLine();
        Board board = new Board(input);
        Node startNode = new Node(board);
        char playerChar = board.getPlayerChar();

        TreeNode treeNode = new TreeNode(startNode);
        treeNode.treeInitialize(startNode, playerChar);
        treeNode.dfs(startNode, playerChar);
        System.out.println("____________Begin________________");
        board.printBoard();
        System.out.println("_________________________________________________");
        System.out.println("Score " + startNode.getScore());
        System.out.println("_______________Best Move___________________");
        startNode.getNeighbours().get(startNode.indexBestMove).board.printBoard();
        System.out.println("_______________Move_________________");
        Spot bestMove = board.getEmptySpots().get(startNode.indexBestMove);
        System.out.println(bestMove.getX() + " " + bestMove.getY());

        System.out.println("_________________________________________________");*/
    }


}
