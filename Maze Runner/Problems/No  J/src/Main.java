import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void processIterator(String[] array) {
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        List<String> listNew = new ArrayList<>();
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.startsWith("J")) {
                listNew.add(s.substring(1));
            }
        }

        ListIterator iteratorNew = listNew.listIterator();
        iteratorNew.forEachRemaining(s -> {
        });
        while (iteratorNew.hasPrevious()) {
            System.out.println(iteratorNew.previous());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}

