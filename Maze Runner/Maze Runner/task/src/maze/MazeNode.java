package maze;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MazeNode extends Gridable implements Serializable {
    private Map<MazeNode, MazeEdge> neighbours;

    public MazeNode(int row, int column, String displayString, Maze maze) {
        this.row = row;
        this.column = column;
        this.displayString = displayString;
        this.maze = maze;
    }

    public Map<MazeNode, MazeEdge> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Map<MazeNode, MazeEdge> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbours() {
        this.neighbours = defineNeighbours();
    }

    private Map<MazeNode, MazeEdge> defineNeighbours() {
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


}
