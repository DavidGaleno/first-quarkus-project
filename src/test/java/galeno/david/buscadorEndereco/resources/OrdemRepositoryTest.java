package galeno.david.buscadorEndereco.resources;

import galeno.david.buscadorEndereco.Models.Ordem;
import galeno.david.buscadorEndereco.repositories.OrdemRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class OrdemRepositoryTest {

  @InjectMock
  OrdemRepository ordemRepository;

  @InjectMock
  OrdemService ordemService;

  @Test
  public void listAllDeveRetornarOrdensCorretas() {
    Ordem primeiraOrdem = new Ordem();
    Ordem segundaOrdem = new Ordem();
    List<Ordem> ordens = new ArrayList<>();

    ordens.add(primeiraOrdem);
    ordens.add(segundaOrdem);
    Mockito.when(ordemService.listar(0,2)).thenReturn(ordens);
    Assertions.assertEquals(ordemService.listar(0,2), ordens);
  }
}
