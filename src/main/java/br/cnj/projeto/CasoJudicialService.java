package br.cnj.projeto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {

    @Autowired
    private final CasoJudicialRepository repository;

    public CasoJudicialService(CasoJudicialRepository repository) {
        this.repository = repository;
    }

    public List<CasoJudicial> getTodosOsCasos() {
        return repository.findAll();
    }

    public CasoJudicial criarCaso(CasoJudicial novoCaso) {
        return novoCaso;
    }

    public CasoJudicial atualizarCaso(Long id, CasoJudicial casoAtualizado) {
        return casoAtualizado;
    }

    public CasoJudicial atualizarCaso(Long id, Map<String, Object> atualizacoes) {
        return null;
    }

    public void deletarCaso(Long id) {
        
    }
}
