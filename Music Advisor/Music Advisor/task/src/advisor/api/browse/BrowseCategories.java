package advisor.api.browse;

import advisor.api.ListFromRequest;
import advisor.spotifymodels.SpotifyCategory;
import advisor.spotifymodels.SpotifyObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static advisor.api.RequestUtil.*;

public class BrowseCategories implements ListFromRequest {
    @Override
    public List<SpotifyObject> getResults(String request) {
        List<SpotifyObject> list = new ArrayList<>();
        JsonObject jo = makeBrowseRequest(getApiPath() + "/v1/browse/categories"
                , 20, 0, "US", "en_EN");
        JsonObject categoriesObject = jo.getAsJsonObject("categories");

        for (JsonElement categoryItem : categoriesObject.getAsJsonArray("items")) {
            JsonObject category = categoryItem.getAsJsonObject();
            list.add(new SpotifyCategory(category));
        }
        return list;
    }
}
