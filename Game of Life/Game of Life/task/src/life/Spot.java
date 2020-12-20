package life;//Author Anton   20.12.2020

public class Spot {
    private int x;
    private int y;
    private boolean live;

    public Spot(int x, int y, boolean live) {
        this.x = x;
        this.y = y;
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
