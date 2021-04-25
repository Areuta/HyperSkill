package advisor.ui;

import advisor.api.Search.Search;
import advisor.api.browse.BrowseCategories;
import advisor.api.browse.BrowseCategoryPlaylists;
import advisor.api.browse.BrowseFeatured;
import advisor.api.browse.BrowseNew;
import advisor.view.FakeStrategy;
import advisor.view.PrintStrategy;
import advisor.view.SimplePrint;

public class CommandManager {
//    PrintStrategy printStrategy = new SimplePrint();
    PrintStrategy printStrategy = new FakeStrategy();

    public void newCommand() {
        BrowseNew browseNew = new BrowseNew();
        printStrategy.printResult(browseNew.getResults(""), "new", "");
    }

    public void featuredCommand() {
        BrowseFeatured browseFeatured = new BrowseFeatured();
        printStrategy.printResult(browseFeatured.getResults(""), "featured", "");
    }

    public void categoriesCommand() {
        BrowseCategories browseCategories = new BrowseCategories();
        printStrategy.printResult(browseCategories.getResults(""), "categories", "");
    }

    public void playlistsCommand(String categoryName) {
        BrowseCategoryPlaylists browseCategoryPlaylists = new BrowseCategoryPlaylists();
        printStrategy.printResult(browseCategoryPlaylists.getResults(categoryName), "playlists", categoryName);
    }

    public void searchCommand(String query) {
        Search search = new Search();
        printStrategy.printResult(search.getResults(query), "search", "");
    }
}

