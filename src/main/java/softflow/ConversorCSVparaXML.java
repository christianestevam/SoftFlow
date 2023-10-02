package softflow;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.*;
import java.util.*;

public class ConversorCSVparaXML {

  public void converterCSVparaXML(String csvFileName) {

    String xmlFileName = "desenvolvedores.xml";

    try {
      List<Desenvolvedor> dados = lerDadosDoCSV(csvFileName);

      XmlMapper xmlMapper = new XmlMapper();
      xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
      xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
      xmlMapper.writeValue(new File(xmlFileName), dados);

      System.out.println("Conversão concluída. Os dados foram salvos em " + xmlFileName);
      System.out.println();

    } catch(IOException e) {
      e.printStackTrace();
    }
  }


  private static List<Desenvolvedor> lerDadosDoCSV(String csvFileName) throws IOException {

    List<Desenvolvedor> dados = new ArrayList<>();

    try (
      BufferedReader reader = new BufferedReader(new FileReader(csvFileName))
    ){
      String linha;
      boolean primeiraLinha = true;

      while((linha = reader.readLine()) != null){
        if(primeiraLinha){
          primeiraLinha = false;
          continue;
        }

        String[] partes = linha.split(",");

        if(partes.length >= 6){
          String nome = partes[0].trim();
          String email = partes[1].trim();
          int idade = Integer.parseInt(partes[2].trim());
          String linguagem = partes[3].trim();
          String descricao = partes[4].trim();
          String disponibilidade = partes[5].trim();

          Desenvolvedor desenvolvedor = new Desenvolvedor(nome, email, idade, linguagem, descricao, disponibilidade);
          dados.add(desenvolvedor);
        }
      }

    } catch(IOException e) {
      e.printStackTrace();
    }

    return dados;
  }
}