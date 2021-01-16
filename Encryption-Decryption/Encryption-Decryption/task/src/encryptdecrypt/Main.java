package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int key;

    public static void main(String[] args) {
        String inputString = scanner.nextLine();
        key = scanner.nextInt();
        System.out.println(encryptPhrase(inputString));

        scanner.close();
    }

    private static String encryptPhrase(String inputString) {
        StringBuilder phrase = new StringBuilder();
        String delimiterString = " ";
        String[] words = inputString.split(delimiterString);

        for (int i = 0; i < words.length; i++) {
            delimiterString = (i == words.length - 1 ? "" : " ");
            phrase.append(encryptWord(words[i]));
            phrase.append(delimiterString);
        }
        return phrase.toString();
    }

    private static String encryptWord(String wd) {
        char[] chars = wd.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(encryptChar(aChar));
        }

        return stringBuilder.toString();
    }

    private static char encryptChar(char aChar) {
        if (!Character.isLetter(aChar)) return aChar;
        return (char) (97 + (aChar + key - 97) % 26);
    }
}
