import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Math.pow;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.GERMANY);
//        double d = Double.parseDouble(scanner.next());
//        d = scanner.nextDouble();
//        System.out.println(d * d * d + d * d + d + 1);
//        Locale.setDefault(Locale.US);
//        Locale current = Locale.getDefault();
//        System.out.println(current.getDisplayName());
        double number = scanner.nextDouble();
        double total = IntStream.iterate(3, i -> i > 0, i -> i - 1)
                .mapToDouble(i -> pow(number, i))
                .sum();
        System.out.println(total + 1);

    }
}