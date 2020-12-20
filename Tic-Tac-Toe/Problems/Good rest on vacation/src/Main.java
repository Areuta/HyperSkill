import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countDays = scanner.nextInt();
        int foodCostPerDay = scanner.nextInt();
        int costOne_wayFlight = scanner.nextInt();
        int costOneNight = scanner.nextInt();

        int price = countDays * foodCostPerDay +
                (countDays - 1) * costOneNight +
                costOne_wayFlight * 2;
        System.out.println(price);
    }
}