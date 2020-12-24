package life;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static int seed = 102;

    public static void main(String[] args) {
        int dim = Integer.parseInt(scanner.nextLine());
        int countGen = 15;

        GameOfLife gameOfLife = new GameOfLife(dim, seed);
        NextLives nextLives = new NextLives(gameOfLife);
        nextLives.produce(gameOfLife, countGen);

        scanner.close();
    }


}
