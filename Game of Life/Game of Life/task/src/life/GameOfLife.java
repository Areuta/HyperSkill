package life;//Author Anton   20.12.2020

import java.util.Random;

public class GameOfLife {
    private final Spot[][] field;
    private final int dimOfWorld;
    private final long alive;
    static int numberGenerations = 1;

    private long aliveCreate() {
        long res = 0;
        for (Spot[] spots : field) {
            for (Spot spot : spots) {
                if (spot.isLive()) {
                    res++;
                }
            }
        }
        return res;
    }

    public Spot[][] getField() {
        return field;
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
        this.alive = aliveCreate();
    }

    public GameOfLife(Spot[][] field) {
        this.dimOfWorld = field.length;
        this.field = field;
        this.alive = aliveCreate();
        numberGenerations++;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Generation #%d\n", numberGenerations));
        sb.append(String.format("Alive: %d\n", alive));
//        sb.append("Generation: #" + numberGenerations + "\n");
//        sb.append("Alive: " + alive + "\n");
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
