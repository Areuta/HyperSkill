package advisor.api.Search;

import advisor.api.ListFromRequest;
import advisor.spotifymodels.SpotifyAlbum;
import advisor.spotifymodels.SpotifyObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static advisor.api.RequestUtil.getApiPath;
import static advisor.api.RequestUtil.makeSearchRequest;

public class Search implements ListFromRequest {
    @Override
    public List<SpotifyObject> getResults(String query) {
        String[] queries = query.trim().split("[\\s,]");
        return searchAlbums(queries[0]);
//        List<String> list = Arrays.stream(queries)
//                .skip(1)
//                .collect(Collectors.toList());
//
//        JsonObject jo = makeSearchRequest(getApiPath() + "/v1/search"
//                , queries[0]
//                , queries[queries.length - 1]
//                , 5
//                , 0);
//
//
//
//        jo.keySet().forEach(s -> {
//            System.out.println(s + " " + jo.get(s).toString());
//        });
//        return null;
    }

    private List<SpotifyObject> searchAlbums (String query) {
        List<SpotifyObject> list = new ArrayList<>();
        JsonObject jo = makeSearchRequest(getApiPath() + "/v1/search"
                , query
                , "album"
                , 5
                , 0);
        JsonObject albums = jo.get("albums").getAsJsonObject();
//        JsonObject albums = jo.getAsJsonObject("albums");

        for (JsonElement albumItem : albums.getAsJsonArray("items")) {
            JsonObject album = albumItem.getAsJsonObject();
            list.add(new SpotifyAlbum(album));
        }
        return list;
    }
}
