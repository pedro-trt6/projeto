package br.cnj.projeto.controller;

import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.microservice.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/fila")
public class FilaController {

    @Autowired
    private Producer producer;

     @GetMapping    
     public String send() {        
        producer.send("ENVIANDO ISSO!");        
        return "Enviado.";    
    }

}
