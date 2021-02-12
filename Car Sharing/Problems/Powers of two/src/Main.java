import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamUtils {

    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        Stream<Integer> stream = Stream.iterate(1, integer -> integer * 2).limit(n);
        return stream; // replace it with your code
    }
}