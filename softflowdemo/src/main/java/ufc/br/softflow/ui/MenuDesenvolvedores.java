package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Slf4j
@Component
public class MenuDesenvolvedores {

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Desenvolvedores\n")
                .append("1 - Inserir Desenvolvedor\n")
                .append("2 - Exibir Desenvolvedor por ID\n")
                .append("3 - Atualizar Desenvolvedor por ID\n")
                .append("4 - Remover Desenvolvedor por ID\n")
                .append("5 - Exibir Desenvolvedor(es) por NOME\n")
                .append("6 - Exibir Desenvolvedor(es) pelo ID da equipe\n")
                .append("7 - Exibir todos os Desenvolvedores\n")
                .append("8 - Menu anterior");
        char opcao = '0';
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Desenvolvedor

                        break;
                    case '2':     // Exibir Desenvolvedor por ID

                        break;
                    case '3':     // Atualizar Desenvolvedor por ID

                        break;
                    case '4':     // Remover Desenvolvedor por ID

                        break;
                    case '5':     // Exibir Desenvolvedor(es) por Nome

                        break;
                    case '6':     // Exibir Desenvolvedor(es) pelo ID da equipe

                        break;
                    case '7':     // Exibir todos os Desenvolvedores

                        break;
                    case '8':     // Menu anterior
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