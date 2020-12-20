import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        int count = 0;
        while (count < 4 && scanner.hasNext()) {
            strings.add(scanner.next());
            count++;
        }

        for (String str : strings) {
            System.out.println(str);
        }
    }
}