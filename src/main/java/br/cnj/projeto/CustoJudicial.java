package br.cnj.projeto;

import org.springframework.stereotype.Component;

@Component
public class CustoJudicial {

    public double adicionarCusto(int anoJulgamento) {
        return anoJulgamento >= 2024 ? 20.0 : 10.0;
    }
}
