package search.strategy;

import search.stage.MappedSearchStage;
import search.stage.SearchStage;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoincidenceSearchAll extends CoincidenceSearch {

    public CoincidenceSearchAll(SearchStage stage) {
        super(stage);
    }

    @Override
    public void search(SearchStage stage) {
        MappedSearchStage searchStage = (MappedSearchStage) stage;
        ArrayList<String> res = new ArrayList<>();

        Set<Integer> resSet = IntStream
                .range(0, stage.getTextStrings().size())
                .boxed()
                .collect(Collectors.toSet());

        for (String s : stage.getToSearch()) {
            String lowString = s.toLowerCase();
            if (searchStage.getInvertedIndexesMap().containsKey(lowString)) {
                resSet.retainAll(searchStage.getInvertedIndexesMap().get(lowString));
            } else {
                resSet.clear();
                break;
            }
        }

        resSet.stream()
                .map(i -> searchStage.getTextStrings().get(i))
                .forEach(res::add);

        searchStage.setResStrings(res);
    }

}

