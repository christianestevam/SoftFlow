package softflow;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactarCSV {

  public void compactarCSV(String csvFileName) throws IOException {

    String zipFileName = "desenvolvedores.zip";

    // Criar o arquivo ZIP
    FileOutputStream fos = new FileOutputStream(zipFileName);
    ZipOutputStream zos = new ZipOutputStream(fos);

    // Adicionar o arquivo CSV ao arquivo ZIP
    File file = new File(csvFileName);
    ZipEntry entry = new ZipEntry(file.getName());
    zos.putNextEntry(entry);

    // Ler o arquivo CSV e adicioná-lo ao arquivo ZIP
    byte[] buffer = new byte[1024];
    int bytesRead;
    FileInputStream fis = new FileInputStream(csvFileName);
    while ((bytesRead = fis.read(buffer)) != -1) {
      zos.write(buffer, 0, bytesRead);
    }

    // Fechar o arquivo ZIP
    zos.close();
    fis.close();
  }
}