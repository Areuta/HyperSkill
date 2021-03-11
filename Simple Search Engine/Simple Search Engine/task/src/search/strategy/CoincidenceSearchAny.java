package search.strategy;

import search.stage.MappedSearchStage;
import search.stage.SearchStage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CoincidenceSearchAny extends CoincidenceSearch {
    public CoincidenceSearchAny(SearchStage stage) {
        super(stage);
    }

    @Override
    public void search(SearchStage stage) {
        MappedSearchStage searchStage = (MappedSearchStage) stage;
        ArrayList<String> res = new ArrayList<>();
        Set<Integer> resSet = new HashSet<>();

        for (String s : stage.getToSearch()) {
            String lowString = s.toLowerCase();
            if (searchStage.getInvertedIndexesMap().containsKey(lowString)) {
                resSet.addAll(searchStage.getInvertedIndexesMap().get(lowString));
            }
        }

        resSet.stream()
                .map(i -> searchStage.getTextStrings().get(i))
                .forEach(res::add);

        searchStage.setResStrings(res);

    }
}
