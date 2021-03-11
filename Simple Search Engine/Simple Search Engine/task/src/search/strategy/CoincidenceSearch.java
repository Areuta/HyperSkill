package search.strategy;

import search.stage.MappedSearchStage;
import search.stage.SearchStage;

import java.util.ArrayList;
import java.util.Set;

public class CoincidenceSearch extends BaseSearch {

    public CoincidenceSearch(SearchStage stage) {
        super(stage);
    }

    @Override
    public void search(SearchStage stage) {
        MappedSearchStage searchStage = (MappedSearchStage) stage;
        ArrayList<String> res = new ArrayList<>();
        String lowString = stage.getToSearch()[0].toLowerCase();
        Set<Integer> set;
        if (searchStage.getInvertedIndexesMap().containsKey(lowString)) {
            set = searchStage.getInvertedIndexesMap().get(lowString);
            set.stream()
                    .map(i -> searchStage.getTextStrings().get(i))
                    .forEach(res::add);
        }
        searchStage.setResStrings(res);
    }
}
