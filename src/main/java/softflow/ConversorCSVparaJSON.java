package softflow;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.*;

public class ConversorCSVparaJSON {

    public void converterCSVparaJSON(String csvFileName) {

        String jsonFile = "desenvolvedores.json";

        try {
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(new File(csvFileName)).readAll();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(jsonFile), readAll);

            System.out.println("Conversão concluída. Os dados foram salvos em " + jsonFile);
            System.out.println();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}