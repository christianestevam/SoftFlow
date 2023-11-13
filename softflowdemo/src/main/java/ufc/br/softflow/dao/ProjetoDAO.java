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

    @Query("SELECT p FROM Projeto p WHERE p.idProjeto = :idProjeto")
    Optional<Projeto> findById(@Param("idProjeto") String idProjeto);

    // Exibir Projeto(s) por NOME
    @Query("SELECT p FROM Projeto p WHERE p.nomeProjeto = :nomeProjeto")
    Optional<Projeto> findByNome(@Param("nomeProjeto") String nomeProjeto);

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

    // Native Query
    @Query(value = "SELECT * FROM projeto WHERE id_projeto = :idProjeto", nativeQuery = true)
    Optional<Projeto> findByIdProjeto(@Param("idProjeto") Long idProjeto);

    // Native Query
    @Query(value = "SELECT * FROM projeto WHERE nome_projeto = :nomeProjeto", nativeQuery = true)
    Optional<Projeto> findByNomeProjeto(@Param("nomeProjeto") String nomeProjeto);

}