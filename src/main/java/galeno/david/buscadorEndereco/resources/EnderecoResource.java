package galeno.david.buscadorEndereco.resources;

import galeno.david.buscadorEndereco.Models.Endereco;
import galeno.david.buscadorEndereco.services.EnderecoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/enderecos")
public class EnderecoResource {

  @Inject
  @RestClient
  EnderecoService enderecoService;

  @Path("/{cep}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Endereco buscarPorCEP(@PathParam("cep") String cep) {
    return enderecoService.buscarPorCEP(cep);
  }
}
