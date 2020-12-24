package life;//Author Anton   20.12.2020

public class Spot {
    private final int x;
    private final int y;
    private final boolean live;

    public Spot(int x, int y, boolean live) {
        this.x = x;
        this.y = y;
        this.live = live;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLive() {
        return live;
    }

}
