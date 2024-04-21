package br.cnj.projeto.dao;

import java.util.List;

import br.cnj.projeto.model.CasoJudicial;

public interface CasoJudicialDAO {

    CasoJudicial findById(int id);
    List<CasoJudicial> findAll();
    void save(CasoJudicial casoJudicial);
    void update(CasoJudicial casoJudicial);
    void partialUpdate(int id, CasoJudicial casoJudicial);
    void delete(int id);

}
