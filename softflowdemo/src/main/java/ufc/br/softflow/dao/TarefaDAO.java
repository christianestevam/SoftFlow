/*

Consultas

- [ ]  Exibir Tarefa(s) pelo **ID** do projeto
- [ ]  Exibir Tarefa pelo **ID** do desenvolvedor
- [ ]  Exibir Tarefa(s) pela **DATA_INICIO** e **DATA_FIM**
- [ ]  Exibir Tarefa(s) pelo **ID** do projeto e **ESTADO** da tarefa


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


import org.springframework.data.jpa.repository.JpaRepository;

import ufc.br.softflow.entity.Tarefa;
import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaDAO extends JpaRepository <Tarefa, Integer> {

    // Exibir Tarefa(s) pelo ID do projeto
    @Query(value = "SELECT * FROM tarefa WHERE id_projeto = :idProjeto", nativeQuery = true)
    List<Tarefa> findByIdProjeto(@Param("idProjeto") Long idProjeto);

    // Exibir Tarefa pelo ID do desenvolvedor
    @Query(value = "SELECT * FROM tarefa WHERE id_desenvolvedor = :idDesenvolvedor", nativeQuery = true)
    List<Tarefa> findByIdDesenvolvedor(@Param("idDesenvolvedor") Long idDesenvolvedor);

    // Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM
    @Query(value = "SELECT * FROM tarefa WHERE data_inicio_tarefa = :dataInicioTarefa AND data_fim_tarefa = :dataFimTarefa", nativeQuery = true)
    List<Tarefa> findByDataInicioFim(@Param("dataInicioTarefa") Date dataInicioTarefa, @Param("dataFimTarefa") Date dataFimTarefa);

    // Exibir Tarefa(s) pelo ID do projeto e ESTADO da tarefa
    @Query(value = "SELECT * FROM tarefa WHERE id_projeto = :idProjeto AND status_tarefa = :statusTarefa", nativeQuery = true)
    List<Tarefa> findByIdProjetoStatus(@Param("idProjeto") Long idProjeto, @Param("statusTarefa") String statusTarefa);

    // Exibir quantidade total de tarefas do projeto
    @Query(value = "SELECT COUNT(*) FROM tarefa WHERE id_projeto = :idProjeto", nativeQuery = true)
    Integer countByIdProjeto(@Param("idProjeto") Long idProjeto);

}
