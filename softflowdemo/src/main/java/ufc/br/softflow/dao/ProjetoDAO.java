package ufc.br.softflow.dao;

import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Projeto;
import ufc.br.softflow.entity.Tarefa;

import java.util.*;

public interface ProjetoDAO {

    Optional<Projeto> findByIdProjeto(String idProjeto);

    Optional<Projeto> findByNomeProjeto(String nomeProjeto);

    List<Projeto> findAll();
//
//    List<Desenvolvedor> findByDesenvolvedores(String idProjeto);
//
//    List<Tarefa> findByTarefas(String idProjeto);

    public Projeto save(Projeto projeto);

    Projeto getReferenceByIdProjeto(String idProjeto);

    public void deleteByIdProjeto(String idProjeto);

}