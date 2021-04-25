package advisor.spotifymodels;

import com.google.gson.JsonObject;

public class SpotifyCategory extends SpotifyObject{
    public SpotifyCategory(JsonObject jo) {
        super(jo);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
