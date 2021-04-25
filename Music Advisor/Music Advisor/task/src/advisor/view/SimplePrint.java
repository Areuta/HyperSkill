package advisor.view;

import advisor.spotifymodels.SpotifyObject;

import java.util.List;

public class SimplePrint implements PrintStrategy {
    @Override
    public void printResult(List<? extends SpotifyObject> spotifyObjects, String title, String name) {
        spotifyObjects.forEach(System.out::println);
    }
}

