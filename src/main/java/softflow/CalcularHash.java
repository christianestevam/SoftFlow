package softflow;

import java.io.*;
import java.security.MessageDigest;

public class CalcularHash {

  public void calcularHash(String csvFileName) {

    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      FileInputStream fis = new FileInputStream(csvFileName);
      byte[] buffer = new byte[8192];
      int bytesRead;

      while((bytesRead = fis.read(buffer)) != -1){
        digest.update(buffer, 0, bytesRead);
      }

      byte[] hashBytes = digest.digest();

      StringBuilder hashHex = new StringBuilder();
      for(byte b : hashBytes){
        hashHex.append(String.format("%02x", b));
      }

      System.out.println("Hash SHA-256 de (" + csvFileName + "): " + hashHex.toString());
      System.out.println();

      fis.close();

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}