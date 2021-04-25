package advisor.spotifymodels;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class SpotifyAlbum extends SpotifyObject {
    private final String externalUrls;
    private final List<SpotifyArtist> artists = new ArrayList<>();


    public SpotifyAlbum(JsonObject jo) {
        super(jo);
        this.externalUrls = jo.get("external_urls").getAsJsonObject().get("spotify").getAsString();

        JsonArray artistsItems = jo.getAsJsonArray("artists");
        for (JsonElement artistItem : artistsItems) {
            this.artists.add(new SpotifyArtist(artistItem.getAsJsonObject()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("\n[");
        for (int i = 0; i < artists.size(); i++) {
            sb.append(artists.get(i).getName());
            sb.append(i == artists.size() - 1 ? "]\n" : ", ");
        }
        sb.append(externalUrls).append("\n");

        return sb.toString();
    }
}
