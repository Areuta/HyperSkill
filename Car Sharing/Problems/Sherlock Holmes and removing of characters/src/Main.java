import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine().toLowerCase();
        String str2 = scanner.nextLine().toLowerCase();

        List<Character> list1 = new ArrayList<>(str1.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
        List<Character> list2 = new ArrayList<>(str2.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
        Set<Character> set1 = new HashSet<>(list1);
        Set<Character> set2 = new HashSet<>(list2);

        int sum = 0;
        for (Character c : set1) {
            int c1 = Collections.frequency(list1, c);
            int c2 = Collections.frequency(list2, c);
            if (c1 > c2) {
                sum += c1 - c2;
            }
        }
        for (Character c : set2) {
            int c1 = Collections.frequency(list1, c);
            int c2 = Collections.frequency(list2, c);
            if (c2 > c1) {
                sum += c2 - c1;
            }
        }

        System.out.println(sum);


    }
}