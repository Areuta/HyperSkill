import java.util.*;

class FixingNullPointerException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = "null".equals(string) ? null : string;
        /* Do not change code above */
        string = string == null ? "NPE!" : string.toLowerCase();
        System.out.println(string);
        String[] strings = { "abc", "hello", "army of robots", null };
        System.out.println(strings[3].concat(" 3333"));
        Exception
    }
}