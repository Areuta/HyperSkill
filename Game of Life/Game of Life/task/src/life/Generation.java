package life;//Author Anton   20.12.2020

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static life.GameOfLife.aliveColor;

public class Generation {
    private final Spot[][] field;
    private static int dim = GameOfLife.getDimOfWorld();
    private final long alive;
    static JPanel[][] panels = new JPanel[dim][dim];

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


    public Generation(int seed) {
        Random random = new Random(seed);
        Spot[][] spots = new Spot[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                spots[i][j] = new Spot(i, j, random.nextBoolean());
                if (panels[i][j] == null) {
                    panels[i][j] = new JPanel();
                    GameOfLife.getGridsPanel().add(panels[i][j]);
                }

            }
        }
        this.field = spots;
        this.alive = aliveCreate();
    }

    public Generation(Spot[][] field) {
        this.dim = field.length;
        this.field = field;
        this.alive = aliveCreate();
    }

    public void paintGeneration() {
        GameOfLife.getLabel2().setText(GameOfLife.label2Text + alive);
        GameOfLife.getLabel1().setText(GameOfLife.label1Text + GameOfLife.getCountGen());

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                Color color = field[i][j].isLive() ? aliveColor : Color.white;
                panels[i][j].setBackground(color);
            }
        }
    }

}
