package ufc.br.softflow.dao.jpa;


import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ufc.br.softflow.entity.Projeto;
import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;


@Repository
//@Primary
//@EnableJpaRepositories
public interface ProjetoJPA extends JpaRepository <Projeto, String> {

    @Query("SELECT p FROM Projeto p WHERE p.idProjeto = :idProjeto")
    Optional<Projeto> findByIdProjeto(@Param("idProjeto") String idProjeto);

    // Exibir Projeto(s) por NOME
    @Query("SELECT p FROM Projeto p WHERE p.nomeProjeto = :nomeProjeto")
    Optional<Projeto> findByNomeProjeto(@Param("nomeProjeto") String nomeProjeto);

    // Exibir todos os Projetos
    @Query("SELECT p FROM Projeto p")
    List<Projeto> findAll();

    // Exibir todos os desenvolvedores do projeto
    @Query("SELECT p.desenvolvedores FROM Projeto p WHERE p.idProjeto = :idProjeto")
    List<Desenvolvedor> findByDesenvolvedores(@Param("idProjeto") String idProjeto);

    // Exibir todas as tarefas do projeto
    @Query("SELECT p.tarefas FROM Projeto p WHERE p.idProjeto = :idProjeto")
    List<Tarefa> findByTarefas(@Param("idProjeto") String idProjeto);

    // Exibir quantidade total de tarefas do projeto
    @Query("SELECT COUNT(p.tarefas) FROM Projeto p WHERE p.idProjeto = :idProjeto")
    Integer findByQuantidadeTarefas(@Param("idProjeto") String idProjeto);



}