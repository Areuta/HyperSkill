import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
//        boolean startJ = inputString.toUpperCase().startsWith("J");
        boolean startJ = inputString.charAt(0) == 'j' || inputString.charAt(0) == 'J';
        System.out.println(startJ);
    }
}