package life;//Author Anton   20.12.2020

import java.util.Random;

public class GameOfLife {
    private Spot[][] field;
    private final int dimOfWorld;

    public Spot[][] getField() {
        return field;
    }

    public void setField(Spot[][] field) {
        this.field = field;
    }

    public int getDimOfWorld() {
        return dimOfWorld;
    }

    public GameOfLife(int dimOfWorld, int seed) {
        this.dimOfWorld = dimOfWorld;
        Main.seed = seed;
        Random random = new Random(seed);
        Spot[][] spots = new Spot[dimOfWorld][dimOfWorld];

        for (int i = 0; i < dimOfWorld; i++) {
            for (int j = 0; j < dimOfWorld; j++) {
                spots[i][j] = new Spot(i, j, random.nextBoolean());
            }
        }
        this.field = spots;
    }

    public GameOfLife(Spot[][] field) {
        this.dimOfWorld = field.length;
        this.field = field;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimOfWorld; i++) {
            for (int j = 0; j < dimOfWorld; j++) {
                sb.append(field[i][j].isLive() ? "O" : " ");
            }
            if (i < dimOfWorld - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
