import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dim = scanner.nextInt();
        int[][] matrix = new int[dim][dim];
        int[][] matrixTrans = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
//        printMatrix(dim, matrix);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrixTrans[i][j] = matrix[j][i];
            }
        }
//        printMatrix(dim, matrixTrans);
        boolean isSim = true;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (matrixTrans[i][j] != matrix[i][j]) {
                    isSim = false;
                    break;
                }

            }
        }
        System.out.println(isSim ? "YES" : "NO");
    }

    static void printMatrix(int dim, int[][] matrix) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}