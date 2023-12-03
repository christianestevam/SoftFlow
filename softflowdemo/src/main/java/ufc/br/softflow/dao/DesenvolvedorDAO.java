package ufc.br.softflow.dao;

import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

import java.util.*;

public interface DesenvolvedorDAO {

    Optional<Desenvolvedor> findById(String id);

    Optional<Desenvolvedor> findByNome(String nome);

    Optional<Desenvolvedor> findByEmail(String email);

    List<Desenvolvedor> findAll();

    List<Tarefa> findTarefas(String idDesenvolvedor);

    List<Desenvolvedor> findByIdProjeto(String idProjeto);

    public Desenvolvedor save(Desenvolvedor desenvolvedor);
    public void deleteById(String idDesenvolvedor);
    public Desenvolvedor getReferenceById(String idDesenvolvedor);
}