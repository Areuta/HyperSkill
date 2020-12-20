import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();

        int n = scanner.nextInt();
        int i = 1;
        int pi = 1;
        while (pi <= n) {

            System.out.println(pi);
            i++;
            pi = (int) Math.pow(i, 2);

        }

    /*    int n = scanner.nextInt();
        int i = 1;
        int qr = 1;

        while (qr <= n) {
            System.out.println(qr);
            qr += 2 * (i++) + 1;
        }*/

        System.out.println(System.currentTimeMillis() - start);
    }
}