package ufc.br.softflow.dao.jpa;


import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ufc.br.softflow.entity.Tarefa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//@Primary
//@EnableJpaRepositories
public interface TarefaJPA extends JpaRepository <Tarefa, String> {

    // Exibir Tarefa(s) pelo ID do projeto
    @Query(value = "SELECT * FROM tarefa WHERE id_projeto = :idProjeto", nativeQuery = true)
    List<Tarefa> findByIdProjeto(@Param("idProjeto") String idProjeto);

    // Exibir Tarefa pelo ID do desenvolvedor
    @Query(value = "SELECT * FROM tarefa WHERE id_desenvolvedor = :idDesenvolvedor", nativeQuery = true)
    List<Tarefa> findByIdDesenvolvedor(@Param("idDesenvolvedor") String idDesenvolvedor);

    // Exibir Tarefa(s) pela DATA_INICIO e DATA_FIM
    @Query(value = "SELECT * FROM tarefa WHERE data_inicio_tarefa BETWEEN :dataInicioTarefa AND :dataFimTarefa", nativeQuery = true)
    List<Tarefa> findByDataInicioFim(@Param("dataInicioTarefa") LocalDate dataInicioTarefa, @Param("dataFimTarefa") LocalDate dataFimTarefa);

    // Exibir Tarefa(s) pelo ID do projeto e ESTADO da tarefa
    @Query(value = "SELECT * FROM tarefa WHERE id_projeto = :idProjeto AND status_tarefa = :statusTarefa", nativeQuery = true)
    List<Tarefa> findByIdProjetoStatus(@Param("idProjeto") String idProjeto, @Param("statusTarefa") String statusTarefa);

    // Exibir quantidade total de tarefas do projeto
    @Query(value = "SELECT COUNT(*) FROM tarefa WHERE id_projeto = :idProjeto", nativeQuery = true)
    Integer countByIdProjeto(@Param("idProjeto") String idProjeto);

}
