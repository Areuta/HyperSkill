package maze;

public class MazeEdge extends Gridable{
    private MazeNode node1;
    private MazeNode node2;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public MazeEdge(MazeNode node1, MazeNode node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
        this.maze = maze;
        this.displayString = MazeNode.WALL;
    }


    public MazeNode getNode1() {
        return node1;
    }

    public MazeNode getNode2() {
        return node2;
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
