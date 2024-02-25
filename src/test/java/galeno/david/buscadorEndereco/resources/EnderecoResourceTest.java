package galeno.david.buscadorEndereco.resources;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class EnderecoResourceTest {

  @Test
  public void testarStatusCodeRequisicaoIgualA200() {
    RestAssured.given().get("enderecos/72140350").then().statusCode(200);
  }
}
