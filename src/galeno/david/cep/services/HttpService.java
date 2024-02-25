package galeno.david.cep.services;

import com.google.gson.JsonSyntaxException;
import galeno.david.cep.models.Endereco;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpService {

  private String url = "https://viacep.com.br/ws/";
  private HttpClient client = HttpClient.newHttpClient();
  HttpRequest request;

  public HttpResponse<String> buscarPorCep(String cep, String formato) {
    HttpResponse<String> response = null;
    try {
      this.request =
        HttpRequest
          .newBuilder()
          .uri(URI.create(url + cep + "/" + formato + "/"))
          .build();
      response = this.client.send(request, BodyHandlers.ofString());
      JsonService jsonService = new JsonService();
      jsonService.fromJson(response);
    } catch (IOException | InterruptedException | JsonSyntaxException e) {
      throw new RuntimeException("CEP inválido");
    }

    return response;
  }

  public HttpResponse<String> buscarPorLogradouro(
    String uf,
    String cidade,
    String logradouro,
    String formato
  ) throws IOException, InterruptedException {
    this.request =
      HttpRequest
        .newBuilder()
        .uri(
          URI.create(
            url +
            uf +
            "/" +
            cidade.replace(" ", "%20") +
            "/" +
            logradouro +
            "/" +
            formato
          )
        )
        .build();
    HttpResponse<String> response =
      this.client.send(request, BodyHandlers.ofString());
    return response;
  }
}
