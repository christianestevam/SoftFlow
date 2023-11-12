package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import ufc.br.softflow.dao.ProjetoDAO;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "desenvolvedor")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQueries({
    @NamedQuery(name = "desenvolvedorPorId", query = "select d from Desenvolvedor d where d.idDesenvolvedor = :id"),
    @NamedQuery(name = "findByProjeto", query = "select d from Desenvolvedor d where d.projeto.idProjeto = :id"),

})
public class Desenvolvedor {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desenvolvedor")
    private Long idDesenvolvedor;

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
        if(projeto.getIdProjeto() != null){
            idstr = Long.toString(projeto.getIdProjeto());
        } else {
            idstr = "null";
        }

        return "Desenvolvedor [id:" + idDesenvolvedor + ", nome:" + nome + ", email:" + email + ", funcao:" + funcao + ", projeto:" + idstr;
    }


}
