package ufc.br.softflow.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import ufc.br.softflow.dao.DesenvolvedorDAO;
import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

@Primary
@Repository
public interface DesenvolvedorMongo extends DesenvolvedorDAO, MongoRepository<Desenvolvedor, String> {

//    @Query("{ '_id' : ?0 }")
    public Desenvolvedor findByIdDesenvolvedor(String idDesenvolvedor);

    @Query("{ 'nomeDesenvolvedor' : ?0 }")
    Optional<Desenvolvedor> findByNomeDesenvolvedor(String nomeDesenvolvedor);

    @Query("{ 'emailDesenvolvedor' : ?0 }")
    Optional<Desenvolvedor> findByEmailDesenvolvedor(String emailDesenvolvedor);

    List<Desenvolvedor> findAll();

    @Query("{ 'tarefas.desenvolvedor.id' : { $regex: ?0 } }")
    List<Tarefa> findTarefas(String idDesenvolvedor);

    @Query("{ 'projeto.id' : ?0 }")
    List<Desenvolvedor> findByIdProjeto(String idProjeto);

    @Query("{ 'projeto.nomeProjeto' : ?0 }")
    List<Desenvolvedor> findByNomeProjeto(String nomeProjeto);
}