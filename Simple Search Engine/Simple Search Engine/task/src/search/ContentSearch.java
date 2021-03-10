package search;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ContentSearch extends BaseSearch {

    public ContentSearch(SearchStage stage) {
        super(stage);
    }

    @Override
    public void search(SearchStage searchStage) {
        ArrayList<String> res =
                (ArrayList<String>) searchStage.getTextStrings()
                        .stream()
                        .filter(s -> s.toLowerCase().indexOf(searchStage.getToSearch().toLowerCase()) >= 0)
                        .collect(Collectors.toList());
        searchStage.setResStrings(res);
    }

}
