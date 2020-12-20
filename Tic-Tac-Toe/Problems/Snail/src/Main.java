import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int heightPole = scanner.nextInt();
        int upPerDay = scanner.nextInt();
        int downPerNight = scanner.nextInt();
        int snailMove = 0;
        int countDay = 0;

        while (true) {
            snailMove += upPerDay;
            countDay++;
            if (snailMove >= heightPole) {
                break;
            }
            snailMove -= downPerNight;
        }

        System.out.println(countDay);

    }
}