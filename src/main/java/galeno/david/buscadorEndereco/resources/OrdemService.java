package galeno.david.buscadorEndereco.resources;

import galeno.david.buscadorEndereco.Models.Ordem;
import galeno.david.buscadorEndereco.Models.Usuario;
import galeno.david.buscadorEndereco.repositories.OrdemRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.SecurityContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

  @Inject
  private OrdemRepository ordemRepository;

  public void inserir(SecurityContext securityContext, Ordem ordem) {
    Optional<Usuario> usuarOptional = Usuario.findByIdOptional(
      ordem.getUsuarioId()
    );
    Usuario usuario = usuarOptional.orElseThrow();
    if (
      !usuario
        .getUsername()
        .equals(securityContext.getUserPrincipal().getName())
    ) {
      throw new RuntimeException("Usuário não compatível");
    }
    ordem.setData(LocalDateTime.now());
    ordem.setStatus("ENVIADA");
    ordemRepository.persist(ordem);
  }

  public List<Ordem> listar(int begin, int size) {
    PanacheQuery<Ordem> ordensPaginadas = ordemRepository.findAll();
    ordensPaginadas.page(Page.of(begin, size));
    return ordensPaginadas.page(Page.of(begin, size)).list();
  }
}
