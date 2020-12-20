package tictactoe;//Author Anton   10.12.2020

public class Spot {
    private int x;
    private int y;
    private char c;


    public Spot(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public String toString() {
        String res = String.valueOf(this.c);
        if (res.equals("_")) {
            res = " ";
        }
        return res;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }


}
