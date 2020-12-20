import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double startSum = scanner.nextInt();
        int percent = scanner.nextInt();
        double endSum = scanner.nextInt();
        int countYears = 0;

        while (startSum < endSum) {
            startSum = startSum * (percent + 100) / 100;
            countYears++;
        }
        System.out.println(countYears);

    }
}