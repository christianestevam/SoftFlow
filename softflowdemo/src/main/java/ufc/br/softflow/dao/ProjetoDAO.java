/*

Consultas

- [ ]  Exibir Projeto(s) por **NOME**
- [ ]  Exibir Projeto pela **DATA_INICIO** e **DATA_FIM**
- [ ]  Exibir todos os Projetos
- [ ]  Exibir todos os desenvolvedores do projeto
- [ ]  Exibir todas as tarefas do projeto

> Exibir quantidade total de tarefas do projeto?
>



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
import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ufc.br.softflow.entity.Projeto;
import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

@Repository
public interface ProjetoDAO extends JpaRepository <Projeto, Integer> {

    // Exibir Projeto(s) por NOME
    @Query("SELECT p FROM Projeto p WHERE p.nomeProjeto = :nomeProjeto")
    Optional<Projeto> findByNome(@Param("nomeProjeto") String nomeProjeto);

    // Exibir Projeto pela DATA_INICIO e DATA_FIM
    @Query("SELECT p FROM Projeto p WHERE p.dataInicioProjeto = :dataInicioProjeto AND p.dataFimProjeto = :dataFimProjeto")
    Optional<Projeto> findByDataInicioFim(@Param("dataInicioProjeto") Date dataInicioProjeto, @Param("dataFimProjeto") Date dataFimProjeto);

    // Exibir todos os Projetos
    @Query("SELECT p FROM Projeto p")
    List<Projeto> findAll();

    // Exibir todos os desenvolvedores do projeto
    @Query("SELECT p.desenvolvedores FROM Projeto p WHERE p.idProjeto = :idProjeto")
    List<Desenvolvedor> findByDesenvolvedores(@Param("idProjeto") Long idProjeto);

    // Exibir todas as tarefas do projeto
    @Query("SELECT p.tarefas FROM Projeto p WHERE p.idProjeto = :idProjeto")
    List<Tarefa> findByTarefas(@Param("idProjeto") Long idProjeto);

    // Exibir quantidade total de tarefas do projeto
    @Query("SELECT COUNT(p.tarefas) FROM Projeto p WHERE p.idProjeto = :idProjeto")
    Integer findByQuantidadeTarefas(@Param("idProjeto") Long idProjeto);



}
