package maze;

import java.util.HashMap;
import java.util.Map;

public class MazeNode {

    private int row;
    private int column;
    private String displayString;
    private Map<MazeNode, MazeEdge> neighbours;
    private Maze maze;
    public static final String PASS = "  ";
    public static final String WALL = "\u2588\u2588";


    /**
     * @return the displayChar
     */
    public String getDisplayString() {
        return displayString;
    }

    /**
     * @param displayString the displayChar to set
     */
    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public MazeNode(int row, int column, String displayString, Maze maze) {
        this.row = row;
        this.column = column;
        this.displayString = displayString;
        this.maze = maze;
    }

    public void addNeighbours() {
        this.neighbours = fillNeighbours();
    }

    public Map<MazeNode, MazeEdge> getNeighbours() {
        return neighbours;
    }

    private Map<MazeNode, MazeEdge> fillNeighbours() {
        Map<MazeNode, MazeEdge> neighbours = new HashMap<>();
        if (row > 1) {
            neighbours.put((MazeNode) maze.getCells()[row - 2][column]
                    , (MazeEdge) maze.getCells()[row - 1][column]);
        }
        if (row < maze.getHeight() - 2) {
            neighbours.put((MazeNode) maze.getCells()[row + 2][column]
                    , (MazeEdge) maze.getCells()[row + 1][column]);
        }
        if (column > 1) {
            neighbours.put((MazeNode) maze.getCells()[row][column - 2]
                    , (MazeEdge) maze.getCells()[row][column - 1]);
        }
        if (column < maze.getWidth() - 2) {
            neighbours.put((MazeNode) maze.getCells()[row][column + 2]
                    , (MazeEdge) maze.getCells()[row][column + 1]);
        }

        return neighbours;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }


}
