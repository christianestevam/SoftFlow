package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.swing.*;

@Slf4j
@Component
public class MenuTarefas {

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Tarefas\n")
                .append("1 - Inserir Tarefa\n")
                .append("2 - Exibir Tarefa por ID\n")
                .append("3 - Atualizar Tarefa por ID\n")
                .append("4 - Remover Tarefa por ID\n")
                .append("5 - Exibir Tarefa(s) pela DESCRIÇÃO\n")
                .append("6 - Exibir Tarefa(s) pelo ID do projeto\n")
                .append("7 - Exibir Tarefa(s) pelo ID do desenvolvedor\n")
                .append("8 - Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM\n")
                .append("9 - Menu anterior");
        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Tarefa

                        break;
                    case '2':     // Exibir Tarefa por ID

                        break;
                    case '3':     // Atualizar Tarefa por ID

                        break;
                    case '4':     // Remover Tarefa por ID

                        break;
                    case '5':     // Exibir Tarefa(s) pela DESCRIÇÃO

                        break;
                    case '6':     // Exibir Tarefa pelo ID do projeto

                        break;
                    case '7':     // Exibir Tarefa(s) pelo ID do desenvolvedor

                        break;
                    case '8':     // Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM

                        break;
                    case '9':     // Menu anterior
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