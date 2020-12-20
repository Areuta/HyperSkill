package tictactoe;//Author Anton   16.12.2020

import java.util.List;

public class TreeNode {
    private Node currentNode;

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public TreeNode(Node initialNode) {
        this.currentNode = initialNode;
    }

    public void treeInitialize(Node node, char playerChar) {
        if (node.board.checkGameState() == StateGame.GAME_NOT_FINISHED) {
            for (Spot spot : node.board.getEmptySpots()) {
                spot.setC(playerChar);
                String str1 = node.board.toString();
                Board newBoard = new Board(str1);
                spot.setC('_');

                Node newNode = new Node(newBoard);
                node.addNeighbour(newNode);
                if (!node.board.getEmptySpots().isEmpty()) {
                    treeInitialize(newNode, Player.playerCharAlternate(playerChar));
                }
            }

        } else {
            switch (node.board.checkGameState()) {
                case X_WINS:
                    node.setScore(10);
                    break;
                case O_WINS:
                    node.setScore(-10);
                    break;
                case DRAW:
                    node.setScore(0);
                    break;
            }
        }
    }


    // Recursive DFS
    public void dfs(Node initialNode, char playerChar) {
        List<Node> neighbours = initialNode.getNeighbours();
        initialNode.visited = true;
        if (!neighbours.isEmpty()) {
            if (playerChar == 'X') {
                int maxScore = -50;
                int indexMaxScore = 0;
                for (int i = 0; i < neighbours.size(); i++) {
                    Node n = neighbours.get(i);
                    if (n != null && !n.visited) {
                        dfs(n, Player.playerCharAlternate(playerChar));
                        if (n.getScore() > maxScore) {
                            indexMaxScore = i;
                            maxScore = n.getScore();
                        }
                    }

                }
                initialNode.setScore(maxScore);
                initialNode.indexBestMove = indexMaxScore;
            } else {
                int minScore = 50;
                int indexMinScore = 0;
                for (int i = 0; i < neighbours.size(); i++) {
                    Node n = neighbours.get(i);
                    if (n != null && !n.visited) {
                        dfs(n, Player.playerCharAlternate(playerChar));
                        if (n.getScore() < minScore) {
                            indexMinScore = i;
                            minScore = n.getScore();
                        }
                    }
                }
                initialNode.setScore(minScore);
                initialNode.indexBestMove = indexMinScore;
            }
        }

    }
}
