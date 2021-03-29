package maze;

public class SimpleMenu extends Menu{

    void menuShow() {
        System.out.println("\n=== Menu ===\n" +
                "1. Generate a new maze\n" +
                "2. Load a maze\n" +
                "0. Exit");
    }


    void menuProcess() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                generateNewMaze();
                maze.printMaze();
                new MenuExt().initialize();
                break;
            }
            case 2: {
                if (loadMazeFromFile()){
                    maze.printMaze();
                }
                break;
            }
            case 0: {
                isExit = true;
                break;
            }
            default: {
                System.out.println(badInput);
            }
        }
    }



}
