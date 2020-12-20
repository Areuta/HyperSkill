import java.util.Scanner;

import static java.lang.Math.abs;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.println(x1 == x2 || y1 == y2 || abs(x2 - x1) == abs(y2 - y1) ? "YES" : "NO");

      /*  if (x1 == x2 || y1 == y2 || abs(x2 - x1) == abs(y2 - y1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }*/
    }
}