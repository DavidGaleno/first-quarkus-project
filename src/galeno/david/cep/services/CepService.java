package galeno.david.cep.services;

import galeno.david.cep.models.Endereco;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CepService {

  public String buscarPorCep(String cep) {
    HttpService httpService = new HttpService();
    HttpResponse<String> response;

    response = httpService.buscarPorCep(cep, "json");
    return response.body();
  }

  public ArrayList<Endereco> buscarPorLogradouro(
    String uf,
    String cidade,
    List<String> logradouros
  ) {
    HttpService httpService = new HttpService();
    HttpResponse<String> response;
    ArrayList<Endereco> enderecos = new ArrayList<>();
    try {
      response =
        httpService.buscarPorLogradouro(
          uf,
          cidade.replace(" ", "%20"),
          String.join("+", logradouros),
          "json"
        );
      JsonService jsonService = new JsonService();
      enderecos = jsonService.fromJsonArray(response);
    } catch (IOException | InterruptedException e) {
      System.out.println(e.getMessage());
    }
    return enderecos;
  }
}
