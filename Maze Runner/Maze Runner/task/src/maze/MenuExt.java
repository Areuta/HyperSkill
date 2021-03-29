package maze;

import java.io.File;

public class MenuExt extends Menu {

    @Override
    void menuShow() {
        System.out.println("\n=== Menu ===\n" +
                "1. Generate a new maze\n" +
                "2. Load a maze\n" +
                "3. Save the maze\n" +
                "4. Display the maze\n" +
                "0. Exit");
    }

    @Override
    void menuProcess() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                generateNewMaze();
                maze.printMaze();
                break;
            }
            case 2: {
                if (loadMazeFromFile()) {
                    maze.printMaze();
                }
                break;
            }
            case 3: {
                saveMazeToFile();
                break;
            }
            case 4: {
                maze.printMaze();
                break;
            }
            case 5: {
                maze.findEscape();
                break;
            }
            case 0: {
                System.exit(0);
                break;
            }
        }

    }

    private void saveMazeToFile() {
//        long time = System.currentTimeMillis() / 1000;
        File file = new File("test_maze.txt");
//        File file = new File("maze" + time + ".txt");
//        File file = new File("./Maze Runner/task/src/maze/mazes/maze" + time + ".txt");
        if (DaoMaze.saveMaze(maze, file)) {
            System.out.printf("%nSuccessfully saved maze in file: %s%n", file.getName());
        }
    }


}
