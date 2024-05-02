import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscamoneda (String nombreMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/93f0fd9b2a8fb829c89bda3c/latest/" + nombreMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(direccion).build();

        try {
            HttpResponse <String> response = client.
                    send(request,HttpResponse.BodyHandlers.
                            ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API de conversión de moneda" , e);
        }
    }
}
