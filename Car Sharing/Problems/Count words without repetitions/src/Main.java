import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /**
     * Counts the number of unique words ignoring case sensitivity
     * for given lines with words.
     *
     * @param n     the n lines contain words
     * @param lines the list of lines, each line is a list of words
     * @return the number of unique words in lines ignoring case sensitivity
     */
    public static long count(int n, List<List<String>> lines) {
        return lines.stream()
                .limit(n)
                .flatMap(line -> line.stream())
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<List<String>> lines = new ArrayList<>();
        String line;
        while (scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) {
            lines.add(Arrays.asList(line.split("\\s+")));
        }

        System.out.println(count(n, lines));
    }
}