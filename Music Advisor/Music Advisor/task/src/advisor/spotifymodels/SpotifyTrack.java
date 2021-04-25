package advisor.spotifymodels;

import com.google.gson.JsonObject;

public class SpotifyTrack extends SpotifyObject{
    private SpotifyAlbum spotifyAlbum;
    private SpotifyArtist[] artists;
    private long durationMs;
    private String externalUrls;
    private int popularity;
    private int trackNumber;

    public SpotifyTrack(JsonObject jo) {
        super(jo);

    }
}
