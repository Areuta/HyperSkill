import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int output = 0;

        switch (input) {
            case "one":
                output = 1;
                break;
            case "two":
                output = 2;
                break;
            case "three":
                output = 3;
                break;
            case "four":
                output = 4;
                break;
            case "five":
                output = 5;
                break;
            case "six":
                output = 6;
                break;
            case "seven":
                output = 7;
                break;
            case "eight":
                output = 8;
                break;
            case "nine":
                output = 9;
                break;
        }
        System.out.println(output);
    }

}