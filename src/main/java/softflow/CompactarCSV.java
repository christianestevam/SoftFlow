package softflow;

import java.io.*;
import java.util.zip.*;

public class CompactarCSV {

  public void compactarCSV(){

  }

  public static void zipDirectory(String sourceFolder, String zipFileName) throws IOException {
      File sourceFolderFile = new File(sourceFolder);
      File zipFile = new File(zipFileName);

      try (FileOutputStream fos = new FileOutputStream(zipFile);
           ZipOutputStream zos = new ZipOutputStream(fos)) {

          zipFolder(sourceFolderFile, sourceFolderFile.getName(), zos);
    }
  }

  private static void zipFolder(File folder, String parentFolder, ZipOutputStream zos) throws IOException {
      for (File file : folder.listFiles()) {
          if (file.isDirectory()) {
              zipFolder(file, parentFolder + "/" + file.getName(), zos);
              continue;
          }

          try (FileInputStream fis = new FileInputStream(file)) {
              String entryName = parentFolder + "/" + file.getName();
              ZipEntry zipEntry = new ZipEntry(entryName);
              zos.putNextEntry(zipEntry);

              byte[] buffer = new byte[1024];
              int len;
              while ((len = fis.read(buffer)) > 0) {
                  zos.write(buffer, 0, len);
              }
              zos.closeEntry();
          }
      }
  }
}