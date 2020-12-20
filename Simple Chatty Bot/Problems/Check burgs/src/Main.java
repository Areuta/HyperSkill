import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine().trim();
        System.out.println(city.length() > 3 && city.lastIndexOf("burg") == city.length() - 4);
    }
}