package maze;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMaze {
    private static final Scanner scanner = new Scanner(System.in);
    private final String badInput = "Bad input!";
    private Maze maze;

    public MenuMaze() {
            try {
                menuShow();
                maze.getSpanningTree();
                maze.printMaze();

            } catch (InputMismatchException e) {
                scanner.close();
                System.out.println(badInput);
                return;
            }


    }

    private void menuShow() {
        System.out.println("Please, enter the size of a maze");
        // todo check if the input is correct
        maze = new Maze(scanner.nextInt() - 2, scanner.nextInt() - 2);

    }
}
