import java.util.*;

public class Var2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int d = n - (a + b + c);

        char[] letters = {'A', 'B'};
        int[] digits = {1, 2};

        for (int i = 0; i < a; i++) {
            System.out.print(letters[i % 2]);
        }

        for (int i = 0; i < b; i++) {
            System.out.print(Character.toLowerCase(letters[i % 2]));
        }

        for (int i = 0; i < c; i++) {
            System.out.print(digits[i % 2]);
        }

        for (int i = 1; i < d; i++) {
            System.out.print(letters[i % 2]);
        }
    }
}
