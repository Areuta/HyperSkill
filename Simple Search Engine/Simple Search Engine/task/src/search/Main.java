package search;

import search.stage.MappedSearchStage;
import search.stage.SearchStage;
import search.strategy.BaseSearch;
import search.strategy.CoincidenceSearch;
import search.ui.SearchUI;

public class Main {

    public static void main(String[] args) {
        if (args.length >= 2 && args[0].equals("--data")) {
//            SearchStage searchStage = new SearchStage("", args[1]);
//            BaseSearch searchMethod = new ContentSearch(searchStage);
            SearchStage searchStage = new MappedSearchStage(null, args[1]);
            BaseSearch searchMethod = new CoincidenceSearch(searchStage);
                SearchUI searchUI = new SearchUI(searchMethod);
        }
    }

}
