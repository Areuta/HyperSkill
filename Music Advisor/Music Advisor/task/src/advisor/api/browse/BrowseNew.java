package advisor.api.browse;

import advisor.api.ListFromRequest;
import advisor.spotifymodels.SpotifyAlbum;
import advisor.spotifymodels.SpotifyObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static advisor.api.RequestUtil.*;

public class BrowseNew implements ListFromRequest {

    @Override
    public List<SpotifyObject> getResults(String request) {
        List<SpotifyObject> list = new ArrayList<>();
        JsonObject jo = makeBrowseRequest(getApiPath() + "/v1/browse/new-releases", 20, 0, "", "");
//        System.out.println(jo.toString());
        JsonObject albums = jo.getAsJsonObject("albums");

        for (JsonElement albumItem : albums.getAsJsonArray("items")) {
            JsonObject album = albumItem.getAsJsonObject();
            list.add(new SpotifyAlbum(album));
        }

        return list;
    }
}
