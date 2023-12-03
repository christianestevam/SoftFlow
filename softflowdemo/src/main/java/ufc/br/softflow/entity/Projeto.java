package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NamedQueries({
        @NamedQuery(name = "projetoPorId", query = "select p from Projeto p where p.id = :id"),
        // pelo nome do projeto
        @NamedQuery(name = "findByNome", query = "select p from Projeto p where p.nomeProjeto = :nome")
})

@Entity
@Document(collection = "projeto")
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Projeto {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

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
        return "Projeto [id:" + id + ", nome:" + nomeProjeto + ", descricao:" + descricaoProjeto + ", status:" + statusProjeto + ", notas:" + notasProjeto;
    }

}
