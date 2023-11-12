package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "tarefa")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long idTarefa;

    private String descricaoTarefa;
    private String statusTarefa;
    private LocalDate dataInicioTarefa;
    private LocalDate dataFimTarefa;

    // Um desenvolvedor pode ter várias tarefas
    @ManyToOne
    @JoinColumn(name = "id_desenvolvedor")
    private Desenvolvedor desenvolvedor;

    // Um projeto pode ter várias tarefas
    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

}
