package ufc.br.softflow.dao.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

import ufc.br.softflow.dao.TarefaDAO;
import ufc.br.softflow.entity.Tarefa;

@Primary
@Repository
//@EnableMongoRepositories
public interface TarefaMongo extends TarefaDAO, MongoRepository<Tarefa, String> {

    @Query("{ 'idTarefa' : ?0 }")
    Optional<Tarefa> findByIdTarefa(String idTarefa);
//
//    @Query("{ 'desenvolvedor.id' : { $regex: ?0 } }")
//    List<Tarefa> findByIdDesenvolvedor(String idDesenvolvedor);
//
//    @Query("{ 'dataInicio' : { $gte: ?0 }, 'dataFim' : { $lte: ?1 } }")
//    List<Tarefa> findByDataInicioFim(LocalDate dataInicioTarefa, LocalDate dataFimTarefa);

//    @Query("{ 'projeto.id' : { $regex: ?0 }, 'status' : { $regex: ?1 } }")
//    List<Tarefa> findByIdProjetoStatus(String idProjeto, String statusTarefa);

    @Query(value = "{ 'projeto.id' : { $regex: ?0 } }", count = true)
    Integer countByIdProjeto(String idProjeto);

}