import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectorApi {

    public String buscarTaxasDeCambio (String moedaBase) {

        String apiKey = "eeac7258bbc56c5f18c92da4";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Falha na requisição: Código " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível conectar à API. Verifique sua conexão.", e);
        }
    }
}
