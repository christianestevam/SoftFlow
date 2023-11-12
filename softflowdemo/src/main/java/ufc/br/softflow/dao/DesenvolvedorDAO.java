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
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desenvolvedor")
    private Long idDesenvolvedor;

    private String nome;
    private String email;
    private String funcao;

    // Um projeto pode ter vários desenvolvedores
    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    // Um desenvolvedor pode ter várias tarefas
    @OneToMany(mappedBy = "desenvolvedor")
    private List<Tarefa> tarefas;


}

package ufc.br.softflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "tarefa")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long idTarefa;

    private String descricaoTarefa;
    private String statusTarefa;
    private Date dataInicioTarefa;
    private Date dataFimTarefa;

    // Um desenvolvedor pode ter várias tarefas
    @ManyToOne
    @JoinColumn(name = "id_desenvolvedor")
    private Desenvolvedor desenvolvedor;

    // Um projeto pode ter várias tarefas
    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

}

package ufc.br.softflow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long idProjeto;

    private String nomeProjeto;

    private String descricaoProjeto;

    private Date dataInicioProjeto;

    private Date dataFimProjeto;

    private String statusProjeto;

    private String notasProjeto;

    // Um projeto pode ter vários desenvolvedores
    @OneToMany(mappedBy = "projeto")
    private List<Desenvolvedor> desenvolvedores;

    // Um projeto pode ter várias tarefas
    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;

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

    @Query("SELECT d FROM Desenvolvedor d WHERE d.idDesenvolvedor = :idDesenvolvedor")
    Optional<Desenvolvedor> findById(@Param("idDesenvolvedor") Long idDesenvolvedor);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.nome = :nome")
    Optional<Desenvolvedor> findByNome(@Param("nome") String nome);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.email = :email")
    Optional<Desenvolvedor> findByEmail(@Param("email") String email);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.projeto.idProjeto = :idProjeto")
    List<Desenvolvedor> findByProjeto(@Param("idProjeto") Long idProjeto);

    @Query("SELECT d FROM Desenvolvedor d")
    List<Desenvolvedor> findAll();

    @Query("SELECT d.tarefas FROM Desenvolvedor d WHERE d.idDesenvolvedor = :idDesenvolvedor")
    List<Tarefa> findTarefas(@Param("idDesenvolvedor") Long idDesenvolvedor);




}
