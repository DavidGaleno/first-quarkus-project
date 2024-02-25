import galeno.david.cep.services.CepService;
import galeno.david.cep.services.FileWriterService;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    CepService cepService = new CepService();
    FileWriterService fileWriterService = new FileWriterService();
    while (true) {
      System.out.println("Digite seu CEP");
      String cep = scanner.nextLine();
      try {
        String endereco = cepService.buscarPorCep(cep);
        fileWriterService.write(endereco);
        System.out.println(endereco);
        scanner.close();
      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
