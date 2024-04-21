package br.cnj.projeto.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/arquivos", produces = "application/json")
public class ArquivoController {

    private static final String DIR_UPLOAD = "uploads/";
    private static final String DIR_DOWNLOAD = "downloads/";
    private static final Logger logger = LogManager.getLogger(ArquivoController.class);

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            logger.error("Erro ao fazer upload: Arquivo vazio");
            return new ResponseEntity<>("Selecione um arquivo para fazer upload", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(DIR_UPLOAD+ file.getOriginalFilename());
            Files.write(path, bytes);
            logger.info("Arquivo carregado com sucesso");
            return new ResponseEntity<>("Arquivo carregado com sucesso", HttpStatus.OK);
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("Erro ao fazer o upload do arquivo");
            return new ResponseEntity<>("Falha ao fazer upload do arquivo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("filename") String filename) {
        try {
            Path filePath = Paths.get(DIR_DOWNLOAD + filename);
            byte[] fileBytes = Files.readAllBytes(filePath);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                    .body(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }

    }

    @GetMapping
    public ResponseEntity<String> getArquivos() {
        return ResponseEntity.ok("Método getArquivos()");
    }

}
