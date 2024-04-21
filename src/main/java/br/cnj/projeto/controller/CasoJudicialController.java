package br.cnj.projeto.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.cnj.projeto.CasoJudicial;
import br.cnj.projeto.model.CasoJudicial;
import br.cnj.projeto.service.CasoJudicialService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

    private static final Logger logger = LogManager.getLogger(ArquivoController.class);

    @Autowired
    private final CasoJudicialService service;

    public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

    
    @GetMapping
    public ResponseEntity<List<CasoJudicial>> getTodosOsCasos() {
        List<CasoJudicial> casos = service.getTodosOsCasos();

        return ResponseEntity.ok(casos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicial> getCasoJudicial(@PathVariable int id) {
        logger.info("Recuperando caso judicial id: " + id);
        return ResponseEntity.ok(service.getCasoJudicial(id));
    }

    @GetMapping("/tipoDecisao/{tipoDecisao}")
    public ResponseEntity<CasoJudicial> getCasoJudicialTipoDecisao(@PathVariable int tipoDecisao) {
        return ResponseEntity.ok(service.getCasoJudicialTipoDecisao(tipoDecisao));
    }

    @PostMapping
    public ResponseEntity<CasoJudicial> criarCaso(@RequestBody CasoJudicial novoCaso) {
        CasoJudicial caso = service.criarCaso(novoCaso);
        
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(caso);
    }

    @PutMapping
    public ResponseEntity<CasoJudicial> atualizarCaso(@RequestBody CasoJudicial casoAtualizado) {
        CasoJudicial caso = service.atualizarCaso(casoAtualizado);

        if(caso != null) {
            return ResponseEntity.ok(caso);
        } else {
           return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CasoJudicial> ajustarCaso(@PathVariable Long id, @RequestBody Map<String, Object> atualizacoes) {
        CasoJudicial caso = service.atualizarCaso(id, atualizacoes);
        
        return ResponseEntity.ok(caso);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaso(@PathVariable Long id) {
        service.deletarCaso(id);
        return ResponseEntity.noContent().build();
    }
}
