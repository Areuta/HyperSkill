import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void inverseFlags(boolean... booleans) {
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = !booleans[i];
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        String boss = "boss";
        char[] array = boss.toCharArray();

        for (char c : array) {
            if (c == 'o')
                c = 'a';
        }
        for (char c : array) {
            System.out.print(c);
        }
        System.out.println(new String(array)); //How come this does NOT print out bass?It pr
        ////////////////////////////////////////////////////////////////////
        final Scanner scanner = new Scanner(System.in);
        final List<Boolean> booleans = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        final boolean[] flags = new boolean[booleans.size()];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = booleans.get(i);
        }
        inverseFlags(flags);
        final String representation = Arrays.toString(flags)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(representation);
    }
}