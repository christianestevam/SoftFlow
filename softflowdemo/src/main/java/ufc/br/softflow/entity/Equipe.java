

package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Entity
@Table(name = "equipe")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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

    // Relacionamento com Desenvolvedor (Muitas para muitas)
    @ManyToMany
    @JoinTable(
            name = "desenvolvedor_equipe",
            joinColumns = @JoinColumn(name = "id_equipe"),
            inverseJoinColumns = @JoinColumn(name = "id_desenvolvedor")
    )
    private List<Desenvolvedor> desenvolvedores;
}
