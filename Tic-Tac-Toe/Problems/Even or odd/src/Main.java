import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            int n = scanner.nextInt();
            if (n == 0) break;
            System.out.println(n % 2 == 0 ? "even" : "odd");
        } while (scanner.hasNext());
    }
}