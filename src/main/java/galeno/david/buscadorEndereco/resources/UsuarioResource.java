package galeno.david.buscadorEndereco.resources;

import galeno.david.buscadorEndereco.Models.Usuario;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.resource.spi.work.SecurityContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

  @Transactional
  @POST
  @PermitAll
  @Consumes(MediaType.APPLICATION_JSON)
  public void inserir(@Context SecurityContext securityContext, Usuario usuario)
    throws Exception {
    if (Usuario.find("nome", usuario.getNome()).count() > 0) {
      throw new Exception("Usuário já existe");
    } else {
      usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
      usuario.setRole(validarUsername(usuario.getUsername()));
      Usuario.persist(usuario);
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @RolesAllowed("admin")
  public List<Usuario> listar() {
    return Usuario.findAll().list();
  }

  private String validarUsername(String username) {
    if (username.contains("alura")) return "admin";
    return "user";
  }
}
