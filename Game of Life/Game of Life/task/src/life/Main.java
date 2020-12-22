package life;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static int seed;

    public static void main(String[] args) {
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int dim = Integer.parseInt(inputs[0]);
        seed = Integer.parseInt(inputs[1]);
        int countGen = Integer.parseInt(inputs[2]);

        GameOfLife gameOfLife = new GameOfLife(dim, seed);
//        System.out.println(gameOfLife);
        NextLives nextLives = new NextLives(gameOfLife, countGen);
        GameOfLife game = nextLives.produce(gameOfLife, countGen);
        System.out.println(game);


    }


}
