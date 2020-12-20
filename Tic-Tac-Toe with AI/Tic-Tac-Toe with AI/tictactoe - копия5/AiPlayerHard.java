package tictactoe;//Author Anton   14.12.2020

public class AiPlayerHard extends Player {

    public AiPlayerHard(boolean first) {
        super(first);
        playerString = "Making move level \"hard\"";

    }

    @Override
    public void move() {
        super.move();

        String input = ticTacToe.getBoardGame().toString();
        Board board = new Board(input);
        Node startNode = new Node(board);
        char playerChar = board.getPlayerChar();

        TreeNode treeNode = new TreeNode(startNode);
        treeNode.treeInitialize(startNode, playerChar);
        treeNode.dfs(startNode, playerChar);
       /* System.out.println("Score " + startNode.getScore());
        System.out.println("_______________Best Move___________________");
        startNode.getNeighbours().get(startNode.indexBestMove).board.printBoard();
        System.out.println("_______________Move_________________");
        Spot bestMove1 = board.getEmptySpots().get(startNode.indexBestMove);
        System.out.println(bestMove1.getX() + " " + bestMove1.getY());

        System.out.println("_________________________________________________");*/

        Spot bestMove = ticTacToe.getBoardGame().getEmptySpots().get(startNode.indexBestMove);
        bestMove.setC(getPlayerChar());


    }


}
