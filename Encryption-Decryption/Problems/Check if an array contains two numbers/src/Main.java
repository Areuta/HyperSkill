import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[] a = {3, 0 , 3, 9, 2, 1};
        int r = 7;

        r = 7;
        for (int i = 0; i < a.length; ++i) {
            int x = a[i];
            x = x * x;
            r += x;
        }

        System.out.println(r);

        r = 13;
        r += a[a[0]];
        r -= a[a[a.length-1]];
        System.out.println(r);

        r = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < a.length)
                r += a[i];
        }
        System.out.println(r);

        System.out.println(Arrays.toString(a));

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean res = false;

        for (int i = 1; i < size - 1; i++) {
            if ((ints[i] == m && ints[i + 1] == n) || (ints[i] == n && ints[i + 1] == m)) {
                res = true;
                break;
            }
        }

        System.out.println(res);
    }
}