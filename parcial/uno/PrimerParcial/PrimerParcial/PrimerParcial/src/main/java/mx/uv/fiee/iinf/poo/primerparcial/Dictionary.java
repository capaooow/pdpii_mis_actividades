package mx.uv.fiee.iinf.poo.primerparcial;

import java.util.Collection; // Para que no importe el tipo de estructura de dato a la hora de retornar los elementos
import java.util.TreeSet; // Como veo que no se repiten los valores: TreeSet
import java.io.*;

class Dictionary<T> implements JSONParser<T> {
  private TreeSet<Entry<String, String>> data = new TreeSet<>();

  public Collection<Entry<String, String>> elements() {
    return this.data;
  }

  @Override
  public void parse(T source) {
    String content = "";

    if (source instanceof File) {
      content = readFile((File) source);
    } else if (source instanceof String) {
      content = (String) source;
    }

    cleanAndBreak(content);
  }

  private String readFile(File file) {
    StringBuilder sb = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line = br.readLine();

      while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
      }

    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }

    return sb.toString();
  }

  private void cleanAndBreak(String everything) {
    if (everything == null || everything.trim().isEmpty()) {
      return;
    }
    
    String clean = everything.replace("{", "")
                             .replace("}", "")
                             .replace("\"", "")
                             .trim();

    String[] pairs = clean.split(",");

    for (String pair : pairs) {
      String[] temp = pair.split(":");

      if (temp.length == 2) {
        String key = temp[0].trim();
        String value = temp[1].trim();

        data.add(new Entry<>(key, value));
      }
    }
  }
}
