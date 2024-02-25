package galeno.david.cep.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import galeno.david.cep.models.Endereco;
import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class JsonService {

  private Gson gson;

  public JsonService() {
    gson = new GsonBuilder().setPrettyPrinting().create();
  }

  public Endereco fromJson(HttpResponse<String> response) {
    Endereco endereco = gson.fromJson(response.body(), Endereco.class);
    System.out.println(endereco);
    return endereco;
  }

  public ArrayList<Endereco> fromJsonArray(HttpResponse<String> response) {
    Type enderecoListType = new TypeToken<ArrayList<Endereco>>() {}.getType();
    ArrayList<Endereco> enderecos = gson.fromJson(
      response.body(),
      enderecoListType
    );
    return enderecos;
  }
}
