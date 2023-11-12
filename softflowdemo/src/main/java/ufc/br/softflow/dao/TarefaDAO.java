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
