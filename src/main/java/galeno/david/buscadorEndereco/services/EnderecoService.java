package galeno.david.buscadorEndereco.services;

import galeno.david.buscadorEndereco.Models.Endereco;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ws")
@RegisterRestClient(configKey = "endereco-api")
public interface EnderecoService {
  @Path("{cep}/json")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Endereco buscarPorCEP(@PathParam("cep") String cep);
}
