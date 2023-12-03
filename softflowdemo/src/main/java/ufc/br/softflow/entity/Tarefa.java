package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = "tarefaPorId", query = "select t from Tarefa t where t.idTarefa = :id"),
        @NamedQuery(name = "findByProjeto", query = "select t from Tarefa t where t.projeto.idProjeto = :id"),
        @NamedQuery(name = "findByDesenvolvedor", query = "select t from Tarefa t where t.desenvolvedor.idDesenvolvedor = :id")
})

@Entity
@Document(collection = "tarefa")
@Table(name = "tarefa")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idTarefa;

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
        String idstr = desenvolvedor.getIdDesenvolvedor();
        String idstr2 = projeto.getIdProjeto();
        return "Tarefa [id:" + idTarefa + ", descricao:" + descricaoTarefa + ", status:" + statusTarefa + ", dataInicio:" + dataInicioTarefa + ", dataFim:" + dataFimTarefa + ", desenvolvedor:" + idstr + ", projeto:" + idstr2;
    }

}
