package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;

import ufc.br.softflow.dao.DesenvolvedorDAO;
import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.dao.TarefaDAO;
import ufc.br.softflow.dao.jpa.DesenvolvedorJPA;
import ufc.br.softflow.dao.jpa.ProjetoJPA;
import ufc.br.softflow.dao.jpa.TarefaJPA;
import ufc.br.softflow.entity.Tarefa;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Component
public class MenuTarefas {

    //@Autowired
    private TarefaDAO tarefaDAO;

    //@Autowired
    private DesenvolvedorDAO desenvolvedorDAO;

    //@Autowired
    private ProjetoDAO projetoDAO;

    public void obterTarefa(Tarefa tare){
        String descricao = JOptionPane.showInputDialog("Descrição", tare.getDescricaoTarefa());
        String status = JOptionPane.showInputDialog("Status", tare.getStatusTarefa());


        String idDesenvolvedorStr = JOptionPane.showInputDialog("IdDesenvolvedor", null);
        String idProjetoStr =JOptionPane.showInputDialog("IdProjeto", null);
        if (idDesenvolvedorStr != null && !idDesenvolvedorStr.isEmpty()){
            tare.setDesenvolvedor(desenvolvedorDAO.getReferenceById(idProjetoStr));
        } else {
            tare.setDesenvolvedor(null);
        }
        if (idProjetoStr != null && !idProjetoStr.isEmpty()){
            tare.setProjeto(projetoDAO.getReferenceById(idProjetoStr));
        } else {
            tare.setProjeto(null);
        }


        String dataInicio = JOptionPane.showInputDialog("Data de início formato AAAA-MM-DD:");
        LocalDate dataInicioTarefa = LocalDate.parse(dataInicio);
        tare.setDataInicioTarefa(dataInicioTarefa);

        String dataFim = JOptionPane.showInputDialog("Data de fim formato AAAA-MM-DD:");
        LocalDate dataFimTarefa = LocalDate.parse(dataFim);
        tare.setDataFimTarefa(dataFimTarefa);

        tare.setDescricaoTarefa(descricao);
        tare.setStatusTarefa(status);
    }

    public void listarTarefa(Optional<Tarefa> tare){
        JOptionPane.showMessageDialog(null, tare.isPresent() ? tare.toString() : "Nenhuma Tarefa encontrado");
    }

    public void listarTarefas(List<Tarefa> tarefas){
        StringBuilder listagem = new StringBuilder();
        for(Tarefa tare : tarefas){
            listagem.append(tare.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem == null ? "Nenhuma Tarefa encontrado" : listagem);
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Tarefas\n")
                .append("1 - Inserir Tarefa\n")
                .append("2 - Exibir Tarefa por ID\n")
                .append("3 - Atualizar Tarefa por ID\n")
                .append("4 - Remover Tarefa por ID\n")
                .append("5 - Exibir Tarefa(s) pelo ID do projeto\n")
                .append("6 - Exibir Tarefa pelo ID do desenvolvedor\n")
                .append("7 - Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM\n")
                .append("8 - Exibir Tarefa(s) pelo ID do projeto e ESTADO da tarefa\n")
                .append("9 - Contar tarefas pelo ID do projeto\n")
                .append("10 - Menu anterior");
        int opcao = 0;
        do {
            try {

                Optional<Tarefa> tare;
                Tarefa taref;
                String id;

                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao) {
                    case 1:     // Inserir Tarefa



                        tare = Optional.of(new Tarefa());
                        taref = tare.get();
                        obterTarefa(taref);
                        tarefaDAO.save(taref);



                        break;
                    case 2:     // Exibir Tarefa por ID



                        id = JOptionPane.showInputDialog("Id para exibir");
                        tare = tarefaDAO.findById(id);
                        if (tare.isPresent()){
                            listarTarefa(tarefaDAO.findById(id));
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar uma Tarefa com esse id.");
                        }



                        break;
                    case 3:     // Atualizar Tarefa por ID



                        id = JOptionPane.showInputDialog("Id para atualizar");
                        if (id != null && !id.isEmpty()) {
                            tare = tarefaDAO.findById(id);
                            if (tare.isPresent()) {
                                taref = tare.get();
                                obterTarefa(taref);
                                tarefaDAO.save(taref);
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possivel encontrar uma Tarefa com esse id.");
                            }
                        }



                        break;
                    case 4:     // Remover Tarefa por ID



                        id = JOptionPane.showInputDialog("Id para remover");
                        tare = tarefaDAO.findById(id);
                        if(tare.isPresent()){
                            tarefaDAO.deleteById(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar uma Tarefa com esse id.");
                        }



                        break;
                    case 5:     // Exibir Tarefa(s) pelo ID do projeto



                        listarTarefas(tarefaDAO.findByIdProjeto(JOptionPane.showInputDialog("Id projeto")));



                        break;
                    case 6:     // Exibir Tarefa(s) pelo ID do desenvolvedor



                        listarTarefas(tarefaDAO.findByIdDesenvolvedor(JOptionPane.showInputDialog("Id desenvolvedor")));



                        break;
                    case 7:     // Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM



                        String dataInicioStr = JOptionPane.showInputDialog("Digite a data de início no formato AAAA-MM-DD:");
                        LocalDate dataInicio = LocalDate.parse(dataInicioStr);

                        String dataFimStr = JOptionPane.showInputDialog("Digite a data de fim no formato AAAA-MM-DD:");
                        LocalDate dataFim = LocalDate.parse(dataFimStr);

                        List<Tarefa> tarefas = tarefaDAO.findByDataInicioFim(dataInicio, dataFim);
                        listarTarefas(tarefas);



                        break;
                    case 8:     // Exibir Tarefa(s) pelo ID do projeto e ESTADO da tarefa



                        listarTarefas(tarefaDAO.findByIdProjetoStatus(JOptionPane.showInputDialog("Id do projeto"), JOptionPane.showInputDialog("Estado da tarefa")));



                        break;
                    case 9:     // Contar tarefas pelo ID do projeto



                        JOptionPane.showMessageDialog(null, tarefaDAO.countByIdProjeto(JOptionPane.showInputDialog("Id do projeto")));



                        break;
                    case 10:    // Menu anterior
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while(opcao != 10);
    }
}