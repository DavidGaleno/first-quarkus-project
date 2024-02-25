package galeno.david.cep.services;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {

  FileWriter fileWriter;

  public FileWriterService() {
    try {
      fileWriter = new FileWriter("texto.json");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void write(String texto) {
    try {
      fileWriter.write(texto);
      fileWriter.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
