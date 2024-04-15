package br.cnj.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoJudicialRepository extends JpaRepository<CasoJudicial, Long> {

    /*public List<CasoJudicial> findAll() {
        return null;
    }*/
    CasoJudicial findByNumero(String numero);

}
