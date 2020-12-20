package tictactoe;//Author Anton   01.12.2020

public class TicTacToe {
    private final Board boardGame;
//    private int countMoves = 0; // stores the number of moves
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    TreeNode minimaxTreeNode;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public TicTacToe(Board boardGame, Player player1, Player player2) {
        this.boardGame = boardGame;
        this.player1 = player1;
        this.player2 = player2;
        player1.setTicTacToe(this);
        player2.setTicTacToe(this);
//        countMoves = 9 - boardGame.getEmptySpots().size();
        setCurrentPlayer(player1);
        if (player1 instanceof AiPlayerHard || player2 instanceof AiPlayerHard) {
            treeCreate();
        }

    }


    public void doNextMove() {
        currentPlayer.move();
        if (currentPlayer.equals(player1)) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
//        countMoves++;
    }

    public void treeCreate () {
        Board board = new Board("_________");
        Node initialNode = new Node(board);
        char playerChar = board.getPlayerChar();

        TreeNode treeNode = new TreeNode(initialNode);
        treeNode.treeInitialize(initialNode, playerChar);
        treeNode.dfs(initialNode, playerChar);

        this.minimaxTreeNode = treeNode;
    }


    public Board getBoardGame() {
        return boardGame;
    }

}
