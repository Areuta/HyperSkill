import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger current = BigInteger.valueOf(n);
//        if (n == 0 || n == 1) return current;
        BigInteger result = BigInteger.ONE;
        while (!current.equals(BigInteger.ONE) && !current.equals(BigInteger.ZERO)) {
            result = result.multiply(current);
            current = current.subtract(BigInteger.TWO);
        }
        return result;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(calcDoubleFactorial(scanner.nextInt()));
//    }
}