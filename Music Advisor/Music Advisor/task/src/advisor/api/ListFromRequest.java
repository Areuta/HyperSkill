package advisor.api;

import advisor.spotifymodels.SpotifyObject;

import java.util.List;

public interface ListFromRequest {
    List<SpotifyObject> getResults (String request);
}
