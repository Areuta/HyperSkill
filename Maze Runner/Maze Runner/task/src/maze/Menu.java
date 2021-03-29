package maze;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    static Maze maze;
    boolean isExit;
    static final Scanner scanner = new Scanner(System.in);
    final static String badInput = "\nIncorrect option. Please try again!";


    void initialize() {
        while (!isExit) {
            try {
                menuShow();
                menuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    abstract void menuProcess();

    abstract void menuShow();

    boolean loadMazeFromFile() {
        System.out.println("\nEnter a path to the file: ");
        scanner.nextLine();
        File file = new File(scanner.nextLine());
        try {
            maze = DaoMaze.loadMaze(file);
            System.out.println();
        } catch (IOException e) {
            System.out.printf("Can't read from file: %s%n", file.getAbsolutePath());
            return false;
        } catch (DaoMaze.SavedMazeException e) {
            System.out.println("Cannot load the maze. It has an invalid format.");
            return false;
        }
        return true;
    }

    void generateNewMaze() {
        System.out.println("\nPlease, enter the size of a maze");
        try {
            int n = scanner.nextInt();
            this.maze = new RandomMaze(n - 2, n - 2);
        } catch (InputMismatchException e) {
            System.out.println(badInput);

        }
    }
}
