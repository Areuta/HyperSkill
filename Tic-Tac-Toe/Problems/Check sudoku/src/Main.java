import java.util.*;

public class Main {
    private static Scanner scanner;
    private static int dim;
    private static int[][] matrix;
    private static Set<Integer> setToCheck;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        dim = scanner.nextInt();
        matrix = createMatrix(dim * dim);
        setToCheck = new HashSet<>();
        boolean rightSudoku = checkNumbers() && checkHorizontal() && chekVertical() && checkSmallQuadrant();
        System.out.println(rightSudoku ? "YES" : "NO");
    }

    private static boolean checkNumbers() {
        boolean res = true;
        for (int[] ints : matrix) {
            for (int j : ints) {
                if (j > dim * dim || j < 1) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    private static boolean checkSmallQuadrant() {
        boolean res = true;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                setToCheck.clear();
                for (int i1 = 0; i1 < dim; i1++) {
                    for (int j1 = 0; j1 < dim; j1++) {
                        setToCheck.add(matrix[dim * i + i1][dim * j + j1]);
                    }
                }
                if (setToCheck.size() < matrix.length) {
                    res = false;
                    break;
                }
            }

        }
        return res;
    }

    private static boolean chekVertical() {
        boolean res = true;
        for (int i = 0; i < matrix.length; i++) {
            setToCheck.clear();
            for (int[] ints : matrix) {
                setToCheck.add(ints[i]);
            }
            if (setToCheck.size() < matrix.length) {
                res = false;
                break;
            }
        }
        return res;
    }

    private static boolean checkHorizontal() {
        boolean res = true;
        for (int[] i : matrix) {
            setToCheck.clear();
            for (int j : i) {
                setToCheck.add(j);
            }
            if (setToCheck.size() < matrix.length) {
                res = false;
                break;
            }
        }
        return res;
    }

    private static int[][] createMatrix(int dimSquare) {
        int[][] matrix = new int[dimSquare][dimSquare];

        for (int i = 0; i < dimSquare; i++) {
            for (int j = 0; j < dimSquare; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }


}