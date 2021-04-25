package advisor.spotifymodels;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import static advisor.api.RequestUtil.*;

public class SpotifyCategories {
    private static final Map<String, String> categoryIdMap = new HashMap<>();
    private static SpotifyCategories spotifyCategories = null;

    public static SpotifyCategories getSpotifyCategories() {
        if (spotifyCategories == null) {
            spotifyCategories = new SpotifyCategories();
        }
        return spotifyCategories;
    }

    public static Map<String, String> getCategoryIdMap() {
        return categoryIdMap;
    }

    private SpotifyCategories() {
        JsonObject jo = makeBrowseRequest(getApiPath() + "/v1/browse/categories"
                , 50, 0, "US", "en_EN");
        JsonObject categoriesObject = jo.getAsJsonObject("categories");
        for (JsonElement categoryItem : categoriesObject.getAsJsonArray("items")) {
            JsonObject category = categoryItem.getAsJsonObject();
            categoryIdMap.putIfAbsent(category.get("name").getAsString(), category.get("id").getAsString());
        }
    }
}
