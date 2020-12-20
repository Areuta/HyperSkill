import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threeDigitsNumber = scanner.nextInt();
        int firstDigit = threeDigitsNumber / 100;
        int secondDigit = (threeDigitsNumber / 10) % 10;
        int thirdDigit = threeDigitsNumber % 10;

        System.out.println(firstDigit + secondDigit + thirdDigit);
    }
}