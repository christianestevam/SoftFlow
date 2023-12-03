package ufc.br.softflow.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.*;

import ufc.br.softflow.dao.DesenvolvedorDAO;
import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

@Primary
@Repository
@EnableMongoRepositories
public interface DesenvolvedorMongo extends DesenvolvedorDAO, MongoRepository<Desenvolvedor, String> {

    Optional<Desenvolvedor> findById(String idDesenvolvedor);

    Optional<Desenvolvedor> findByNome(String nome);

    Optional<Desenvolvedor> findByEmail(String email);

    @Query("{ 'projeto.id' : { $regex: ?0 } }")
    List<Desenvolvedor> findByProjeto(String idProjeto);

    List<Desenvolvedor> findAll();

    @Query("{ 'tarefas.desenvolvedor.id' : { $regex: ?0 } }")
    List<Tarefa> findTarefas(String idDesenvolvedor);

    @Query("{ 'projeto.id' : { $regex: ?0 } }")
    List<Desenvolvedor> findByIdProjeto(String idProjeto);
}