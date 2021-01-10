package life;//Author Anton   21.12.2020

import java.util.ArrayList;
import java.util.List;


public class NextLives {
    private static int dim = GameOfLife.getDimOfWorld();

    public static Generation nextLife(Generation initialLife) {
        Spot[][] newField = new Spot[dim][dim];
        for (int j = 0; j < dim; j++) {
            for (int k = 0; k < dim; k++) {
                Spot spot = initialLife.getField()[j][k];
                List<Spot> list = getNeighbors(spot, initialLife);
                byte sum = getNeighborsCount(list);
                boolean live = false;
                if (sum == 3 || (sum == 2 && spot.isLive())) {
                    live = true;
                }
                newField[j][k] = new Spot(j, k, live);
            }
        }

        return new Generation(newField);
    }

    private static byte getNeighborsCount(List<Spot> neighbors) {
        byte sum = 0;
        for (Spot spot : neighbors) {
            sum += spot.isLive() ? 1 : 0;
        }
        return sum;
    }

    private static List<Spot> getNeighbors(Spot spot, Generation generation) {
        int x = spot.getX();
        int y = spot.getY();
        List<Spot> list = new ArrayList<>(8);
        list.add(generation.getField()[x][(y + 1) % dim]);
        list.add(generation.getField()[x][(y + dim - 1) % dim]);
        list.add(generation.getField()[(x + 1) % dim][(y + dim - 1) % dim]);
        list.add(generation.getField()[(x + 1) % dim][y]);
        list.add(generation.getField()[(x + 1) % dim][(y + 1) % dim]);
        list.add(generation.getField()[(x + dim - 1) % dim][(y + dim - 1) % dim]);
        list.add(generation.getField()[(x + dim - 1) % dim][y]);
        list.add(generation.getField()[(x + dim - 1) % dim][(y + 1) % dim]);
        return list;
    }


}
