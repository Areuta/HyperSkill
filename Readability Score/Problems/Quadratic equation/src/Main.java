import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());

        double x1 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double x2 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        System.out.println(Math.min(x1, x2) + " " + Math.max(x1, x2));

    }
}