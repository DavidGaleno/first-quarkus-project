package galeno.david.buscadorEndereco.resources;

import galeno.david.buscadorEndereco.Models.Ordem;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/ordens")
public class OrdemResource {

  @Inject
  OrdemService ordemService;

  @Transactional
  @POST
  @RolesAllowed("user")
  @Consumes(MediaType.APPLICATION_JSON)
  public void inserir(@Context SecurityContext securityContext, Ordem ordem)
    throws Exception {
    ordemService.inserir(securityContext, ordem);
  }

  @Path("/{begin}/{end}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Ordem> listar(
    SecurityContext securityContext,
    @PathParam("begin") int begin,
    @PathParam("end") int end
  ) {
    return ordemService.listar(begin, end);
  }
}
