/*
Consultas

- [ ]  Exibir Desenvolvedor por **ID**
- [ ]  Exibir Desenvolvedor por **NOME**
- [ ]  Exibir Desenvolvedor pelo **EMAIL**
- [ ]  Listar tarefas do desenvolvedor
- [ ]  Exibir Desenvolvedores pelo **ID** da equipe
- [ ]  Exibir todos os Desenvolvedores

> Exibir quantidade total de desenvolvedores?

}

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
@NamedQueries({
    @NamedQuery(name = "desenvolvedorPorId", query = "select d from Desenvolvedor d where d.id = :id"),
    // buscar desenvolvedor por nome
    @NamedQuery(name = "findByNomeDesenvolvedor", query = "select d from Desenvolvedor d where d.nome = :nome"),
    // buscar desenvolvedor por email
    @NamedQuery(name = "findByEmailDesenvolvedor", query = "select d from Desenvolvedor d where d.email = :email"),
})

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

package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
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

    // Relacionamento com Desenvolvedor (Um para Muitos)
    @ManyToOne
    @JoinColumn(name = "id_desenvolvedor")
    private Desenvolvedor desenvolvedor;
}
 */

package ufc.br.softflow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

@Repository
public interface DesenvolvedorDAO extends JpaRepository <Desenvolvedor, Integer> {




}
