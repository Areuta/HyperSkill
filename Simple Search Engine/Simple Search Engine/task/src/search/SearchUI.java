package search;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchUI {
    static final Scanner scanner = new Scanner(System.in);
    private static final String badInput = "Incorrect option! Try again.";
    private boolean isExit;

    private BaseSearch baseSearch;

    public void setSearchMethod(BaseSearch searchMethod) {
        this.baseSearch = searchMethod;
    }

    public SearchUI(BaseSearch searchMethod) {
        setSearchMethod(searchMethod);

        while (!isExit) {
            menuShow();
            try {
                menuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
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
                searchingBooks();
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
                System.out.println(badInput);
            }
        }
    }

    private void printAllBooks() {
        System.out.println("\n=== List of books ===");
        baseSearch.getStage().getTextStrings().forEach(System.out::println);
    }

    private void searchingBooks() {
        System.out.println("\nEnter data to search books:");
        scanner.nextLine();
        SearchStage stage = baseSearch.getStage();
        stage.setToSearch(scanner.nextLine());
        baseSearch.setStage(stage);
        baseSearch.search(stage);
        baseSearch.printResult();

    }

}
