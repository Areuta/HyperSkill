package search.strategy;

import search.stage.SearchStage;

public class BaseSearch implements SearchMethod {
    private SearchStage stage;

    public BaseSearch(SearchStage stage) {
        this.stage = stage;
    }


    @Override
    public void search(SearchStage searchStage) {
    }

    public SearchStage getStage() {
        return stage;
    }

    public void setStage(SearchStage stage) {
        this.stage = stage;
    }

    public void printResult() {
        if (stage.getResStrings().isEmpty()) {
            System.out.println("\nNo matching books found.");
        } else {
            System.out.println("\n" + stage.getResStrings().size() + " books found:");
            stage.getResStrings().forEach(System.out::println);
        }
    }
}
