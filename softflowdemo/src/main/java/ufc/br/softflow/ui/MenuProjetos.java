package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;

import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.entity.Projeto;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Component
public class MenuProjetos {

    @Autowired
    private ProjetoDAO projetoDAO;

    public void obterProjeto(Projeto proj){
        String nome = JOptionPane.showInputDialog("Nome", proj.getNomeProjeto());
        String descricao = JOptionPane.showInputDialog("Descrição", proj.getDescricaoProjeto());


        proj.setDataInicioProjeto(LocalDate.now());
        proj.setDataFimProjeto(LocalDate.now());


        String status = JOptionPane.showInputDialog("Status", proj.getStatusProjeto());;
        String notas = JOptionPane.showInputDialog("Notas", proj.getNotasProjeto());;

        proj.setNomeProjeto(nome);
        proj.setDescricaoProjeto(descricao);
        proj.setStatusProjeto(status);
        proj.setNotasProjeto(notas);
    }

    public void listarProjeto(Optional<Projeto> proj){
        JOptionPane.showMessageDialog(null, proj.isPresent() ? proj.toString() : "Nenhum Projeto encontrado");
    }

    public void menu() {
        StringBuilder menu = new StringBuilder("Menu - Projetos\n")
                .append("1 - Inserir Projeto\n")
                .append("2 - Exibir Projeto por ID\n")
                .append("3 - Atualizar Projeto por ID\n")
                .append("4 - Remover Projeto por ID\n")
                .append("5 - Exibir Projeto(s) por NOME\n")
                .append("6 - Exibir Projeto(s) pela DATA_INICIO e DATA_FIM\n")
                .append("7 - Exibir todos os Projetos\n")
                .append("8 - Menu anterior");
        char opcao = '0';
        do {
            try {

                Optional<Projeto> proj;
                Integer id;

                opcao = JOptionPane.showInputDialog(menu).charAt(0);
                switch (opcao) {
                    case '1':     // Inserir Projeto



                        proj = Optional.of(new Projeto());
                        Projeto project = proj.get();
                        obterProjeto(project);
                        projetoDAO.save(project);



                        break;
                    case '2':     // Exibir Projeto por ID

                        break;
                    case '3':     // Atualizar Projeto por ID

                        break;
                    case '4':     // Remover Projeto por ID



                        id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                        proj = projetoDAO.findById(id);
                        if(proj.isPresent()){
                            Projeto projeto = proj.get();
                            projetoDAO.deleteById(Math.toIntExact(projeto.getIdProjeto()));
                        }



                        break;
                    case '5':     // Exibir Projeto(s) por NOME

                        break;
                    case '6':     // Exibir Projeto(s) pela DATA_INICIO e DATA_FIM

                        break;
                    case '7':     // Exibir todos os Projetos

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