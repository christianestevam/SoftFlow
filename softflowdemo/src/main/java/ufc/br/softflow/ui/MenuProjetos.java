package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.swing.*;

@Slf4j
@Component
public class MenuProjetos {

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Projetos\n")
                .append("1 - Inserir Projeto\n")
                .append("2 - Exibir Projeto por ID\n")
                .append("3 - Atualizar Projeto por ID\n")
                .append("4 - Remover Projeto por ID\n")
                .append("5 - Exibir Projeto(s) por NOME\n")
                .append("6 - Exibir Projeto pelo ID da equipe\n")
                .append("7 - Exibir Projeto(s) pela DATA_INICIO e DATA_FIM\n")
                .append("8 - Exibir todos os Projetos")
                .append("9 - Menu anterior");
        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Projeto

                        break;
                    case '2':     // Exibir Projeto por ID

                        break;
                    case '3':     // Atualizar Projeto por ID

                        break;
                    case '4':     // Remover Projeto por ID

                        break;
                    case '5':     // Exibir Projeto(s) por NOME

                        break;
                    case '6':     // Exibir Projeto pelo ID da equipe

                        break;
                    case '7':     // Exibir Projeto(s) pela DATA_INICIO e DATA_FIM

                        break;
                    case '8':     // Exibir todos os Projetos

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