package tictactoe;

public enum PlayerTypes {
    USER("user"), EASY("easy"), MEDIUM("medium"), HARD("hard");
    public final String title;

    PlayerTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public PlayerTypes getType(String str) {
        return PlayerTypes.valueOf(str.toUpperCase());
    }
}
