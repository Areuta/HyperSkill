import java.util.Scanner;

public class Main {
    static long count = 0;

    public static long fib(long n) {
        long res;
        if (n == 0 || n == 1) {
            return n;
        }
        res = Math.abs(fib(n - 1)) + Math.abs(fib(n - 2));
        return n % 2 == 0 ? -res : res;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }
}