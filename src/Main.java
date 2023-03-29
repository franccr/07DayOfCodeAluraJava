import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static java.time.Duration.ofMillis;

public class Main {

    private static final String URL = "https://imdb-api.com/en/API/Top250Movies/";
    private static final String KEY = "k_mng6pg9g";

    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL + KEY))
                    .header("Accept", "application/json")
                    .GET()
                    .timeout(ofMillis(4000))
                    .build();

            HttpClient client = HttpClient
                    .newBuilder()
                    .connectTimeout(ofMillis(4000))
                    .build();

            HttpResponse<String> response = client.send(request, ofString());

            System.out.println(response.body());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}