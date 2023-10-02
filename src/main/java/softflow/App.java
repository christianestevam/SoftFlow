package softflow;

import java.io.*;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class App {
    public static void main(String[] args) {

        TerminalUtils.limparTerminal();

        String csvFileName = "desenvolvedores.csv";
        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        while(opc != 7){
            exibirMenu();

            opc = scanner.nextInt();
            scanner.nextLine();
            TerminalUtils.limparTerminal();

            if(opc == 404){ // Criar Header CSV

                try(
                    FileWriter fileWriter = new FileWriter(csvFileName);
                    CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)
                ){
                    List<String> header = Arrays.asList("nome","email","idade","stack","descricao","disponibilidade");
                    csvPrinter.printRecord(header);

                } catch(IOException e) {
                    e.printStackTrace();
                }

            }else if(opc == 1){ // Adicionar Desenvolvedor 

                try {
                    AddDesenvolvedor addDesenvolvedor = new AddDesenvolvedor();
                    addDesenvolvedor.addDesenvolvedor(csvFileName);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }else if(opc == 2){ // Imprimir Desenvolvedores 

                try {
                    ImprimirCSV imprimirCSV = new ImprimirCSV();
                    imprimirCSV.imprimirCSV(csvFileName);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }else if(opc == 3){ // Compactar arquivo CSV
  
                try {
                    CompactarCSV compactarCSV = new CompactarCSV();
                    compactarCSV.compactarCSV(csvFileName);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }else if(opc == 4){ // Gerar JSON

                try {
                    ConversorCSVparaJSON conv_json = new ConversorCSVparaJSON();
                    conv_json.converterCSVparaJSON(csvFileName);
                } catch(Exception e) {
                    e.printStackTrace();
                }


            }else if(opc == 5){ // Gerar XML

                try {
                    ConversorCSVparaXML conversorCSVparaXML = new ConversorCSVparaXML();
                    conversorCSVparaXML.converterCSVparaXML(csvFileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if(opc == 6){ // Calcular hash (SHA256)

                try {
                    CalcularHash calcularHash = new CalcularHash();
                    calcularHash.calcularHash(csvFileName);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }

        }
        TerminalUtils.limparTerminal();
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("+------------------------------+");
        System.out.println("|             MENU             |");
        System.out.println("+------------------------------+");
        System.out.println("| 1. Adicionar Desenvolvedor   |");
        System.out.println("| 2. Imprimir Desenvolvedores  |");
        System.out.println("| 3. Compactar Arquivo CSV     |");
        System.out.println("| 4. Gerar JSON                |");
        System.out.println("| 5. Gerar XML                 |");
        System.out.println("| 6. Calcular hash (SHA256)    |");
        System.out.println("| 7. Sair                      |");
        System.out.println("+------------------------------+");
        System.out.print("-> ");
    }
}