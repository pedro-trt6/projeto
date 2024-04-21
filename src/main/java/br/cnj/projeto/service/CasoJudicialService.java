package br.cnj.projeto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cnj.projeto.model.CasoJudicial;
import br.cnj.projeto.repository.CasoJudicialRepository;

@Service
public class CasoJudicialService {

    private List<CasoJudicial> casos;

    @Autowired
    private final CasoJudicialRepository repository;

    public CasoJudicialService(CasoJudicialRepository repository) {
        this.repository = repository;

        casos = new ArrayList<CasoJudicial>(
                Arrays.asList(
                    new CasoJudicial[]{
                        new CasoJudicial(1, "A", "Caso 1"), new CasoJudicial(2, "I", "Caso 2"),
                        new CasoJudicial(3, "A", "Caso 3"), new CasoJudicial(4, "I", "Caso 4")
                    }
                )
            );
    }

    public List<CasoJudicial> getTodosOsCasos() {
        //return repository.findAll();
        return casos;
    }

    public CasoJudicial getCasoJudicial(int numero) {
        return repository.findByNumero(numero);
        /*for (CasoJudicial caso : casos) {
            if (caso.getNumero() == numero) return caso;
        };

        return null;*/
    }

    public CasoJudicial getCasoJudicialTipoDecisao(int tipoDecisao) {
        return repository.findByTipoDecisao(tipoDecisao);
    }

    public CasoJudicial criarCaso(CasoJudicial novoCaso) {
        casos.add(novoCaso);
        return novoCaso;
    }

    public CasoJudicial atualizarCaso(CasoJudicial casoAtualizado) {

        CasoJudicial casoJudicial = getCasoJudicial(casoAtualizado.getNumero());
 
        if (casoJudicial != null) {
            casos.remove(casoJudicial);
            casos.add(casoAtualizado);

            return casoAtualizado;
        }

        return null;
    }

    public CasoJudicial atualizarCaso(Long id, Map<String, Object> atualizacoes) {
        CasoJudicial casoJudicial = getCasoJudicial(id.intValue());

        if(casoJudicial != null) {

            for (Map.Entry<String,Object> entry : atualizacoes.entrySet()) {
                String atributo = entry.getKey();
                Object valor = entry.getValue();

                try {
                    casoJudicial.getClass().getDeclaredField(atributo).setAccessible(true);
                    casoJudicial.getClass().getDeclaredField(atributo).set(casoJudicial, valor);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    return null;
                }
            }

        }

        return casoJudicial;
    }

    public void deletarCaso(Long id) {
        casos.remove(getCasoJudicial(id.intValue()));
    }
}
