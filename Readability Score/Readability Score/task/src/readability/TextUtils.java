package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {
    /**
     * Returns the tokens that match the regex pattern from the document
     * text string.
     *
     * @param pattern A regular expression string specifying the
     *                token pattern desired
     * @return A List of tokens from the document text that match the regex
     * pattern
     */
    public static List<String> getTokens(String pattern, String text) {
        List<String> tokens = new ArrayList<>();
        Pattern tokSplitter = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = tokSplitter.matcher(text);
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    public static boolean isVowel(Character c) {
        String vowels = "aeiouy";
        return vowels.indexOf(Character.toLowerCase(c)) >= 0;
    }

    public static int getSyllablesFromWord(String word) {
        int numSyllables = 0;
        boolean newSyllable = true;
        for (int i = 0; i < word.length(); i++) {
            Character ic = word.charAt(i);
            if (newSyllable && isVowel(ic)) {
                newSyllable = false;
                numSyllables++;
            } else {
                if (isVowel(ic)) {
                    continue;
                }
                newSyllable = true;
            }

            if (i == word.length() - 1 && Character.toLowerCase(ic) == 'e'
                    && numSyllables > 0) {
                numSyllables--;
            }
        }

        return numSyllables == 0 ? 1 : numSyllables;
    }

    public static int getSyllables(String text) {
        return getWords(text).stream()
                .mapToInt(TextUtils::getSyllablesFromWord)
                .sum();
    }

    public static int getPolysyllables(String text) {
        return (int) getWords(text).stream()
                .mapToInt(TextUtils::getSyllablesFromWord)
                .filter(i -> i > 2)
                .count();
    }


    public static String getCharacters(String text) {
        return text.replaceAll("\\s", "");
    }

    public static List<String> getSentences(String text) {
        return getTokens("\\w+\\s*[.?!]+|[\\w\\s]+$", text);
    }

    public static List<String> getWords(String text) {
        return getTokens("\\d+[.,]?\\d*|\\w+", text);
    }


    public static String getTextFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
