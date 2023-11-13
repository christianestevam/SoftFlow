package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQueries({
    @NamedQuery(name = "projetoPorId", query = "select p from Projeto p where p.idProjeto = :id"),
    // pelo nome do projeto
    @NamedQuery(name = "findByNome", query = "select p from Projeto p where p.nomeProjeto = :nome")
})
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long idProjeto;

    private String nomeProjeto;

    private String descricaoProjeto;

    private String statusProjeto;

    private String notasProjeto;

    // Um projeto pode ter vários desenvolvedores
    @OneToMany(mappedBy = "projeto", fetch=FetchType.EAGER)
    private List<Desenvolvedor> desenvolvedores;

    // Um projeto pode ter várias tarefas
    @OneToMany(mappedBy = "projeto", fetch=FetchType.EAGER)
    private List<Tarefa> tarefas;

    @Override
    public String toString(){
        return "Projeto [id:" + idProjeto + ", nome:" + nomeProjeto + ", descricao:" + descricaoProjeto + ", status:" + statusProjeto + ", notas:" + notasProjeto;
    }

}
