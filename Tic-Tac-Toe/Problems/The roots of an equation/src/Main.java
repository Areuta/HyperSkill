import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        for (int i = 0; i <= 1000; i++) {
            if (isCubicRoot(a, b, c, d, i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isCubicRoot(int a, int b, int c, int d, int x) {
        return a * x * x * x + b * x * x + c * x + d == 0;
    }
}