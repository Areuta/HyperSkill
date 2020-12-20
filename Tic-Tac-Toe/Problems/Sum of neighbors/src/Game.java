import java.util.Scanner;

class Game {

    public static void main(String[] args) {
        String str = readToEnd("end");
        int colonsCount = getMatrixColonsCount(str);
        int rowsCount = getMatrixRowsCount(str);

        int[][] array = arrayCreate(str, rowsCount, colonsCount);
        int[][] arrayC = twoDimArrayCopy(array);

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colonsCount; j++) {
                int iMinus = i > 0 ? i - 1 : rowsCount - 1;
                int iPlus = i < rowsCount - 1 ? i + 1 : 0;
                int jMinus = j > 0 ? j - 1 : colonsCount - 1;
                int jPlus = j < colonsCount - 1 ? j + 1 : 0;
                array[i][j] = arrayC[i][jMinus] + arrayC[i][jPlus] +
                        arrayC[iMinus][j] + arrayC[iPlus][j];
            }
        }

        twoDimArrayPrint(array);
    }

    private static int getMatrixRowsCount(String str) {
        Scanner scanner = new Scanner(str);
        int count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        return count;
    }

    private static int[][] twoDimArrayCopy(int[][] array) {
        int[][] res = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, res[i], 0, array[0].length);
        }
        return res;
    }

    private static void twoDimArrayPrint(int[][] array) {
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (j == array[0].length - 1) {
                    System.out.printf("%d\n", ints[j]);
                } else {
                    System.out.printf("%d ", ints[j]);
                }
            }
        }
        /*for (int[] ints : array) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }*/
    }

    private static int[][] arrayCreate(String str, int rowsCount, int colsCount) {
        int[][] array = new int[rowsCount][colsCount];
        Scanner scanner = new Scanner(str);
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        return array;
    }

    private static int getMatrixColonsCount(String str) {
        Scanner scannerString = new Scanner(str);
        int size = 0;
        while (scannerString.findInLine("\\d+") != null) {
            size++;
        }
        return size;
    }

    private static String readToEnd(String end) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String newLine = scanner.nextLine();
            if (newLine.equals(end)) {
                break;
            } else {
                sb.append(newLine).append("\n");
            }
        }

        return sb.toString().trim();
    }


}