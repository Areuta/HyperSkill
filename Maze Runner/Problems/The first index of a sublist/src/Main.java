import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list1 =  Arrays.stream(scanner.nextLine().split("\\s"))
                .collect(Collectors.toList());
        List<String> list2 = Arrays.stream(scanner.nextLine().split("\\s"))
                .collect(Collectors.toList());

        int min = Collections.indexOfSubList(list1, list2);
        int max = Collections.lastIndexOfSubList(list1, list2);
        System.out.println(min + " " + max);
    }
}