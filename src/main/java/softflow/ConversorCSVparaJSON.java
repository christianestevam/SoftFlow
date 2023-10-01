package softflow;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConversorCSVparaJSON {

    public static void main(String[] args) {
        try {
            CsvMapper csvMapper = new CsvMapper();
            File csvFile = new File("desenvolvedor.csv"); 
            MappingIterator<Desenvolvedor> desenvolvedorIterator = csvMapper.readerWithTypedSchemaFor(Desenvolvedor.class).readValues(csvFile);
            List<Desenvolvedor> desenvolvedorList = desenvolvedorIterator.readAll();

            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.writeValue(new File("desenvolvedor.json"), desenvolvedorList);

            System.out.println("Arquivo JSON gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}