/*
Projeto: Esta entidade representa um projeto de software individual no SoftFlow. Cada projeto pode ter atributos como ID do projeto, nome do projeto, descrição do projeto, data de início, data de término, status do projeto (em andamento, concluído, etc.), e talvez um campo para notas adicionais.
 */

package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_projeto")
    private String nomeProjeto;

    @Column(name = "descricao_projeto")
    private String descricaoProjeto;

    @Column(name = "data_inicio_projeto")
    private Date dataInicioProjeto;

    @Column(name = "data_fim_projeto")
    private Date dataFimProjeto;

    @Column(name = "status_projeto")
    private String statusProjeto;

    @Column(name = "notas_projeto")
    private String notasProjeto;

    // Relacionamento com Tarefas (Um para muitos)
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    // Relacionamento com Equipe (Um para muitos)
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Equipe> equipes;
}
