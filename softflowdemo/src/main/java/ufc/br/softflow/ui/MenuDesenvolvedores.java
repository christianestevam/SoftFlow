package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufc.br.softflow.dao.DesenvolvedorDAO;
import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.dao.jpa.DesenvolvedorJPA;
import ufc.br.softflow.dao.jpa.ProjetoJPA;
import ufc.br.softflow.entity.Desenvolvedor;

import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;

@Slf4j
@Component
public class MenuDesenvolvedores {

    @Autowired
    private DesenvolvedorDAO desenvolvedorDAO;

    @Autowired
    private ProjetoDAO projetoDAO;

    public void obterDesenvolvedor(Desenvolvedor dev){
        String nome = JOptionPane.showInputDialog("Nome", dev.getNomeDesenvolvedor());
        String email = JOptionPane.showInputDialog("Email", dev.getEmailDesenvolvedor());
        String funcao = JOptionPane.showInputDialog("Função", dev.getFuncaoDesenvolvedor());

        String idProjetoStr = JOptionPane.showInputDialog("idProjeto", null);
        if (idProjetoStr != null && !idProjetoStr.isEmpty()){
            dev.setProjeto(projetoDAO.getReferenceByIdProjeto(idProjetoStr));
        } else {
            dev.setProjeto(null);
        }

        dev.setNomeDesenvolvedor(nome);
        dev.setEmailDesenvolvedor(email);
        dev.setFuncaoDesenvolvedor(funcao);
    }

    public void listarDesenvolvedor(Optional<Desenvolvedor> dev){
        JOptionPane.showMessageDialog(null, dev.isPresent() ? dev.toString() : "Nenhum Desenvolvedor encontrado");
    }

    public void listarDesenvolvedores(List<Desenvolvedor> desenvolvedores){
        StringBuilder listagem = new StringBuilder();
        for(Desenvolvedor dev : desenvolvedores){
            listagem.append(dev.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem == null ? "Nenhum Desenvolvedor encontrado" : listagem);
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Desenvolvedores\n")
                .append("1 - Inserir Desenvolvedor\n")
                .append("2 - Exibir Desenvolvedor por ID\n")
                .append("3 - Atualizar Desenvolvedor por ID\n")
                .append("4 - Remover Desenvolvedor por ID\n")
                .append("5 - Exibir Desenvolvedor por NOME\n")
                .append("6 - Exibir Desenvolvedor(es) por Projeto\n")
                .append("7 - Exibir todos os Desenvolvedores\n")
                .append("8 - Menu anterior");
        int opcao = 0;
        do {
            try {

                Optional<Desenvolvedor> dev;
                Desenvolvedor deve;
                String id;

                List<Desenvolvedor> allDevs = desenvolvedorDAO.findAll();
                Object[] devIds = allDevs.stream().map(Desenvolvedor::getIdDesenvolvedor).toArray();;

                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao) {
                    case 1:     // Inserir Desenvolvedor



                        dev = Optional.of(new Desenvolvedor());
                        deve = dev.get();
                        obterDesenvolvedor(deve);
                        desenvolvedorDAO.save(deve);



                        break;
                    case 2:     // Exibir Desenvolvedor por id (BOX)



//                        devIds = allDevs.stream().map(Desenvolvedor::getIdDesenvolvedor).toArray();
//
//                        String selectedId = (String) JOptionPane.showInputDialog(null, "Selecione o ID do desenvolvedor", "Exibir Desenvolvedor", JOptionPane.QUESTION_MESSAGE, null, devIds, devIds[0]);
//
//                        if (selectedId != null) {
//                            dev = desenvolvedorDAO.findByIdDesenvolvedor(selectedId);
//                            if(dev.isPresent()) {
//                                listarDesenvolvedor(dev);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Não foi possível encontrar um Desenvolvedor com esse Id.");
//                            }
//                        }



                        break;
                    case 3:     // Atualizar Desenvolvedor por id (BOX)



//                        selectedId = (String) JOptionPane.showInputDialog(null, "Selecione o ID do desenvolvedor", "Atualizar Desenvolvedor", JOptionPane.QUESTION_MESSAGE, null, devIds, devIds[0]);
//
//                        if (selectedId != null) {
//                            dev = desenvolvedorDAO.findByIdDesenvolvedor(selectedId);
//                            if (dev.isPresent()) {
//                                deve = dev.get();
//                                obterDesenvolvedor(deve);
//                                desenvolvedorDAO.save(deve);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Não foi possível encontrar um Desenvolvedor com esse Id.");
//                            }
//                        }



                        break;
                    case 4:     // Remover Desenvolvedor por id (BOX)



//                        selectedId = (String) JOptionPane.showInputDialog(null, "Selecione o ID do desenvolvedor", "Remover Desenvolvedor", JOptionPane.QUESTION_MESSAGE, null, devIds, devIds[0]);
//
//                        if (selectedId != null) {
//                            dev = desenvolvedorDAO.findByIdDesenvolvedor(selectedId);
//                            if (dev.isPresent()) {
//                                desenvolvedorDAO.deleteById(selectedId);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Não foi possível encontrar um Desenvolvedor com esse Id.");
//                            }
//                        }



                        break;
                    case 5:     // Exibir Desenvolvedor por Nome



                        Object[] devNomes = allDevs.stream().map(Desenvolvedor::getNomeDesenvolvedor).toArray();
                        String selectedNome = (String) JOptionPane.showInputDialog(null, "Selecione o nome do desenvolvedor", "Exibir Desenvolvedor", JOptionPane.QUESTION_MESSAGE, null, devNomes, devNomes[0]);
                        dev = desenvolvedorDAO.findByNomeDesenvolvedor(selectedNome);
                        if(dev.isPresent()) {
                            listarDesenvolvedor(dev);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível encontrar um Desenvolvedor com esse Id.");
                        }



                        break;
                    case 6:     // Exibir Desenvolvedor por Projeto(nome)



//                        Set<String> projNomesSet = allDevs.stream().map(dev -> dev.getProjeto().getNomeProjeto()).collect(Collectors.toSet());
//                        Object[] projNomes = projNomesSet.toArray();
//
//                        selectedNome = (String) JOptionPane.showInputDialog(null, "Selecione o nome do projeto", "Exibir Desenvolvedor", JOptionPane.QUESTION_MESSAGE, null, projNomes, projNomes[0]);
//
//                        if (selectedNome != null) {
//                            List<Desenvolvedor> devs = desenvolvedorDAO.findByNomeProjeto(selectedNome);
//                            if (!devs.isEmpty()) {
//                                listarDesenvolvedores(devs);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Não foi possível encontrar um Desenvolvedor com esse nome de projeto.");
//                            }
//                        }





                        break;
                    case 7:     // Exibir todos os Desenvolvedores



                        listarDesenvolvedores(desenvolvedorDAO.findAll());



                        break;
                    case 8:     // Menu anterior
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while(opcao != 8);
    }
}