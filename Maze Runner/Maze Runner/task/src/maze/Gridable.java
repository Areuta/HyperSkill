package maze;

public abstract class Gridable {
    int row;
    int column;
    String displayString;
    Maze maze;

    public static final String PASS = "  ";
    public static final String WALL = "\u2588\u2588";

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }
}
