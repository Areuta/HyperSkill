package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MappedSearchStage extends SearchStage {
    Map<String, Set<Integer>> invertedIndexesMap;

    public Map<String, Set<Integer>> getInvertedIndexesMap() {
        return invertedIndexesMap;
    }

    public MappedSearchStage(String toSearch, String fileName) {
        super(toSearch, fileName);
        invertedIndexesMap = new HashMap<>();

        for (int i = 0; i < textStrings.size(); i++) {

            Set<Integer> set;
            String[] strings = textStrings.get(i).split(" ");

            for (String string : strings) {
                String lowString = string.toLowerCase();
                if (invertedIndexesMap.containsKey(lowString)) {
                    set = invertedIndexesMap.get(lowString);
                    set.add(i);
                } else {
                    set = new HashSet<>();
                    set.add(i);
                    invertedIndexesMap.put(lowString, set);
                }
            }
        }

    }
}
