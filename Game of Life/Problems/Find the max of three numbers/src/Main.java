import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        int[] ints = {a, b, c};
        int max = a;
        int maxIndex = 0;
        for (int i = 0; i < 3; i++) {
            if (ints[i] > max) {
                max = ints[i];
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}