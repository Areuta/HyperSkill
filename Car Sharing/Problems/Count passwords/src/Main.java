import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    /**
     * Returns the number of elements in a given stream.
     *
     * @param passwordStream the input stream of strings 
     * @return the number of elements in a given stream
     */
    public static long countPasswords(Stream<String> passwordStream) {
        return passwordStream.count();
    }

    // Don't change the code below
    public static void main(String[] args) {
        boolean result = IntStream
                .iterate(0, n -> n + 1)
                .limit(100)
                .filter(n -> n % 2 != 0)
                .noneMatch(n -> n % 2 == 0);

        System.out.println(result);
        Scanner scanner = new Scanner(System.in);
        System.out.println(countPasswords(Arrays.stream(scanner.nextLine().split("\\s+"))));
    }
}