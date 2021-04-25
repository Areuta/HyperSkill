package maze;

import java.io.Serializable;
import java.util.*;

import static maze.Gridable.*;

public class Maze implements Serializable {
    private static final long serialVersionUID = 1L;
    Gridable[][] cells;
    int width;
    int height;
    MazeNode start;
    MazeNode goal;
    transient HashSet<MazeEdge> mazeEdges;
    transient HashSet<MazeNode> mazeNodes;
    boolean leftToRight;

    public Maze(int height, int width) {
        cells = new Gridable[height][width];
        mazeEdges = new HashSet<>();
        mazeNodes = new HashSet<>();
        this.height = height;
        this.width = width;
    }

    public boolean isLeftToRight() {
        return leftToRight;
    }

    public Gridable[][] getCells() {
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public List<Gridable> findEscape() {
        Set<Gridable> visited = new HashSet<>();
        HashMap<Gridable, Gridable> parentMap = new HashMap<>();
        Queue<MazeNode> toExplore = new ArrayDeque<>();
        LinkedList<Gridable> path = new LinkedList<>();
        toExplore.add(start);
        visited.add(start);

        while (!toExplore.isEmpty()) {
            MazeNode current = toExplore.poll();
            if (current == goal) {
                break;
            }

            // add neighbours of the current node
            current.getNeighbours().forEach((node, mazeEdge) -> {
                if (!visited.contains(node)
                        && !visited.contains(mazeEdge)
                        && node.getDisplayString().equals(PASS)
                        && mazeEdge.getDisplayString().equals(PASS)) {
                    visited.add(node);
                    visited.add(mazeEdge);
                    parentMap.put(mazeEdge, current);
                    parentMap.put(node, mazeEdge);
                    toExplore.add(node);
                }
            });
        }

        // reconstruct the path
        MazeNode currNode = goal;
        MazeEdge currEdge;
        while (currNode != start) {
            path.addFirst(currNode);
            currEdge = (MazeEdge) parentMap.get(currNode);
            path.addFirst(currEdge);
            currNode = (MazeNode) parentMap.get(currEdge);
        }
        path.addFirst(start);
        return path;

    }

    public String showPath(List<Gridable> path) {
        if (path.isEmpty()) return this.toString();

        StringBuilder sb = new StringBuilder();
        // first line
        for (int c = 0; c < width + 2; c++) {
            sb.append(!leftToRight && start.getColumn() == c - 1 ? PATH : WALL);
        }
        sb.append("\n");

        // ordinary lines
        int l = height % 2 == 0 ? height - 1 : height;
        for (int r = 0; r < l; r++) {

            // first element of the line
            sb.append(leftToRight && start.getRow() == r ? PATH : WALL);

            // ordinary elements
            int k = width % 2 == 0 ? width - 1 : width;
            for (int c = 0; c < k; c++) {
                sb.append(path.contains(cells[r][c]) ? PATH : cells[r][c].getDisplayString());
            }

            // last element of the line
            if (leftToRight && goal.getRow() == r) {
                sb.append(PATH);
                // if the width is even
                if (k == width - 1) {
                    sb.append(PATH);
                }
            } else {
                if (k == width - 1) {
                    sb.append(cells[r][k - 1].getDisplayString());
                }
                sb.append(WALL);
            }
            sb.append("\n");
        }

        // penultimate line if the height is even
        if (height % 2 == 0) {
            sb.append(WALL);
            for (int c = 0; c < width; c++) {
                sb.append(!leftToRight && goal.getColumn() == c
                        ? PATH : cells[height - 2][c].getDisplayString());
            }
            sb.append(WALL).append("\n");
        }

        // last line
        for (int c = 0; c < width + 2; c++) {
            sb.append(!leftToRight && goal.getColumn() == c
                    ? PATH : WALL);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // first line
        for (int c = 0; c < width + 2; c++) {
            sb.append(!leftToRight && start.getColumn() == c - 1 ? PASS : WALL);
        }
        sb.append("\n");

        // ordinary lines
        for (int r = 0; r < height; r++) {

            // first element of the line
            sb.append(leftToRight && start.getRow() == r ? PASS : WALL);

            // ordinary elements
            for (int c = 0; c < width; c++) {
                sb.append(cells[r][c].getDisplayString());
            }
            // last element of the line
            sb.append(leftToRight && goal.getRow() == r ? PASS : WALL).append("\n");
        }

        // last line
        for (int c = 0; c < width + 2; c++) {
            sb.append(!leftToRight && goal.getColumn() == c - 1 ? PASS : WALL);
        }

        return sb.toString();
    }
}
