package advisor.spotifymodels;

import com.google.gson.JsonObject;

public class SpotifyArtist extends SpotifyObject {
    private String externalUrls;

    public SpotifyArtist(String id, String name, String href) {
        super(id, name, href);
    }

    public SpotifyArtist(JsonObject jo) {
        super(jo);
        this.externalUrls = jo.get("external_urls").getAsJsonObject().get("spotify").getAsString();
    }
}
