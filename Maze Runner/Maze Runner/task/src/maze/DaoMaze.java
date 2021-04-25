package maze;

import java.io.*;

public class DaoMaze {
    private static Maze maze;

    public static void setMaze(Maze maze) {
        DaoMaze.maze = maze;
    }


    static class SavedMazeException extends Exception {
        public SavedMazeException() {
            super();
        }
    }

    static void saveMazeToFile(String path, Maze maze) {
        DaoMaze.setMaze(maze);
        try (FileOutputStream f = new FileOutputStream(new File(path));
             ObjectOutputStream o = new ObjectOutputStream(f)) {

            o.writeObject(maze);

            System.out.println("Maze saved to file!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    static Maze loadMazeFromFile(String path) throws SavedMazeException {
        File file = new File(path);
        try (FileInputStream f = new FileInputStream(file);
             ObjectInputStream o = new ObjectInputStream(f)) {

            DaoMaze.maze = (Maze) o.readObject();

            System.out.println("Maze loaded from file!");
        } catch (FileNotFoundException e) {
            System.out.printf("Can't read from file: %s%n", file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            throw new SavedMazeException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return maze;
    }

}
