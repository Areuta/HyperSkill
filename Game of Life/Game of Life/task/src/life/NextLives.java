package life;//Author Anton   21.12.2020

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NextLives {
    LinkedList<GameOfLife> nextGenerations;
    private int dim;

    public NextLives(GameOfLife gameOfLife, int countGen) {
        this.dim = gameOfLife.getDimOfWorld();
        nextGenerations = new LinkedList<>();
        nextGenerations.add(gameOfLife);
    }

    public GameOfLife produce(GameOfLife initialLife, int countGen) {
        GameOfLife currentLife = initialLife;
        for (int i = 0; i < countGen; i++) {
            currentLife = nextLife(currentLife);
            nextGenerations.add(currentLife);
        }
        return currentLife;
    }

    public GameOfLife nextLife(GameOfLife initialLife) {
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

        GameOfLife nextLife = new GameOfLife(newField);
        return nextLife;
    }

    private byte getNeighborsCount(List<Spot> neighbors) {
        byte sum = 0;
        for (Spot spot : neighbors) {
            sum += spot.isLive() ? 1 : 0;
        }
        return sum;
    }

    private List<Spot> getNeighbors(Spot spot, GameOfLife gameOfLife) {
        int x = spot.getX();
        int y = spot.getY();
        List<Spot> list = new ArrayList<>(8);
        list.add(gameOfLife.getField()[x][(y + 1) % dim]);
        list.add(gameOfLife.getField()[x][(y + dim - 1) % dim]);
        list.add(gameOfLife.getField()[(x + 1) % dim][(y + dim - 1) % dim]);
        list.add(gameOfLife.getField()[(x + 1) % dim][y]);
        list.add(gameOfLife.getField()[(x + 1) % dim][(y + 1) % dim]);
        list.add(gameOfLife.getField()[(x + dim - 1) % dim][(y + dim - 1) % dim]);
        list.add(gameOfLife.getField()[(x + dim - 1) % dim][y]);
        list.add(gameOfLife.getField()[(x + dim - 1) % dim][(y + 1) % dim]);
        return list;
    }


}
