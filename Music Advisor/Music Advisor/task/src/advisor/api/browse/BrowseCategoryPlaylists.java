package advisor.api.browse;

import advisor.api.ListFromRequest;
import advisor.spotifymodels.SpotifyObject;
import advisor.spotifymodels.SpotifyPlaylist;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static advisor.api.RequestUtil.getApiPath;
import static advisor.api.RequestUtil.*;
import static advisor.spotifymodels.SpotifyCategories.getCategoryIdMap;
import static advisor.spotifymodels.SpotifyCategories.getSpotifyCategories;

public class BrowseCategoryPlaylists implements ListFromRequest {

    @Override
    public List<SpotifyObject> getResults(String request) {
        List<SpotifyObject> list = new ArrayList<>();
        getSpotifyCategories();
        String id = getCategoryIdMap().get(request);

        try {
            JsonObject jo = makeBrowseRequest(getApiPath() + "/v1/browse/categories/" + id + "/playlists"
                    , 20, 0, "US", "en_EN");
            JsonObject playlistsObject = jo.getAsJsonObject("playlists");

            for (JsonElement playlistItem : playlistsObject.getAsJsonArray("items")) {
                JsonObject playlist = playlistItem.getAsJsonObject();
                list.add(new SpotifyPlaylist(playlist));
            }
        } catch (Exception e) {
            System.out.println("Specified id doesn't exist");
        }
        return list;
    }
}
