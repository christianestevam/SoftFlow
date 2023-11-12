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
@NamedQueries({
    @NamedQuery(name = "tarefaPorId", query = "select t from Tarefa t where t.idTarefa = :id"),
    @NamedQuery(name = "findByProjeto", query = "select t from Tarefa t where t.projeto.idProjeto = :id"),
    @NamedQuery(name = "findByDesenvolvedor", query = "select t from Tarefa t where t.desenvolvedor.idDesenvolvedor = :id")
})

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
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_desenvolvedor")
    private Desenvolvedor desenvolvedor;

    // Um projeto pode ter várias tarefas
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    @Override
    public String toString(){
        String idstr = Long.toString(desenvolvedor.getIdDesenvolvedor());
        String idstr2 = Long.toString(projeto.getIdProjeto());
        return "Tarefa [id:" + idTarefa + ", descricao:" + descricaoTarefa + ", status:" + statusTarefa + ", dataInicio:" + dataInicioTarefa + ", dataFim:" + dataFimTarefa + ", desenvolvedor:" + idstr + ", projeto:" + idstr2;
    }

}
