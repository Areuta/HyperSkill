import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int digitCount = 4;
        int[] digits = new int[digitCount];

        for (int i = 0; i < digitCount; i++) {
            int digit = number % 10;
            digits[i] = digit;
            number = number / 10;
        }

        int myOutput = 1;
        for (int i = 0; i < digitCount / 2; i++) {
            if (digits[i] != digits[digitCount - 1 - i]) {
                myOutput = 0;
                break;
            }
        }
        System.out.println(myOutput);
    }
}