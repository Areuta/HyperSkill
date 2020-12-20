package life;//Author Anton   20.12.2020

import java.util.Random;

public class GameOfLife {
    private final Spot[][] field;
    private final int dimOfWorld;

    public GameOfLife(int dimOfWorld, int seed) {
        this.dimOfWorld = dimOfWorld;
        Random random = new Random(seed);
        Spot[][] spots = new Spot[dimOfWorld][dimOfWorld];

        for (int i = 0; i < dimOfWorld; i++) {
            for (int j = 0; j < dimOfWorld; j++) {
                spots[i][j] = new Spot(i, j, random.nextBoolean());
            }
        }
        this.field = spots;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimOfWorld; i++) {
            for (int j = 0; j < dimOfWorld; j++) {
                sb.append(field[i][j].isLive() ? 'O' : ' ');
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
