import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String input1 = removeMediumChar(input, input.length() / 2);
        String input2 = input1;
        if (input1.length() % 2 == 1) {
            input2 = removeMediumChar(input1, input1.length() / 2);
        }
        System.out.println(input2);
        /*while (true) {
            if (input.equals("exit")) {
                break;
            }

        }*/
    }

    private static String removeMediumChar(String input, int i) {
        return input.substring(0, i) + input.substring(i + 1);
    }
}