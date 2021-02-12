import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * Returns the largest absolute value in the array of numbers.
     *
     * @param numbers the input array of String integer numbers
     * @return the maximum integer absolute value in the array
     */
/*    public static int maxAbsValue(String[] numbers) {
        List<Integer> integers = Arrays.stream(numbers)
                .map(d -> Math.abs(Integer.parseInt(d))).
                        collect(Collectors.toList());
        return Collections.max(integers);
    }*/

    public static int maxAbsValue(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .map(Math::abs)
                .max(Integer::compareTo)
                .get();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(maxAbsValue(scanner.nextLine().split("\\s+")));
    }
}