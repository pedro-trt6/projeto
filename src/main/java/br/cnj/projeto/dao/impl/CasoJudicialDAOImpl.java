package br.cnj.projeto.dao.impl;

import java.util.List;

import br.cnj.projeto.dao.CasoJudicialDAO;
import br.cnj.projeto.model.CasoJudicial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CasoJudicialDAOImpl implements CasoJudicialDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public CasoJudicial findById(int id) { return null; }
    public List<CasoJudicial> findAll() { return null; }
    public void save(CasoJudicial casoJudicial) {}
    public void update(CasoJudicial casoJudicial) {}
    public void partialUpdate(int id, CasoJudicial casoJudicial) {}
    public void delete(int id) {}
}
