package br.cnj.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnj.projeto.model.CasoJudicial;

@Repository
public interface CasoJudicialRepository extends JpaRepository<CasoJudicial, Integer> {

    /*public List<CasoJudicial> findAll() {
        return null;
    }*/
    //CasoJudicial findByNumero(String numero);
    CasoJudicial findByNumero(Integer numero);
    CasoJudicial findByTipoDecisao(Integer tipoDecisao);
    //CasoJudicial findByTeste(Integer teste); // dá erro caso a propriedade "testte" não exista

}
