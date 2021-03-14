import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double p = (a + b + c) / 2.0;

        System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
        scanner.close();
    }
}