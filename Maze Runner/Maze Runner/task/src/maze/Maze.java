package maze;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static maze.Gridable.PASS;
import static maze.Gridable.WALL;

public class Maze {
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

    public void printMaze() {
        System.out.println(this);
    }

    public void findEscape() {
    }
}
