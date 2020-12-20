import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int minMax = k - 1;
        int numberMinMax = 0;
        for (int i = 0; i < b - a + 1; i++) {
            int max = 0;
            Random random = new Random(a + i);
            for (int j = 0; j < n; j++) {
                int m = random.nextInt(k);
                if (m > max) {
                    max = m;
                }
            }
            if (max < minMax) {
                minMax = max;
                numberMinMax = i;
            }
        }
        System.out.println(a + numberMinMax);
        System.out.println(minMax);
    }
}