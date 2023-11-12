package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufc.br.softflow.dao.DesenvolvedorDAO;
import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.entity.Desenvolvedor;

import java.util.*;
import javax.swing.*;

@Slf4j
@Component
public class MenuDesenvolvedores {

    @Autowired
    private DesenvolvedorDAO desenvolvedorDAO;

    @Autowired
    private ProjetoDAO projetoDAO;

    public void obterDesenvolvedor(Desenvolvedor dev){
        String nome = JOptionPane.showInputDialog("Nome", dev.getNome());
        String email = JOptionPane.showInputDialog("Email", dev.getEmail());
        String funcao = JOptionPane.showInputDialog("Função", dev.getFuncao());

        String idProjetoStr = JOptionPane.showInputDialog("idProjeto", null);
        Integer idProjeto = null;
        if (idProjetoStr != null && !idProjetoStr.isEmpty()){
            idProjeto = Integer.parseInt(idProjetoStr);
            dev.setProjeto(projetoDAO.getReferenceById(idProjeto));
        } else {
            dev.setProjeto(null);
        }

        dev.setNome(nome);
        dev.setEmail(email);
        dev.setFuncao(funcao);
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
                Integer id;

                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao) {
                    case 1:     // Inserir Desenvolvedor



                        dev = Optional.of(new Desenvolvedor());
                        deve = dev.get();
                        obterDesenvolvedor(deve);
                        desenvolvedorDAO.save(deve);



                        break;
                    case 2:     // Exibir Desenvolvedor por id



                        dev = desenvolvedorDAO.findByIdDesenvolvedor(Long.parseLong(JOptionPane.showInputDialog("Id para exibir")));
                        if(dev.isPresent()){
                            listarDesenvolvedor(desenvolvedorDAO.findByIdDesenvolvedor(dev.get().getIdDesenvolvedor()));
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar um Desenvolvedor com esse Id.");
                        }



                        break;
                    case 3:     // Atualizar Desenvolvedor por id



                        String idStr = JOptionPane.showInputDialog("Id para atualizar");
                        if (idStr != null && !idStr.isEmpty()) {
                            id = Integer.parseInt(idStr);
                            dev = desenvolvedorDAO.findById(id);
                            if (dev.isPresent()) {
                                deve = dev.get();
                                obterDesenvolvedor(deve);
                                desenvolvedorDAO.save(deve);
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possivel encontrar um Desenvolvedor com esse Id.");
                            }
                        }



                        break;
                    case 4:     // Remover Desenvolvedor por id



                        id = Integer.parseInt(JOptionPane.showInputDialog("Id para remover"));
                        dev = desenvolvedorDAO.findById(id);
                        if(dev.isPresent()){
                            desenvolvedorDAO.deleteById(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar um Desenvolvedor com esse Id.");
                        }



                        break;
                    case 5:     // Exibir Desenvolvedor por Nome



                        String nome = JOptionPane.showInputDialog("Nome desenvolvedor");
                        dev = desenvolvedorDAO.findByNome(nome);

                        if(!dev.isEmpty()){
                            listarDesenvolvedor(dev);
                        } else {
                            JOptionPane.showMessageDialog(null,"Não foi possivel encontrar um Desenvolvedor com esse Nome.");
                        }



                        break;
                    case 6:     // Exibir Desenvolvedor por idProjeto



                        listarDesenvolvedores(desenvolvedorDAO.findByIdProjeto(Long.parseLong(JOptionPane.showInputDialog("Id projeto"))));



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