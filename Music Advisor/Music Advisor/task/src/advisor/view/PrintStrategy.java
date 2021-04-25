package advisor.view;

import advisor.spotifymodels.SpotifyObject;

import java.util.List;

public interface PrintStrategy {
    void printResult(List<? extends SpotifyObject> spotifyObjects, String title, String name);
}
