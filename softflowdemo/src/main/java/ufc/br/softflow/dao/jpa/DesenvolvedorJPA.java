package ufc.br.softflow.dao.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

@Repository
// @Primary
// @EnableJpaRepositories
public interface DesenvolvedorJPA extends JpaRepository <Desenvolvedor, String> {

    @Query("SELECT d FROM Desenvolvedor d WHERE d.idDesenvolvedor = :idDesenvolvedor")
    Optional<Desenvolvedor> findByIdDesenvolvedor(@Param("idDesenvolvedor") String idDesenvolvedor);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.nomeDesenvolvedor = :nomeDesenvolvedor")
    Optional<Desenvolvedor> findByNomeDesenvolvedor(@Param("nome") String nomeDesenvolvedor);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.emailDesenvolvedor = :emailDesenvolvedor")
    Optional<Desenvolvedor> findByEmail(@Param("email") String emailDesenvolvedor);

    @Query("SELECT d FROM Desenvolvedor d WHERE d.projeto.idProjeto = :idProjeto")
    List<Desenvolvedor> findByProjeto(@Param("idProjeto") String idProjeto);

    @Query("SELECT d FROM Desenvolvedor d")
    List<Desenvolvedor> findAll();

    @Query("SELECT d.tarefas FROM Desenvolvedor d WHERE d.idDesenvolvedor = :idDesenvolvedor")
    List<Tarefa> findTarefas(@Param("idDesenvolvedor") String idDesenvolvedor);

    // Native Query
    @Query(value = "SELECT * FROM desenvolvedor WHERE id_projeto = :idProjeto", nativeQuery = true)
    List<Desenvolvedor> findByIdProjeto(@Param("idProjeto") String idProjeto);

    // Native Query
//    @Query(value = "SELECT * FROM desenvolvedor WHERE id_desenvolvedor = :idDesenvolvedor", nativeQuery = true)
//    Optional<Desenvolvedor> findByIdDesenvolvedor(@Param("idDesenvolvedor") String idDesenvolvedor);

}