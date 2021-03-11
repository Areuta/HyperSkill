package search.strategy;

import search.stage.MappedSearchStage;
import search.stage.SearchStage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoincidenceSearchNone extends CoincidenceSearch {
    public CoincidenceSearchNone(SearchStage stage) {
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

        Set<Integer> diff = IntStream
                .range(0, stage.getTextStrings().size())
                .boxed()
                .collect(Collectors.toSet());
        diff.removeAll(resSet);

        diff.stream()
                .map(i -> searchStage.getTextStrings().get(i))
                .forEach(res::add);

        searchStage.setResStrings(res);

    }
}
