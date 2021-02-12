import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    static class StreamChanger {
        static LongStream changeStream(LongStream stream) {
            if (stream.isParallel()) {
                return stream.sequential();
            } else {
                return stream.parallel();
            }
        }
    }

    private static List<LongStream> invertedStreams(List<LongStream> streams) {
        return streams.stream()
                .map(StreamChanger::changeStream)
                .collect(Collectors.toList());
    }

    /* Do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Boolean> parallelFlags = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());

        // :)
        List<LongStream> streams = Stream
                .iterate(0, i -> i + 1)
                .limit(parallelFlags.size())
                .map(i -> {
                    LongStream stream = LongStream.of();
                    if (parallelFlags.get(i)) {
                        stream = stream.parallel();
                    }
                    return stream;
                }).collect(Collectors.toList());

        List<String> invertedParallelFlagsAsStrings =
                invertedStreams(streams).stream()
                        .map(LongStream::isParallel)
                        .map(Object::toString)
                        .collect(Collectors.toList());

        System.out.println(String.join(" ", invertedParallelFlagsAsStrings));
    }
}