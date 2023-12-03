package ufc.br.softflow.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.*;

import ufc.br.softflow.dao.ProjetoDAO;
import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Projeto;
import ufc.br.softflow.entity.Tarefa;

@Primary
@Repository
public interface ProjetoMongo extends ProjetoDAO, MongoRepository<Projeto, String> {

    @Query("{ '_id' : ?0 }")
    Optional<Projeto> findByIdProjeto(String idProjeto);

    @Query("{ 'nomeProjeto' : ?0 }")
    Optional<Projeto> findByNomeProjeto(String nomeProjeto);

    List<Projeto> findAll();
//
//    @Query("{ 'desenvolvedores.projeto.id' : ?0 }")
//    List<Desenvolvedor> findByDesenvolvedores(String idProjeto);
//
//    @Query("{ 'tarefas.projeto.id' : ?0 }")
//    List<Tarefa> findByTarefas(String idProjeto);
}