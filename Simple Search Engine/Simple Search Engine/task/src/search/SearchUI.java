package search;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SearchUI {
    static final Scanner scanner = new Scanner(System.in);
    private static final String badinput = "Incorrect option! Try again.";
    private List<String> books;
    private static String word;
    private static SearchEngine searchEngine;
    private boolean isExit;

    public SearchUI() {
        try {
            initSearchingStage();
        } catch (InputMismatchException e) {
            System.out.println(badinput);
        }

        searchEngine = new SearchEngine("", books);

        while (!isExit) {
            menuShow();
            try {
                menuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badinput);
                scanner.nextLine();
            }
        }
        System.out.println("\nBye!");
        scanner.close();
    }

    private void menuShow() {
        System.out.println("\n=== Menu ===\n" +
                "1. Find a book\n" +
                "2. Print all books\n" +
                "0. Exit");
    }

    private void menuProcess() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                searchingBook();
                break;
            }
            case 2: {
                printAllBooks();
                break;
            }
            case 0: {
                isExit = true;
                break;
            }
            default: {
                System.out.println(badinput);
            }
        }
    }

    private  void printAllBooks() {
        System.out.println("\n=== List of people ===");
        books.forEach(System.out::println);
    }

    private void searchingBook() {
        System.out.println("\nEnter data to search books:");
        word = scanner.nextLine();
        searchEngine.setWord(word);
        searchEngine.findDataInText(word, books);
        searchEngine.printResult();
    }

    private void initSearchingStage() {
        System.out.println("Enter the number of books:");
        int number = Integer.parseInt(scanner.nextLine());

        books = new ArrayList<>();
        System.out.println("\nEnter all books:");
        IntStream.range(0, number).forEach(i -> books.add(scanner.nextLine()));
    }


}
