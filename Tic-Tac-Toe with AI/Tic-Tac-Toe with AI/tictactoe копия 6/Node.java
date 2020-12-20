package tictactoe;//Author Anton   16.12.2020

import java.util.ArrayList;
import java.util.List;

public class Node {
    int score;
    Board board;
    boolean visited;
    List<Node> neighbours;
    int indexBestMove;

    Node(Board board) {
        this.board = board;
        this.neighbours = new ArrayList<>();

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addNeighbour(Node neighbourNode) {
        this.neighbours.add(neighbourNode);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

}
