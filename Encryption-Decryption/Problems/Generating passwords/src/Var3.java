import java.util.Scanner;

class Var3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        a = (int) (((float) a / (a + b + c)) * n);
        System.out.println(a);

        b = (int) (((float) b / (a + b + c)) * n);

        String password = "";

        for (int i = 0; i < n; i++) {
            if (i < a) {
                // Using % for big numbers
                password += (char) (65 + i % 26);
            } else if (i < (a + b)) {
                password += (char) (97 + i % 26);
            } else {
                password += (char) (48 + i % 10);
            }
        }

        System.out.println(password);

        System.out.println((float) n / 0);
        System.out.println((float) 0 / 0);
    }
}
