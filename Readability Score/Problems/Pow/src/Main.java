import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.next());
        double b = Double.parseDouble(scanner.next());
        System.out.println(Math.pow(a, b));
    }
}