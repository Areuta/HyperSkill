package advisor.api.browse;

import advisor.api.ListFromRequest;
import advisor.spotifymodels.SpotifyObject;
import advisor.spotifymodels.SpotifyPlaylist;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static advisor.api.RequestUtil.*;

public class BrowseFeatured implements ListFromRequest {
    @Override
    public List<SpotifyObject> getResults(String request) {
        JsonObject jo = makeBrowseRequest(getApiPath() + "/v1/browse/featured-playlists", 20, 0, "", "");
        JsonObject playlistsObject = jo.getAsJsonObject("playlists");
        List<SpotifyObject> list = new ArrayList<>();

        for (JsonElement playlistItem : playlistsObject.getAsJsonArray("items")) {
            JsonObject playlist = playlistItem.getAsJsonObject();
            list.add(new SpotifyPlaylist(playlist));
        }
        return list;
    }
}
