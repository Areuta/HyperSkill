package tictactoe;//Author Anton   01.12.2020

public class TicTacToe {
    private final Board boardGame;
    private byte countMoves = 0; // stores the number of moves
    private Player player1;
    private Player player2;

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public TicTacToe(Board boardGame) {
        this.boardGame = boardGame;

        for (Spot spot : boardGame.getSpots()) {
            if (spot.getC() == 'X' || spot.getC() == 'O') {
                countMoves++;
            }
        }
    }

    public StateGame checkGameState() {

        if (boardGame.checkTriples('X', 3 * ('X'))) return StateGame.X_WINS;
        if (boardGame.checkTriples('O', 3 * ('O'))) return StateGame.O_WINS;
        if (countMoves == 9) return StateGame.DRAW;
        return StateGame.GAME_NOT_FINISHED;
    }

    public void doNextMove() {
        if (countMoves % 2 == 0) {
            player1.move();
        } else {
            player2.move();
        }
        countMoves++;
    }


    public Board getBoardGame() {
        return boardGame;
    }


}
