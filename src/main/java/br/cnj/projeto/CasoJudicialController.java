package br.cnj.projeto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseEntity<CasoJudicial> criarCaso(@RequestBody CasoJudicial novoCaso) {
        CasoJudicial caso = service.criarCaso(novoCaso);
        
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(caso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable Long id, @RequestBody CasoJudicial casoAtualizado) {
        CasoJudicial caso = service.atualizarCaso(id, casoAtualizado);
        
        return ResponseEntity.ok(caso);
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
