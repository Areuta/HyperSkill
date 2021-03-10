package search;

public class Main {

    public static void main(String[] args) {
        if (args.length >= 2 && args[0].equals("--data")) {
//            SearchStage searchStage = new SearchStage("", args[1]);
//            BaseSearch searchMethod = new ContentSearch(searchStage);
            SearchStage searchStage = new MappedSearchStage("", args[1]);
            BaseSearch searchMethod = new CoincidenceSearch(searchStage);
                SearchUI searchUI = new SearchUI(searchMethod);
        }
    }

}
