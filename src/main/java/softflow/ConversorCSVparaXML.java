package softflow;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConversorCSVparaXML {

    public static void main(String[] args) {
        try {

            CsvMapper csvMapper = new CsvMapper();

            File csvFile = new File("desenvolvedor.csv"); 

            MappingIterator<Desenvolvedor> desenvolvedorIterator = csvMapper.readerWithTypedSchemaFor(Desenvolvedor.class).readValues(csvFile);

            List<Desenvolvedor> desenvolvedorList = desenvolvedorIterator.readAll();

            XmlMapper xmlMapper = new XmlMapper();

            xmlMapper.writeValue(new File("desenvolvedor.xml"), desenvolvedorList);

            System.out.println("Arquivo XML gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
