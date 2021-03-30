package maze;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import static maze.Gridable.*;

public class Maze implements Serializable {
    private static final long serialVersionUID = 1L;
    Gridable[][] cells;
    int width;
    int height;
    MazeNode start;
    MazeNode goal;
    HashSet<MazeEdge> mazeEdges;
    HashSet<MazeNode> mazeNodes;
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


    public void getSpanningTree() {
        Set<MazeEdge> spanTree = new HashSet<>();
        Set<MazeEdge> exploreEdges = new HashSet<>();
        Set<MazeNode> visited = new HashSet<>();
        Set<MazeNode> mazeNods = new HashSet<>(mazeNodes);
        MazeNode current = start;

        while (!mazeNods.isEmpty()) {
            mazeNods.remove(current);

            // add neighbours current node
            current.getNeighbours().values().forEach(mazeEdge -> {
                if (!spanTree.contains(mazeEdge)) exploreEdges.add(mazeEdge);
            });

            //remove the edges leading to the loops
            exploreEdges.forEach(mazeEdge -> {
                if (mazeNods.contains(mazeEdge.getNode1())
                        && mazeNods.contains(mazeEdge.getNode2())) {
                    exploreEdges.remove(mazeEdge);
                }
            });

            // find the edges with the minimum weight
            int min = exploreEdges.stream()
                    .mapToInt(MazeEdge::getWeight)
                    .min().getAsInt();
            List<MazeEdge> minEdges = exploreEdges.stream()
                    .filter(mazeEdge -> mazeEdge.getWeight() == min)
                    .collect(Collectors.toList());

            // select the edge leading to the new vertex
            MazeEdge minEdge = minEdges.stream()
                    .filter(edge -> !spanTree.contains(edge))
                    .findAny().get();

            visited.add(current);
            current = visited.contains(minEdge.getNode1()) ? minEdge.getNode2() : minEdge.getNode1();
            current.setDisplayString(PASS);

            minEdge.setDisplayString(PASS);

            spanTree.add(minEdge);
            exploreEdges.remove(minEdge);

        }

    }

    public String toString(LinkedList<Gridable> path) {
        StringBuilder sb = new StringBuilder();

        // first line
        for (int c = 0; c < width + 2; c++) {
            if (!leftToRight && start.getColumn() == c - 1) {
                sb.append(path == null ? PASS : PATH);
            } else {
                sb.append(WALL);
            }
        }
        sb.append("\n");

        // ordinary lines
        int l = height % 2 == 0 ? height - 1 : height;
        for (int r = 0; r < l; r++) {

            // first element of the line
            if (leftToRight && start.getRow() == r) {
                sb.append(path != null ? PATH : PASS);
            } else {
                sb.append(WALL);
            }

            // ordinary elements
            int k = width % 2 == 0 ? width - 1 : width;
            for (int c = 0; c < k; c++) {
                if (path != null && path.contains(cells[r][c])) {
                    sb.append(PATH);
                } else {
                    sb.append(cells[r][c].getDisplayString());
                }
            }

            // last element of the line
            if (leftToRight && goal.getRow() == r) {
                sb.append(path == null ? PASS : PATH);
                if (k == width - 1) {
                    sb.append(path == null ? PASS : WALL);
                }

            } else {
                if (k == width - 1) {
                    sb.append(cells[r][k - 1].getDisplayString());
                }
                sb.append(WALL);
            }
            sb.append("\n");
        }

        // penultimate line if height % 2 == 0
        if (height % 2 == 0) {
            sb.append(WALL);
            for (int c = 0; c < width; c++) {
                if (!leftToRight && goal.getColumn() == c) {
                    sb.append(path == null ? PASS : PATH);
                } else {
                    sb.append(cells[height - 2][c].getDisplayString());
                }
            }
            sb.append(WALL).append("\n");
        }

        // last line
        for (int c = 0; c < width + 2; c++) {
            if (!leftToRight && goal.getColumn() == c - 1) {
                sb.append(path == null ? PASS : PATH);
            } else {
                sb.append(WALL);
            }
        }

        return sb.toString();
    }

    public void printMaze() {
//        System.out.println(this.toString());
        System.out.println(this.toString(findEscape()));
    }

    public LinkedList<Gridable> findEscape() {
        Set<Gridable> visited = new HashSet<>();
        HashMap<Gridable, Gridable> parentMap = new HashMap<>();
        Queue<MazeNode> toExplore = new ArrayDeque<>();

        boolean found = false;
        toExplore.add(start);
        visited.add(start);

        while (!toExplore.isEmpty()) {
            MazeNode current = toExplore.poll();
            if (current == goal) {
                found = true;
                break;
            }

            // add neighbours current node
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

        if (!found) {
            System.out.println("No path exists");
            return null;
        }

        // reconstruct the path
        LinkedList<Gridable> path = new LinkedList<>();
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
