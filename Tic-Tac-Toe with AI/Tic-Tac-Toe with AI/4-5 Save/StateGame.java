package tictactoe;

public enum StateGame {
    IMPOSSIBLE("Impossible"),
    GAME_NOT_FINISHED("Game not finished"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw");

    private final String title;

    StateGame(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
