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
