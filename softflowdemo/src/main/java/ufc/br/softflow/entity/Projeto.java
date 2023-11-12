package ufc.br.softflow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long idProjeto;

    private String nomeProjeto;

    private String descricaoProjeto;

    private LocalDate dataInicioProjeto;

    private LocalDate dataFimProjeto;

    private String statusProjeto;

    private String notasProjeto;

    // Um projeto pode ter vários desenvolvedores
    @OneToMany(mappedBy = "projeto")
    private List<Desenvolvedor> desenvolvedores;

    // Um projeto pode ter várias tarefas
    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;

}
