package life;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int dim = Integer.parseInt(inputs[0]);
        int seed = Integer.parseInt(inputs[1]);

        GameOfLife gameOfLife = new GameOfLife(dim, seed);
        System.out.println(gameOfLife);


    }


}
