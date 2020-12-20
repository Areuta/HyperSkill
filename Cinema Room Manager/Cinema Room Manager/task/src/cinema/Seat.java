package cinema;//Author Anton   28.11.2020

public class Seat {
    private final int cost;
    private boolean busy;

    public Seat(int cost) {
        this.cost = cost;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getCost() {
        return cost;
    }

    public boolean isBusy() {
        return busy;
    }
}
