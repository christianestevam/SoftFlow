package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    // Relacionamento com Tarefa (Um para Muitos)
    @OneToMany(mappedBy = "desenvolvedor")
    private List<Tarefa> tarefas;

    // Relacionamento com Equipe (Muitos para um)
    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;
}
