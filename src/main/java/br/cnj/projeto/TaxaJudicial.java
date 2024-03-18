package br.cnj.projeto;

import org.springframework.stereotype.Component;

@Component
public class TaxaJudicial {

    public double adicionarTaxa(String estado) {
        return estado.toUpperCase().equals("DF") ? 10.0 : 20.0;
    }

}
