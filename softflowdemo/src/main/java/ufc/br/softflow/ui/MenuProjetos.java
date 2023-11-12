package ufc.br.softflow.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;

import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.entity.Projeto;

import java.time.LocalDate;
import java.util.List;
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

    public void listarProjetos(List<Projeto> projetos){
        StringBuilder listagem = new StringBuilder();
        for(Projeto proj : projetos){
            listagem.append(proj.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem == null ? "Nenhum Projeto encontrado" : listagem);
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
        int opcao = 0;
        do {
            try {

                Optional<Projeto> proj;
                Projeto proje;
                Integer id;

                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao) {
                    case 1:     // Inserir Projeto



                        proj = Optional.of(new Projeto());
                        proje = proj.get();
                        obterProjeto(proje);
                        projetoDAO.save(proje);



                        break;
                    case 2:     // Exibir Projeto por ID



                        proj = projetoDAO.findByIdProjeto(Long.parseLong(JOptionPane.showInputDialog("Id para exibir")));
                        if(proj.isPresent()){
                            listarProjeto(projetoDAO.findByIdProjeto(proj.get().getIdProjeto()));
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar um Projeto com esse Id");
                        }



                        break;
                    case 3:     // Atualizar Projeto por ID



                        String idStr = JOptionPane.showInputDialog("Id para atualizar");
                        if (idStr != null && !idStr.isEmpty()) {
                            id = Integer.parseInt(idStr);
                            proj = projetoDAO.findById(id);
                            if(proj.isPresent()){
                                proje = proj.get();
                                obterProjeto(proje);
                                projetoDAO.save(proje);
                            } else {
                                JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o Projeto não foi encontrado.");
                            }
                        }



                        break;
                    case 4:     // Remover Projeto por ID



                        id = Integer.parseInt(JOptionPane.showInputDialog("Id para remover"));
                        proj = projetoDAO.findById(id);
                        if(proj.isPresent()){
                            Projeto projeto = proj.get();
                            projetoDAO.deleteById(Math.toIntExact(projeto.getIdProjeto()));
                        }



                        break;
                    case 5:     // Exibir Projeto(s) por NOME



                        proj = projetoDAO.findByNomeProjeto(JOptionPane.showInputDialog("Nome do projeto"));
                        if(!proj.isEmpty()){
                            listarProjeto(proj);
                        } else {
                            JOptionPane.showMessageDialog(null,"Não foi possivel encontrar um Projeto com esse nome");
                        }



                        break;
                    case 6:     // Exibir Projeto(s) pela DATA_INICIO e DATA_FIM

                        break;
                    case 7:     // Exibir todos os Projetos



                        listarProjetos(projetoDAO.findAll());



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