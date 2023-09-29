package softflow;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class LerCSV {

  public void lerCSV(String csvFileName) {
    boolean primeiraLinha = true;
    int total = 0;

    try(
      FileReader fileReader = new FileReader(csvFileName);
      CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)
    ){

      for(CSVRecord record : csvParser){

        if(primeiraLinha){
          primeiraLinha = false;
          continue;
        }

        String[] partesNome = record.get(0).split(" ");
        String primeiroNome = partesNome[0];

        System.out.println("const " + primeiroNome + " = {");
        System.out.println("    Nome: " + record.get(0) + ";");
        System.out.println("    Email: " + record.get(1) + ";");
        System.out.println("    Idade: " + record.get(2) + ";");
        System.out.println("    Linguagem: " + record.get(3) + ";");
        System.out.println("    Descricao: " + record.get(4) + ";");
        System.out.println("    Disponibilidade: " + record.get(5) + ";");
        System.out.println("}");
        System.out.println();
        total++;
      }

      System.out.println("Total: " + total + "\n");

    }catch(IOException e){
      e.printStackTrace();
    }
  }

}