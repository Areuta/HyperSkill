package advisor.view;

import advisor.spotifymodels.SpotifyObject;

import java.util.List;

public class FakeStrategy implements PrintStrategy {

    @Override
    public void printResult(List<? extends SpotifyObject> spotifyObjects, String title, String name) {
        switch (title) {
            case "new": {
                System.out.println("---NEW RELEASES---");
                System.out.println("Mountains [Sia, Diplo, Labrinth]\n" +
                        "Runaway [Lil Peep]\n" +
                        "The Greatest Show [Panic! At The Disco]\n" +
                        "All Out Life [Slipknot]");
                break;
            }
            case "featured": {
                System.out.println("---FEATURED---");
                System.out.println("Mellow Morning\n" +
                        "Wake Up and Smell the Coffee\n" +
                        "Monday Motivation\n" +
                        "Songs to Sing in the Shower");
                break;
            }
            case "categories": {
                System.out.println("---CATEGORIES---");
                System.out.println("Top Lists\n" +
                        "Pop\n" +
                        "Mood\n" +
                        "Latin");
                break;
            }
            case "playlists": {
                System.out.println("---" + name + " PLAYLISTS---");
                System.out.println("Walk Like A Badass  \n" +
                        "Rage Beats  \n" +
                        "Arab Mood Booster  \n" +
                        "Sunday Stroll");
                break;
            }
        }
    }
}
