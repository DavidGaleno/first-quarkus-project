package galeno.david.buscadorEndereco.resources;

import galeno.david.buscadorEndereco.Models.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class UsuarioTest {

  @Test
  public void deveRetornarUsuarioCorreto() {
    PanacheMock.mock(Usuario.class);
    Usuario u = new Usuario();
    Optional<PanacheEntityBase> usuario = Optional.of(u);
    Mockito.when(Usuario.findByIdOptional(7)).thenReturn(usuario);
    Assertions.assertSame(u, Usuario.findByIdOptional(7).get());
  }
}
