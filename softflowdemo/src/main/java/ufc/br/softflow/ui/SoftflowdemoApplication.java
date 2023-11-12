package ufc.br.softflow.ui;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = "ufc.br.softflow")
@EntityScan("ufc.br.softflow.entity")
@EnableJpaRepositories("ufc.br.softflow.dao")
@Slf4j
public class SoftflowdemoApplication implements CommandLineRunner {

    @Autowired
    private MenuDesenvolvedores menuDesenvolvedores;
    @Autowired
    private MenuProjetos menuProjetos;
    @Autowired
    private MenuTarefas menuTarefas;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SoftflowdemoApplication.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        StringBuilder menu = new StringBuilder("Menu Principal\n")
                .append("1 - Desenvolvedor\n")
                .append("2 - Projetos\n")
                .append("3 - Tarefas\n")
                .append("4 - Sair\n");
        int opcao = 0;
        do {
            try {
                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Desenvolvedores
                        menuDesenvolvedores.menu();
                        break;
                    case '2':     // Projetos
                        menuProjetos.menu();
                        break;
                    case '3':     // Tarefas
                        menuTarefas.menu();
                        break;
                    case '4':     // Sair
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while(opcao != '4');
    }
}