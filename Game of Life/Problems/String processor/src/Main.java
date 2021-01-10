import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        String input;
        String output;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            output = input.toUpperCase();
            if (!output.equals(input)) {
                System.out.println(output);
            } else {
                System.out.println("FINISHED");
                break;
            }

        }

    }

}