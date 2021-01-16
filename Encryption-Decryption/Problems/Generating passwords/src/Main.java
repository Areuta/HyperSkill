import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int seed = 10;
    private static final List<Character> upperLettersList;

    static {
        upperLettersList = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            upperLettersList.add((char) i);
        }
    }

    private static final List<Character> lowLettersList;

    static {
        lowLettersList = new ArrayList<>();
        for (int i = 97; i <= 122; i++) {
            lowLettersList.add((char) i);
        }
    }

    private static final List<Character> digitsList;

    static {
        digitsList = new ArrayList<>();
        for (int i = 48; i <= 57; i++) {
            digitsList.add((char) (i));
        }
    }

    private static List<Character> password = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upperLetters = scanner.nextInt();
        int lowLetters = scanner.nextInt();
        int digits = scanner.nextInt();
        int passwordSize = scanner.nextInt();

        passwordAddSymbols(upperLettersList, upperLetters);
        passwordAddSymbols(lowLettersList, lowLetters);
        passwordAddSymbols(digitsList, digits);

        while (password.size() < passwordSize) {
            passwordAddSymbol(upperLettersList);
            if (password.size() == passwordSize) break;
            passwordAddSymbol(lowLettersList);
            if (password.size() == passwordSize) break;
            passwordAddSymbol(digitsList);
        }

        for (Character character : password) {
            System.out.print(character);
        }
    }


    private static void passwordAddSymbols(List<Character> symbols, int countSymbols) {
        for (int i = 0; i < countSymbols; i++) {
            seed++;
            passwordAddSymbol(symbols);
        }
    }

    private static void passwordAddSymbol(List<Character> symbols) {
        Random random = new Random(++seed);
        Character randomChar = symbols.get(random.nextInt(symbols.size()));
        if (password.isEmpty()) {
            password.add(randomChar);
            return;
        }

        if (password.get(password.size() - 1).charValue() != randomChar) {
            password.add(randomChar);
        } else {
            password.add(nextChar(randomChar));
        }

    }

    private static Character nextChar(Character c) {
        char res;
        switch (c) {
            case 'z':
            case 'Z': {
                res = (char) (c - 25);
                break;
            }
            case '9': {
                res = '0';
                break;
            }
            default:
                res = (char) (c + 1);
        }
        return res;
    }

}