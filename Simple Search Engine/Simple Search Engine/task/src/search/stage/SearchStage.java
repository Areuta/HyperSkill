package search.stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchStage {
    protected String[] toSearch;
    protected ArrayList<String> textStrings;
    protected ArrayList<String> resStrings;

    public SearchStage(String[] toSearch, String fileName) {
        this.toSearch = toSearch;
        this.textStrings = getStringsFromFile(fileName);
    }

    public ArrayList<String> getResStrings() {
        return resStrings;
    }

    public void setResStrings(ArrayList<String> resStrings) {
        this.resStrings = resStrings;
    }

    public ArrayList<String> getTextStrings() {
        return textStrings;
    }

    public String[] getToSearch() {
        return toSearch;
    }

    public void setToSearch(String[] toSearch) {
        this.toSearch = toSearch;
    }

    public ArrayList<String> getStringsFromFile(String fileName) {
        ArrayList<String> books = new ArrayList<>();
        File file = new File(fileName);
        try (Scanner scr = new Scanner(file)) {
            while (scr.hasNextLine()) {
                books.add(scr.nextLine());
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
        }
        return books;
    }

}
