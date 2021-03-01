import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scr = scanner.nextLine();
        System.out.println(Arrays.stream(scr.split(" "))
                .max(Comparator.comparing(String::length))
                .orElse(""));

    }
}