package tictactoe;//Author Anton   14.12.2020

public class AiPlayerHard extends Player {

    public AiPlayerHard(boolean first) {
        super(first);
        playerString = "Making move level \"hard\"\n";

        /*Board board = new Board("_________");
        Node initialNode = new Node(board);
        char playerChar = board.getPlayerChar();

        TreeNode treeNode = new TreeNode(initialNode);
        treeNode.treeInitialize(initialNode, playerChar);
        treeNode.dfs(initialNode, playerChar);

        this.minimaxTreeNode = treeNode;*/

    }

    @Override
    public void move() {

        numberNextMove = ticTacToe.minimaxTreeNode.getCurrentNode().indexBestMove;
        super.move();

      /*  String input = ticTacToe.getBoardGame().toString();
        Board board = new Board(input);
        Node startNode = new Node(board);
        char playerChar = board.getPlayerChar();

        TreeNode treeNode = new TreeNode(startNode);
        treeNode.treeInitialize(startNode, playerChar);
        treeNode.dfs(startNode, playerChar);


        Spot bestMove = ticTacToe.getBoardGame().getEmptySpots().get(startNode.indexBestMove);
        bestMove.setC(getPlayerChar());
        treeNode.setCurrentNode(treeNode.getCurrentNode().neighbours.get(startNode.indexBestMove));*/

    }


}
