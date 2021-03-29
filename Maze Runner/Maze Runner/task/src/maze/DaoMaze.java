package maze;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static maze.Gridable.PASS;
import static maze.Gridable.WALL;

public class DaoMaze {
    private static Maze maze;

    public static Maze loadMaze(File file) throws IOException, SavedMazeException {
        List<String> lines = Files.readAllLines(Path.of(file.getAbsolutePath()));
        maze = getAttrMaze(lines.get(0));
        lines.remove(0);
        checkSize(lines);
        checkSymbolsOk(lines);
        checkEnters(lines);
        generateNodes(lines);
        return maze;
    }

    private static void generateNodes(List<String> lines) throws SavedMazeException {
        try {
            for (int i = 0; i < maze.height; i++) {
                for (int j = 0; j < maze.width; j++) {
                    String defString = lines.get(i + 1).charAt((j+ 1) * 2) == '\u2588' ? WALL : PASS;
                    MazeNode node = new MazeNode(i, j, defString, maze);
                    maze.cells[i][j] = node;
                    maze.mazeNodes.add(node);
                }
            }
        } catch (Exception e) {
            throw new SavedMazeException();
        }
    }

    private static Maze getAttrMaze(String s) throws SavedMazeException {
        String[] attr = s.split("\\s");
        if (attr.length != 7) throw new SavedMazeException();

        try {
            int height = Integer.parseInt(attr[0]);
            int width = Integer.parseInt(attr[1]);
            boolean direction = Boolean.parseBoolean(attr[2]);
            int startRow = Integer.parseInt(attr[3]);
            int startCol = Integer.parseInt(attr[4]);
            int goalRow = Integer.parseInt(attr[5]);
            int goalCol = Integer.parseInt(attr[6]);

            Maze maze = new Maze(height - 2, width - 2);
            maze.leftToRight = direction;
            maze.start = new MazeNode(startRow, startCol, PASS, maze);
            maze.goal = new MazeNode(goalRow, goalCol, PASS, maze);
            return maze;
        } catch (NumberFormatException e) {
            throw new SavedMazeException();
        }
    }

    private static void checkSize(List<String> lines) throws SavedMazeException {
        if (lines.size() != maze.height + 2 || lines.stream()
                .noneMatch(s -> s.length() == 2 * (maze.width + 2))) {
            throw new SavedMazeException();
        }
    }

    private static void checkSymbolsOk(List<String> lines) throws SavedMazeException {
        if (lines.stream().anyMatch(s -> !lineOk(s))) {
            throw new SavedMazeException();
        }
    }

    private static boolean lineOk(String s) {
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void checkEnters(List<String> lines) throws SavedMazeException {
        //  check the walls in the corners
        if (!(lines.get(0).startsWith(WALL) && lines.get(0).endsWith(WALL)
                && lines.get(maze.height + 1).startsWith(WALL)
                && lines.get(maze.height + 1).endsWith(WALL))
        ) {
            throw new SavedMazeException();
        }

        int sr = maze.start.getRow();
        int sc = maze.start.getColumn();
        int gr = maze.goal.getRow();
        int gc = maze.goal.getColumn();

        if (maze.leftToRight) {
            if (
                // check start and goal are in a suitable position
                    sc != 0
                            || gc != maze.width - 1

                            // check passages in this places are free
                            || !lines.get(sr + 1).startsWith(PASS)
                            || !lines.get(gr + 1).endsWith(PASS)

                            // check the top and bottom borders are entirely made up of walls
                            || !lines.get(0).matches("[\u2588]+")
                            || !lines.get(maze.height + 1).matches("[\u2588]+")

                            // check entrance only one
                            || lines.stream()
                            .filter(s -> s.startsWith(PASS))
                            .count() != 1

                            // check only one way out
                            || lines.stream()
                            .filter(s -> s.endsWith(PASS))
                            .count() != 1

            ) {
                throw new SavedMazeException();
            }
        } else {
            if (
                // check start and goal are in a suitable position
                    sr != 0
                            || gr != maze.height - 1

                            // check passages in this places are free
                            || !lines.get(0).startsWith(PASS, 2 * (sc + 1))
                            || !lines.get(1).startsWith(PASS, 2 * (sc + 1))
                            || !lines.get(maze.height).startsWith(PASS, 2 * (gc + 1))
                            || !lines.get(maze.height + 1).startsWith(PASS, 2 * (gc + 1))

                            // check the left and right borders are entirely made up of walls
                            || !lines.stream().allMatch(s -> s.startsWith(WALL))
                            || !lines.stream().allMatch(s -> s.endsWith(WALL))

                            // check entrance only one
                            || lines.get(0).chars()
                            .filter(i -> i == '\u0020')
                            .count() != 2

                            // check only one way out
                            || lines.get(maze.height + 1).chars()
                            .filter(i -> i == '\u0020')
                            .count() != 2
            ) {
                throw new SavedMazeException();
            }
        }
    }

    public static boolean saveMaze(Maze maze, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            String line0 = String.format("%d %d %b %d %d %d %d%n"
                    , maze.getHeight() + 2, maze.getWidth() + 2, maze.isLeftToRight()
                    , maze.start.getRow(), maze.start.getColumn()
                    , maze.goal.getRow(), maze.goal.getColumn());
            fileWriter.write(line0);
            fileWriter.write(maze.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Something is wrong while saving the maze!");
        }
        return false;
    }

    static class SavedMazeException extends Exception {

        public SavedMazeException() {
            super();
        }
    }


}
