package advisor.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static advisor.api.AdvisorAuth.accessToken;

public class RequestUtil {
    private static String apiPath;

    public static String getApiPath() {
        return apiPath;
    }

    public static void setApiPath(String apiPath) {
        RequestUtil.apiPath = apiPath;
    }

    public static JsonObject makeRequest(String path) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .uri(URI.create(path))
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return JsonParser.parseString(response.body()).getAsJsonObject();
        } catch (IOException | InterruptedException e) {
            System.out.println();
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public static JsonObject makeBrowseRequest(String path, int limit, int offset, String country, String locale) {
        String fullPath = createBrowsePath(path, limit, offset, country, locale);
        return makeRequest(fullPath);
    }

    public static JsonObject makeSearchRequest(String path, String q, String types, int limit, int offset) {
        String fullPath = createSearchPath(path, q, types, limit, offset);
        return makeRequest(fullPath);
    }

    private static String createSearchPath(String path, String q, String types, int limit, int offset) {
        String result = path + "?q=" + q + "&type=" + types;
        if (limit > 0) {
            result += "&limit=" + limit;
        }
        if (offset >= 0) {
            result += "&offset=" + offset;
        }
        return result;
    }

    private static String createBrowsePath(String path, int limit, int offset, String country, String locale) {
        String result = path + "?";
        boolean firstArgument = true;
        if (limit > 0) {
            result += "limit=" + limit;
            firstArgument = false;
        }
        if (offset >= 0) {
            if (!firstArgument) {
                result += "&";
            }
            result += "offset=" + offset;
            firstArgument = false;
        }
        if (!country.equals("")) {
            if (!firstArgument) {
                result += "&";
            }
            result += "country=" + country;
            firstArgument = false;
        }
        if (!locale.equals("")) {
            if (!firstArgument) {
                result += "&";
            }
            result += "locale=" + locale;
        }
        return result;
    }

    public static JsonObject getSearch(String query) {
        JsonObject jo = makeRequest(apiPath + "/v1/search?q=" + query + "&type=artist,playlist&limit=5");
        jo.keySet().forEach(s -> {
            System.out.println(s + " " + jo.get(s).toString());
        });
//        JsonArray jsonArray = getRequestedArray(apiPath + "/v1/search?q=" + query + "&type=artist,playlist&limit=5");
//        if (jsonArray instanceof JsonArray) ((JsonArray) jsonArray)
//                .forEach(jsonElement -> System.out.println(jsonElement.getAsString()));
//        JsonObject categoriesObject = jo.getAsJsonObject("playlists");
//        for (JsonElement playlistItem : categoriesObject.getAsJsonArray("items")) {
//            JsonObject playlist = playlistItem.getAsJsonObject();
//            System.out.println(playlist.get("name").getAsString());
//            System.out.println(playlist.get("external_urls").getAsJsonObject().get("spotify").getAsString());
//            System.out.println();
//        }
        return null;

    }

//    public static JsonObject makeRequest(String path, int limit, int offset, String country, String locale) {
//        HttpClient client = HttpClient.newHttpClient();
//        String correctPath = createBrowsePath(path, limit, offset, country, locale);
//
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .header("Authorization", "Bearer " + accessToken)
//                .uri(URI.create(correctPath))
//                .GET()
//                .build();
//        HttpResponse<String> response;
//        try {
//            response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//            return JsonParser.parseString(response.body()).getAsJsonObject();
//        } catch (IOException | InterruptedException e) {
//            System.out.println();
//            Thread.currentThread().interrupt();
//            return null;
//        }
//    }
}