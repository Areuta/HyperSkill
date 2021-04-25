package advisor.spotifymodels;

import com.google.gson.JsonObject;

public class SpotifyPlaylist extends SpotifyObject{
    private final String description;
    private final String externalUrls;

    public String getDescription() {
        return description;
    }

    public String getExternalUrls() {
        return externalUrls;
    }

    public SpotifyPlaylist(JsonObject jo) {
        super(jo);
        this.externalUrls = jo.get("external_urls").getAsJsonObject().get("spotify").getAsString();
        this.description = jo.get("description").getAsString();
    }

    @Override
    public String toString() {
        return this.getDescription() + "\n" +
                this.getExternalUrls() + "\n";
    }
}
