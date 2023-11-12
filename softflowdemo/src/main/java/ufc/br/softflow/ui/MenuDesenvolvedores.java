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
    private DesenvolvedorDAO baseDevs;

    @Autowired
    private ProjetoDAO projetoDAO;

    public void obterDesenvolvedor(Desenvolvedor dev){
        String nome = JOptionPane.showInputDialog("Nome", dev.getNome());
        String email = JOptionPane.showInputDialog("Email", dev.getNome());
        String funcao = JOptionPane.showInputDialog("Função", dev.getNome());

        String idProjetoStr = JOptionPane.showInputDialog("idProjeto", dev.getProjeto());
        Integer idProjeto = null;
        if (idProjetoStr != null && !idProjetoStr.isEmpty()){
            idProjeto = Integer.parseInt(idProjetoStr);
        }

        dev.setNome(nome);
        dev.setEmail(email);
        dev.setFuncao(funcao);

        if (idProjeto != null){
            dev.setProjeto(projetoDAO.getReferenceById(idProjeto));
        }
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
                .append("5 - Exibir Desenvolvedor(es) por NOME\n")
                .append("6 - Exibir todos os Desenvolvedores\n")
                .append("7 - Menu anterior");
        char opcao = '0';
        do {
            try {

                Optional<Desenvolvedor> dev;
                Desenvolvedor deve;
                Integer id;

                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Desenvolvedor


                        dev = Optional.of(new Desenvolvedor());
                        deve = dev.get();
                        obterDesenvolvedor(deve);
                        baseDevs.save(deve);


                        break;
                    case '2':     // Exibir Desenvolvedor por ID



                        id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                        dev = baseDevs.findById(id);
                        if(dev.isPresent()){
                            Desenvolvedor desenvolvedor = dev.get();
                            listarDesenvolvedor(baseDevs.findById(Math.toIntExact(desenvolvedor.getIdDesenvolvedor())));
                        }



                        break;
                    case '3':     //TODO Atualizar Desenvolvedor por ID



//                        cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser alterado");
//                        cl = baseClientes.findFirstByCpf(cpf);
//                        if (cl != null) {
//                            obterCliente(cl);
//                            baseClientes.save(cl);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o cliente não foi encontrado.");
//                        }

                        id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                        dev = baseDevs.findById(id);
                        if (dev.isPresent()) {
                            deve = dev.get();
                            obterDesenvolvedor(deve);
                            baseDevs.save(deve);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o Desenvolvedor não foi encontrado.");
                        }



                        break;
                    case '4':     // Remover Desenvolvedor por ID



                        id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                        dev = baseDevs.findById(id);
                        if(dev.isPresent()){
                            baseDevs.deleteById(id);
                        }



                        break;
                    case '5':     //TODO Exibir Desenvolvedor(es) por Nome


//                        String nome = JOptionPane.showInputDialog("Nome");
//                        Optional<Desenvolvedor> optionalDev = baseDevs.findByNome(nome);
//
//                        if (optionalDev.isPresent()) {
//                            dev = optionalDev.get();
//                            listarDesenvolvedor(dev);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Desenvolvedor não encontrado para o nome informado.");
//                        }



                        break;
                    case '6':     // Exibir todos os Desenvolvedores



                        listarDesenvolvedores(baseDevs.findAll());




                        break;
                    case '7':     // Menu anterior
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while(opcao != '7');
    }
}