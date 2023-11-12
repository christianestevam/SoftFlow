package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.swing.*;

@Slf4j
@Component
public class MenuEquipes {

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Equipes\n")
                .append("1 - Inserir Equipe\n")
                .append("2 - Exibir Equipe por ID\n")
                .append("3 - Atualizar Equipe por ID\n")
                .append("4 - Remover Equipe por ID\n")
                .append("5 - Exibir Equipe(s) por NOME\n")
                .append("6 - Exibir Equipe pelo ID do projeto\n")
                .append("7 - Exibir todas as Equipes\n")
                .append("8 - Menu anterior");
        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Equipe

                        break;
                    case '2':     // Exibir Equipe por ID

                        break;
                    case '3':     // Atualizar Equipe por ID

                        break;
                    case '4':     // Remover Equipe por ID

                        break;
                    case '5':     // Exibir Equipe(s) por NOME

                        break;
                    case '6':     // Exibir Equipe pelo ID do projeto

                        break;
                    case '7':     // Exibir todas as Equipes

                        break;
                    case '8':
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while(opcao != '8');
    }
}