package search.ui;

import search.stage.SearchStage;
import search.strategy.BaseSearch;
import search.strategy.CoincidenceSearchAll;
import search.strategy.CoincidenceSearchAny;
import search.strategy.CoincidenceSearchNone;

import java.util.InputMismatchException;

import static search.ui.SearchUI.badInput;
import static search.ui.SearchUI.scanner;

public class ExtSearchMenu {
    private BaseSearch baseSearch;

    public enum SearchOptions {ALL, ANY, NONE}

    public ExtSearchMenu(BaseSearch bSearch) {
        this.baseSearch = bSearch;
        SearchStage stage = baseSearch.getStage();

        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        scanner.nextLine();

        try {
            menuProcess();
            System.out.println("\nEnter data to search books:");
            stage.setToSearch(scanner.nextLine().split(" "));

            baseSearch.setStage(stage);
            baseSearch.search(stage);
            baseSearch.printResult();

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(badInput);
        }

    }


    private void menuProcess() throws IllegalArgumentException {
        SearchOptions option = SearchOptions.valueOf(scanner.nextLine());
        switch (option) {
            case ALL: {
                baseSearch = new CoincidenceSearchAll(baseSearch.getStage());
                break;
            }
            case ANY: {
                baseSearch = new CoincidenceSearchAny(baseSearch.getStage());
                break;
            }
            case NONE: {
                baseSearch = new CoincidenceSearchNone(baseSearch.getStage());
                break;
            }
            default: {
                System.out.println(badInput);
            }
        }
    }
}
