package tictactoe;//Author Anton   01.12.2020

public class TicTacToe {
    private final Board boardGame;
    private int countMoves = 0; // stores the number of moves
    private Player player1;
    private Player player2;
    private Player currentPlayer;

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
        countMoves = 9 - boardGame.getEmptySpots().size();
        setCurrentPlayer(player1);

    }



    public void doNextMove() {
        currentPlayer.move();
        if (currentPlayer.equals(player1)) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
        countMoves++;
    }


    public Board getBoardGame() {
        return boardGame;
    }

}
