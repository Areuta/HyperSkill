package maze;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new MenuMaze();

    }


//    // generate random symmetric matrix
//    public static int[][] symmetricMatrix(int n) {
//        int[][] matrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                matrix[i][j] = (int) (Math.random() * 10);
//                matrix[j][i] = matrix[i][j];
//            }
//        }
//
//        Arrays.stream(matrix)
//                .forEach(ints -> {
//                    Arrays.stream(ints).forEach(i -> System.out.print(i + " "));
//                    System.out.println();
//                });
//
//        return matrix;
//    }
}
