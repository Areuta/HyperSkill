import java.util.stream.IntStream;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        IntStream stream = IntStream
                .iterate(fromIncl, n -> n + 1)
                .limit(toExcl - fromIncl);

        IntStream stream1 = IntStream
                .range(fromIncl, toExcl);

        return stream
                .reduce(0, (sum, n) -> sum + n * n);
    }

    public static void main(String[] args) {

    }
}