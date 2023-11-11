package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "equipe")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_equipe")
    private String nomeEquipe;

    // Relacionamento com Projeto (Muitas para uma)
    @ManyToOne
    @JoinColumn(name = "id_projeto", referencedColumnName = "id")
    private Projeto projeto;

    // Relacionamento com Desenvolvedor (Uma equipe pode ter varios desenvolvedores, mas um desenvolvedor pode estar em uma só equipe)
    @OneToMany(mappedBy = "equipe")
    private List<Desenvolvedor> desenvolvedores;
}
