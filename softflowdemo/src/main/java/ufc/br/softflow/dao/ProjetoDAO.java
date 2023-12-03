package ufc.br.softflow.dao;

import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Projeto;
import ufc.br.softflow.entity.Tarefa;

import java.util.*;

public interface ProjetoDAO {

    Optional<Projeto> findById(String idProjeto);

    Optional<Projeto> findByNome(String nomeProjeto);

    List<Projeto> findAll();

    List<Desenvolvedor> findByDesenvolvedores(String idProjeto);

    List<Tarefa> findByTarefas(String idProjeto);

    Integer findByQuantidadeTarefas(String idProjeto);

    Optional<Projeto> findByIdProjeto(String idProjeto);

    Optional<Projeto> findByNomeProjeto(String nomeProjeto);

    public Projeto save(Projeto projeto);

    Projeto getReferenceById(String idProjetoStr);

    public void deleteById(int i);
}