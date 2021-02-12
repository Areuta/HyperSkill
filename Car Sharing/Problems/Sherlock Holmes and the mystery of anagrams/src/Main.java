import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine().toLowerCase();
        String str2 = scanner.nextLine().toLowerCase();
        System.out.println(Objects.equals(charMapCreate(str1), charMapCreate(str2)) ? "yes" : "no");

    }

    private static Map<Character, Integer> charMapCreate(String str1) {
        char[] chars = str1.toCharArray();
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (occurrences.containsKey(chars[i])) {
                int count = occurrences.get(chars[i]);
                occurrences.put(chars[i], ++count);
            } else {
                occurrences.put(chars[i], 1);
            }
        }
        return occurrences;

    }


}