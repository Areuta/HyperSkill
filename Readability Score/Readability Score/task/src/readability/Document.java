package readability;

import java.util.List;

import static readability.TextUtils.*;

public class Document {
    private final String text;
    private final List<String> words;
    private final List<String> sentences;
    private final int countCharacters;
    private final int countWords;
    private final int countSentences;
    private final int countSyllables;
    private final int countPolysyllables;

    public String getText() {
        return text;
    }

    public Document(String fileName) {
        this.text = getTextFromFile(fileName);
        this.words = getWords(text);
        this.countWords = getWords((text)).size();
        this.sentences = getSentences(text);
        this.countSentences = getSentences(text).size();
        this.countCharacters = getCharacters(text).length();
        this.countSyllables = getSyllables(text);
        this.countPolysyllables = getPolysyllables(text);
    }

    public int getCountCharacters() {
        return countCharacters;
    }

    public int getCountWords() {
        return countWords;
    }

    public int getCountSentences() {
        return countSentences;
    }

    public int getCountSyllables() {
        return countSyllables;
    }

    public int getCountPolysyllables() {
        return countPolysyllables;
    }

    @Override
    public String toString() {
        return "The text is:\n" + text +
                "\nWords: " + this.countWords +
                "\nSentences: " + this.countSentences +
                "\nCharacters: " + this.countCharacters +
                "\nSyllables: " + this.countSyllables +
                "\nPolysyllables: " + this.countPolysyllables;
    }

}
