package softflow;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class App {
    public static void main( String[] args ){

        TerminalUtils.limparTerminal();

        String csvFileName = "desenvolvedores.csv";
        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        while(opc != 4){

            System.out.println("\tMENU\n1. Adicionar Desenvolvedor\n2. Imprimir Desenvolvedores\n3. Compactar Arquivo CSV\n4. Sair\n");

            opc = scanner.nextInt();
            scanner.nextLine();
            TerminalUtils.limparTerminal();

            if(opc == 404){ //-------------------------------- Criar Header CSV --------------------------------

                try(
                    FileWriter fileWriter = new FileWriter(csvFileName);
                    CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)
                ){
                    List<String> header = Arrays.asList("Nome","Email","Idade","Linguagem","Descricao","Disponibilidade");
                    csvPrinter.printRecord(header);

                }catch(IOException e){
                    e.printStackTrace();
                }

            }else if(opc == 1){ //---------------------------- Adicionar Desenvolvedor ----------------------------

                AddDesenvolvedor addD = new AddDesenvolvedor();
                addD.addDesenvolvedor(csvFileName);

            }else if(opc == 2){ //---------------------------- Imprimir Desenvolvedores ----------------------------

                LerCSV lerCSV = new LerCSV();
                lerCSV.lerCSV(csvFileName);

            }else if(opc == 3){ //------------------------------- Compactar arquivo -------------------------------

                

            }

        }

        scanner.close();
    }
}