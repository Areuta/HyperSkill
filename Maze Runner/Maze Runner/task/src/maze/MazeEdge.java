package maze;

public class MazeEdge {
    private String displayString;
    private MazeNode node1;
    private MazeNode node2;
    private int row;
    private int column;
    private int weight;
    private Maze maze;
    public static final int INF = 100_000_000;

    public int getWeight() {
        return weight;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return displayString;
    }

    public MazeEdge(MazeNode node1, MazeNode node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
        this.maze = maze;
        this.displayString = MazeNode.WALL;
//        this.displayString = String.valueOf(weight) + weight;
    }

    public MazeEdge(MazeNode node1, MazeNode node2, Maze maze) {
        this.node1 = node1;
        this.node2 = node2;
        this.maze = maze;
        this.weight = INF;
    }

    public MazeNode getNode1() {
        return node1;
    }

    public MazeNode getNode2() {
        return node2;
    }

    public boolean incident(MazeNode node) {
        return this.node1.equals(node) || this.node2.equals(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return this.node1.equals(((MazeEdge) obj).node1) && this.node2.equals(((MazeEdge) obj).node2)
                || this.node1.equals(((MazeEdge) obj).node2) && this.node2.equals(((MazeEdge) obj).node1);
    }

    @Override
    public int hashCode() {
        return this.node1.hashCode() + this.node2.hashCode();
    }
}
