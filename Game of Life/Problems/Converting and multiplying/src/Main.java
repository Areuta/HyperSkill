import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        List<String> list = new ArrayList<>();

        while (true) {
            str = scanner.nextLine();
            try {
                int i = Integer.parseInt(str);
                if (i == 0) {
                    break;
                }
                i *= 10;
                list.add(String.valueOf(i));

            } catch (NumberFormatException e) {
                list.add("Invalid user input: " + str);
            }

        }

        for (String string : list) {
            System.out.println(string);
        }
    }
}