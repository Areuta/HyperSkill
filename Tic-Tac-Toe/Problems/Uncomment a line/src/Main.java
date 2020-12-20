import java.util.Scanner;

/**
 * The class implements a simple application with the main method.
 */
class CommentedSimpleApplication {

    public static void main(String[] args) {
        String s = "This is a simple\n" +
                "\n" +
                "multiline input,\n" +
                "\n" +
                "that is being read";

        Scanner scanner = new Scanner(System.in);

        String word1 = scanner.next(); // "This"
        String line1 = scanner.nextLine(); // " is a simple"
        String word2 = scanner.next(); // "multiline"
        String word3 = scanner.next(); // "input,"
        String line2 = scanner.nextLine(); // ""

        System.out.println();
        System.out.println(line1);
        System.out.println(line2);
    }
}