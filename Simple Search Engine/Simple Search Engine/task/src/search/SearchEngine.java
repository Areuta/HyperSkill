package search;

import java.util.*;
import java.util.stream.IntStream;

public class SearchEngine {
    private String word;
    private List<String> books;
    private static List<Integer> happyLines = new ArrayList<>();


    public SearchEngine(String word, List<String> textList) {
        this.word = word;
        this.books = textList;
    }


    public void setWord(String word) {
        this.word = word;
    }


    void findDataInText(String word, List<String> books) {
        happyLines.clear();
        IntStream.range(0, books.size())
                .filter(i -> findDataInLine(word, books.get(i)) >= 0)
                .forEach(i -> happyLines.add(i));
    }

    private int findDataInLine(String word, String line) {
        return line.toLowerCase().indexOf(word.toLowerCase());
    }

    public void printResult() {
        if (happyLines.isEmpty()) {
            System.out.println("\nNo matching books found.");
        } else {
            System.out.println("\nFound books:");
            IntStream.range(0, happyLines.size())
                    .forEach(i -> System.out.println(books.get(happyLines.get(i))));
        }
    }


}
