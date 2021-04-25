import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s"))
                .collect(Collectors.toList());
        int numberSwaps = scanner.nextInt();

        for (int i = 0; i < numberSwaps; i++) {
            int ind1 = scanner.nextInt();
            int ind2 = scanner.nextInt();
            Collections.swap(list, ind1, ind2);
        }

        list.forEach(s -> System.out.printf("%s ", s));
    }
}