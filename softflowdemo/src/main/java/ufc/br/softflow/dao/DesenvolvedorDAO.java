package ufc.br.softflow.dao;

import ufc.br.softflow.entity.Desenvolvedor;
import ufc.br.softflow.entity.Tarefa;

import java.util.*;

public interface DesenvolvedorDAO {

    public Desenvolvedor findByIdDesenvolvedor(String idDesenvolvedor);

    Optional<Desenvolvedor> findByNomeDesenvolvedor(String nomeDesenvolvedor);

    Optional<Desenvolvedor> findByEmailDesenvolvedor(String emailDesenvolvedor);

    List<Desenvolvedor> findAll();

    List<Tarefa> findTarefas(String idDesenvolvedor);

    List<Desenvolvedor> findByIdProjeto(String idProjeto);

    List<Desenvolvedor> findByNomeProjeto(String nomeProjeto);

    public Desenvolvedor save(Desenvolvedor desenvolvedor);
    public void deleteByIdDesenvolvedor(String idDesenvolvedor);
    public Desenvolvedor getReferenceByIdDesenvolvedor(String idDesenvolvedor);
}