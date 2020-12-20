import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int countPrinting = 0;

        for (int s = 1; countPrinting < n; s++) {
            for (int i = 1; i <= s && countPrinting < n; i++, countPrinting++) {
                System.out.printf("%d ", s);
            }
        }
    }
}