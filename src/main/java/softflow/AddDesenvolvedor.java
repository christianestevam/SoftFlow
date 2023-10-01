package softflow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class AddDesenvolvedor {

  public void addDesenvolvedor(String csvFileName) {

    Scanner scanner = new Scanner(System.in);

    try (
      FileWriter fileWriter = new FileWriter(csvFileName, true);
      CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)
    ){

      System.out.print("Nome: ");
      String nome = scanner.nextLine();
      System.out.print("Email: ");
      String email = scanner.nextLine();
      System.out.print("Idade: ");
      int idade = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Stack: ");
      String stack = scanner.nextLine();
      System.out.print("Descricao: ");
      String descricao = scanner.nextLine();
      System.out.print("Disponibilidade: ");
      String disponibilidade = scanner.nextLine();

      List<String> d1 = Arrays.asList(nome, email, String.valueOf(idade), stack, descricao, disponibilidade);
      csvPrinter.printRecord(d1);

      TerminalUtils.limparTerminal();
      System.out.println("Criado com sucesso!\n");

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}