import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        if (val == null) {
            return 0;
        }
        if (val >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (val <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) (long) val;
    }

    /* Do not change code below */
    public static void main(String[] args) {
//        Long val = new Long("4321");
        Long val1 = Long.parseLong("4321");
        Long val2 = new Long(4321);
        Long val3 = 4321L;
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}