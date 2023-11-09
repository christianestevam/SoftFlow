package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarefa")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao_tarefa")
    private String descricaoTarefa;

    @Column(name = "status_tarefa")
    private String statusTarefa;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio_tarefa")
    private Date dataInicioTarefa;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim_tarefa")
    private Date dataFimTarefa;

    // Relacionamento com Projeto (Muitas para uma)
    @ManyToOne
    @JoinColumn(name = "id_projeto", referencedColumnName = "id")
    private Projeto projeto;

    // Relacionamento com Desenvolvedor (Muitas para muitas)
    @ManyToMany
    @JoinTable(
            name = "desenvolvedor_tarefa",
            joinColumns = @JoinColumn(name = "id_tarefa"),
            inverseJoinColumns = @JoinColumn(name = "id_desenvolvedor")
    )
    private List<Desenvolvedor> desenvolvedores;
}

