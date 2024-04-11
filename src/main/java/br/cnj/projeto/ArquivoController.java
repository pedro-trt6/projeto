package br.cnj.projeto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arquivos")
public class ArquivoController {

    @GetMapping
    public ResponseEntity<String> getArquivos() {
        return ResponseEntity.ok("Método getArquivos()");
    }

}
