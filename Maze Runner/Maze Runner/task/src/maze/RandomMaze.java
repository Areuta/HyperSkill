package maze;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static maze.Gridable.PASS;
import static maze.Gridable.WALL;

public class RandomMaze extends Maze {

    public RandomMaze(int height, int width) {
        super(height, width);
        generateMazeNodes();
        generateInlets();
        getSpanningTree();
    }



    private void generateMazeNodes() {
        for (int i = 0; i < height; i += 2) {
            for (int j = 0; j < width; j += 2) {
                MazeNode node = new MazeNode(i, j, PASS, this);
                cells[i][j] = node;
                mazeNodes.add(node);
            }
        }
        for (int i = 1; i < height; i += 2) {
            for (int j = 1; j < width; j += 2) {
                cells[i][j] = new MazeNode(i, j, WALL, this);
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
                    cells[i][j] = new MazeNode(i, j, PASS, this);
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
                    cells[i][j] = new MazeNode(i, j, PASS, this);

                }
            }
        }

        for (int i = 0; i < height; i += 2) {
            for (int j = 0; j < width; j += 2) {
                MazeNode node = (MazeNode) cells[i][j];
                node.addNeighbours();
            }
        }
    }

    private void generateInlets() {
        leftToRight = (int) (Math.random() * 10) % 2 == 0;
        boolean upToDown = !leftToRight;
        if (leftToRight) {
            int position = (int) (Math.random() * height / 2) * 2;
            start = (MazeNode) cells[position][0];
            position = (int) (Math.random() * height / 2) * 2;
            if (width % 2 == 0) {
                goal = (MazeNode) cells[position][width - 2];
            } else {
                goal = (MazeNode) cells[position][width - 1];
            }
        }

        if (upToDown) {
            int position = (int) (Math.random() * width / 2) * 2;
            start = (MazeNode) cells[0][position];
            position = (int) (Math.random() * width / 2) * 2;
            if (height % 2 == 0) {
                goal = (MazeNode) cells[height - 2][position];
            } else {
                goal = (MazeNode) cells[height - 1][position];
            }
        }
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
}
