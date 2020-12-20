import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        String[] strings = {"do not move", "move up", "move down","move left", "move right", "error!"};

        if (input < 0 || input > 4) {
            input = 5;
        }

        System.out.println(strings[input]);

    }
}