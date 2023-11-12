package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;

import ufc.br.softflow.dao.DesenvolvedorDAO;
import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.dao.TarefaDAO;
import ufc.br.softflow.entity.Tarefa;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Component
public class MenuTarefas {

    @Autowired
    private TarefaDAO tarefaDAO;

    @Autowired
    private DesenvolvedorDAO desenvolvedorDAO;

    @Autowired
    private ProjetoDAO projetoDAO;

    public void obterTarefa(Tarefa tare){
        String descricao = JOptionPane.showInputDialog("Descrição", tare.getDescricaoTarefa());
        String status = JOptionPane.showInputDialog("Status", tare.getStatusTarefa());
        Integer idDesenvolvedor = Integer.parseInt(JOptionPane.showInputDialog("IdDesenvolvedor", tare.getDesenvolvedor()));
        Integer idProjeto = Integer.parseInt(JOptionPane.showInputDialog("IdProjeto", tare.getProjeto()));

        tare.setDataInicioTarefa(LocalDate.now());
        tare.setDataFimTarefa(LocalDate.now());

        tare.setDescricaoTarefa(descricao);
        tare.setStatusTarefa(status);

        tare.setDesenvolvedor(desenvolvedorDAO.getReferenceById(idDesenvolvedor));
        tare.setProjeto(projetoDAO.getReferenceById(idProjeto));

    }

    public void listarTarefa(Optional<Tarefa> tare){
        JOptionPane.showMessageDialog(null, tare.isPresent() ? tare.toString() : "Nenhuma Tarefa encontrado");
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
                .append("9 - Menu anterior");
        char opcao = '0';
        do {
            try {

                Optional<Tarefa> tare;
                Tarefa taref;
                Integer id;

                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Tarefa

                        tare = Optional.of(new Tarefa());
                        taref = tare.get();
                        obterTarefa(taref);
                        tarefaDAO.save(taref);

                        break;
                    case '2':     // Exibir Tarefa por ID

                        break;
                    case '3':     // Atualizar Tarefa por ID

                        break;
                    case '4':     // Remover Tarefa por ID

                        id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                        tare = tarefaDAO.findById(id);
                        if(tare.isPresent()){
                            taref = tare.get();
                            tarefaDAO.deleteById(Math.toIntExact(taref.getIdTarefa()));
                        }

                        break;
                    case '5':     // Exibir Tarefa pelo ID do projeto

                        break;
                    case '6':     // Exibir Tarefa(s) pelo ID do desenvolvedor

                        break;
                    case '7':     // Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM

                        break;
                    case '8':     // Exibir Tarefa(s) pelo ID do projeto e ESTADO da tarefa

                        break;
                    case '9':    // Menu anterior
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while(opcao != '9');
    }
}