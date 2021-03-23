package maze;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Maze {
    private Object[][] cells;
    private int width;
    private int height;
    private MazeNode start;
    private MazeNode goal;
    private HashSet<MazeEdge> mazeEdges;
    private HashSet<MazeNode> mazeNodes;
    boolean directionFromLeftToRight;

    public Object[][] getCells() {
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Create a new empty Maze with specified height and width
     */
    public Maze(int height, int width) {
        cells = new Object[height][width];
        mazeEdges = new HashSet<>();
        mazeNodes = new HashSet<>();
        this.height = height;
        this.width = width;

        generateMazeNodes();
        generateInlets();
    }


    private void generateMazeNodes() {
        for (int i = 0; i < height; i += 2) {
            for (int j = 0; j < width; j += 2) {
                MazeNode node = new MazeNode(i, j, MazeNode.PASS, this);
                cells[i][j] = node;
                mazeNodes.add(node);
            }
        }
        for (int i = 1; i < height; i += 2) {
            for (int j = 1; j < width; j += 2) {
                cells[i][j] = new MazeNode(i, j, MazeNode.WALL, this);
            }
        }

        for (int i = 0; i < height; i += 2) {
            for (int j = 1; j < width; j += 2) {
                if (j != width - 1) {
                    MazeEdge edge = new MazeEdge((MazeNode) cells[i][j - 1]
                            , (MazeNode) cells[i][j + 1]
                            , (int) (Math.random() * 10));
                    cells[i][j] = edge;
                    mazeEdges.add(edge);
                } else {
                    cells[i][j] = new MazeNode(i, j, MazeNode.PASS, this);
                }
            }
        }

        for (int i = 1; i < height; i += 2) {
            for (int j = 0; j < width; j += 2) {
                if (i != height - 1) {
                    MazeEdge edge = new MazeEdge((MazeNode) cells[i - 1][j], (MazeNode) cells[i + 1][j]
                            , (int) (Math.random() * 10));
                    cells[i][j] = edge;
                    mazeEdges.add(edge);
                } else {
                    cells[i][j] = new MazeNode(i, j, MazeNode.PASS, this);

                }
            }
        }

        for (int i = 0; i < height; i += 2) {
            for (int j = 0; j < width; j += 2) {
                MazeNode node = (MazeNode) cells[i][j];
                node.addNeighbours();
            }
        }
//        System.out.println("MazeNodes: " + mazeNodes.size());
    }


    private void generateInlets() {
        directionFromLeftToRight = (int) (Math.random() * 10) % 2 == 0;
        boolean directionFromUpToDown = !directionFromLeftToRight;
        if (directionFromLeftToRight) {
            int position = (int) (Math.random() * height / 2) * 2;
            start = (MazeNode) cells[position][0];
            position = (int) (Math.random() * height / 2) * 2;
            goal = (MazeNode) cells[position][width - 1];
        }
        if (directionFromUpToDown) {
            int position = (int) (Math.random() * width / 2) * 2;
            start = (MazeNode) cells[0][position];
            position = (int) (Math.random() * width / 2) * 2;
            goal = (MazeNode) cells[height - 1][position];
        }

//        System.out.printf("directionFromLeftToRight %b %n", directionFromLeftToRight);
//        start.setDisplayString("SS");
//        System.out.printf("Start: %d %d %n", start.getRow(), start.getColumn());
//        goal.setDisplayString("GG");
//        System.out.printf("Goal: %d %d %n", goal.getRow(), goal.getColumn());

    }

    public Set<MazeEdge> getSpanningTree() {
        Set<MazeEdge> spanTree = new HashSet<>();
        Set<MazeEdge> exploreEdges = new HashSet<>();
        Set<MazeNode> visited = new HashSet<>();

        MazeNode current = start;
        int s = 0;
        while (!mazeNodes.isEmpty()) {
//        while (s < mazeNodes.size()) {
            mazeNodes.remove(current);
            // add neighbours current node
            current.getNeighbours().values().forEach((mazeEdge) -> {
                if (!spanTree.contains(mazeEdge)) exploreEdges.add(mazeEdge);
            });

//            System.out.printf("\nCurrent: %d %d Number: %d\n", current.getRow(), current.getColumn(), s);
//            System.out.println("Number neighbours: " + current.getNeighbours().size());
//            System.out.print("Edges to explore: ");
//            exploreEdges.forEach(mazeEdge -> System.out.printf(" %d ", mazeEdge.getWeight()));
//            System.out.println();

            exploreEdges.forEach(mazeEdge -> {
                if (mazeNodes.contains(mazeEdge.getNode1())
                        && mazeNodes.contains(mazeEdge.getNode2())) {
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
//                    .filter(edge -> !visited.contains(edge.getNode1()) || !visited.contains(edge.getNode2()))
                    .findAny().get();

            visited.add(current);
            current = visited.contains(minEdge.getNode1()) ? minEdge.getNode2() : minEdge.getNode1();
            current.setDisplayString("  ");

//            if (minEdge.getNode1().getRow() == minEdge.getNode2().getRow()) {
//                minEdge.setDisplayString("-" + s % 10);
//            } else {
//                minEdge.setDisplayString("|" + s % 10);
//            }
            minEdge.setDisplayString(MazeNode.PASS);

//            System.out.print("Min number: " + min + " ");
//            System.out.printf("Min edge: (%d %d) (%d %d)\n"
//                    , minEdge.getNode1().getRow(), minEdge.getNode1().getColumn()
//                    , minEdge.getNode2().getRow(), minEdge.getNode2().getColumn());

            spanTree.add(minEdge);
            exploreEdges.remove(minEdge);

            s++;
        }

        return spanTree;
    }


    /**
     * Print the maze grid to the screen.
     */
    public void printMaze() {
        // first line
        System.out.println();
        for (int c = 0; c < width + 2; c++) {
            if (!directionFromLeftToRight && start.getColumn() == c - 1) {
                System.out.print(MazeNode.PASS);
            } else {
                System.out.print(MazeNode.WALL);
            }
        }
        System.out.println();

// ordinary lines
        for (int r = 0; r < height; r++) {
            if (directionFromLeftToRight && start.getRow() == r) {
                System.out.print(MazeNode.PASS);
            } else {
                System.out.print(MazeNode.WALL);
            }

            for (int c = 0; c < width; c++) {
                if (cells[r][c] instanceof MazeNode) {
                    System.out.print(((MazeNode) cells[r][c]).getDisplayString());
                } else if (cells[r][c] instanceof MazeEdge) {
                    System.out.print(((MazeEdge) cells[r][c]).getDisplayString());
                }
            }

            if (directionFromLeftToRight && goal.getRow() == r) {
                System.out.print(MazeNode.PASS+ "\n");
            } else {
                System.out.print(MazeNode.WALL + "\n");
            }
        }

        // last line
        for (int c = 0; c < width + 2; c++) {
            if (!directionFromLeftToRight && goal.getColumn() == c - 1) {
                System.out.print(MazeNode.PASS);
            } else {
                System.out.print(MazeNode.WALL);
            }
        }
        System.out.println();
    }

}
