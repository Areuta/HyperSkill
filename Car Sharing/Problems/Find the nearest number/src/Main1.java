import java.util.*;
import java.util.stream.Collectors;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] string = scanner.nextLine().split(" ");
        ArrayList<Integer> list = Arrays.stream(string)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int number = scanner.nextInt();

        ArrayList<Integer> distanceList = list.stream()
                .map(num -> Math.abs(number - num))
                .collect(Collectors.toCollection(ArrayList::new));

//        System.out.printf("distanceList = %s%n", distanceList);

        int minimum = Collections.min(distanceList);

        list.stream()
                .filter(num -> Math.abs(number - num) == minimum)
                .sorted()
                .forEach(num -> System.out.print(num + " "));
    }
}
