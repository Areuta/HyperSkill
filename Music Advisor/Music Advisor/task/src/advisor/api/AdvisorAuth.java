package advisor.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdvisorAuth {
    private static String defaultServer = "https://accounts.spotify.com";
    static final String authorizeRequest = defaultServer + "/authorize?";
    static final String tokenRequest = defaultServer + "/api/token";
    static final String client_id = "ad6af6154cd4413bb73f3d6ba729899d";
    static final String client_secret = "16c34433fb7e416a99664a730fc8d2d3";
    static final String redirect_uri = "http://localhost:8080";
    static final String response_type = "code";
    static final int port = 8080;
    static final String requestCode =
            String.format("%sclient_id=%s&redirect_uri=%s&response_type=%s"
                    , authorizeRequest, client_id, redirect_uri, response_type);
    static String accessToken = "";
    private static String code = "";

    public static void setDefaultServer(String defaultServer) {
        AdvisorAuth.defaultServer = defaultServer;
    }

    public static boolean getAuth() {
        code = "";
        if (getCode()) {
            System.out.println("code received\n" +
                    "making http request for access_token...");

            return getToken();
        }
        return false;
    }

    private static boolean getCode() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpContext context = server.createContext("/");
        context.setHandler(AdvisorAuth::handleRequest);
        server.start();
        System.out.println("use this link to request the access code:");
        System.out.println(requestCode);
        System.out.println("waiting for code...");

        while (code.length() == 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        server.stop(1);
        return code.length() != 0;
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        if (requestURI.toString().startsWith("/?code")) {
            code = requestURI.toString().substring(7);
        } else {
            code = "";
        }

        String response = code.equals("")
                ? "<h1>Authorization code not found. Try again.</h1>"
                : "<h1>Got the code. Return back to your program.</h1>";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.write(response.getBytes());
        os.close();

    }


    private static boolean getToken() {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(tokenRequest))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "grant_type=authorization_code"
                                + "&code=" + code
                                + "&redirect_uri=" + redirect_uri
                                + "&client_id=" + client_id
                                + "&client_secret=" + client_secret
                ))
                .build();

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            JsonObject jo = JsonParser.parseString(response.body()).getAsJsonObject();
            if (jo.toString().contains("access_token")) {
                accessToken = jo.get("access_token").getAsString();
            } else {
                return false;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
