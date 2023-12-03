package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@NamedQueries({
        @NamedQuery(name = "desenvolvedorPorId", query = "select d from Desenvolvedor d where d.idDesenvolvedor = :id")
})

@Entity
@Document(collection = "desenvolvedor")
@Table(name = "desenvolvedor")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id_desenvolvedor")
    private String idDesenvolvedor;

    private String nome;
    private String email;
    private String funcao;

    // Um projeto pode ter vários desenvolvedores
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    // Um desenvolvedor pode ter várias tarefas
    @OneToMany(mappedBy = "desenvolvedor", fetch=FetchType.EAGER)
    private List<Tarefa> tarefas;

    @Override
    public String toString(){

        String idstr;
        if(projeto != null){
            idstr = projeto.getIdProjeto();
        } else {
            idstr = "null";
        }

        return "Desenvolvedor [id:" + idDesenvolvedor + ", nome:" + nome + ", email:" + email + ", funcao:" + funcao + ", projeto:" + idstr;
    }


}
