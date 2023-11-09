package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Entity
@Table(name = "desenvolvedor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "funcao")
    private String funcao;

    // Relacionamento com Tarefas (Muitas para muitas)
    @ManyToMany(mappedBy = "desenvolvedores")
    private List<Tarefa> tarefas;

    // Relacionamento com Equipe (Muitas para muitas)
    @ManyToMany(mappedBy = "desenvolvedores")
    private List<Equipe> equipes;
}
