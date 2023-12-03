package ufc.br.softflow.dao;

import ufc.br.softflow.entity.Tarefa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TarefaDAO {
    
    Optional<Tarefa> findById(String id);

//    List<Tarefa> findByIdProjeto(String idProjeto);
//
//    List<Tarefa> findByIdDesenvolvedor(String idDesenvolvedor);
//
//    List<Tarefa> findByDataInicioFim(LocalDate dataInicioTarefa, LocalDate dataFimTarefa);

//    List<Tarefa> findByIdProjetoStatus(String idProjeto, String statusTarefa);

    Integer countByIdProjeto(String idProjeto);

    public Tarefa save(Tarefa tarefa);

    public void deleteById(String id);
}