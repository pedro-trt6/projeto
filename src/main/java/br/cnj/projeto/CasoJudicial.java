package br.cnj.projeto;

import org.springframework.stereotype.Component;

@Component
public class CasoJudicial {

    private CustoJudicial custoJudicial;// = new CustoJudicial();
    private TaxaJudicial taxaJudicial;// = new TaxaJudicial();

    public CasoJudicial(CustoJudicial custo, TaxaJudicial taxa) {
        this.custoJudicial = custo;
        this.taxaJudicial = taxa;
    }

    public double finalizarCusto(double custo, String estado, int anoJulgamento) {
        custo += custoJudicial.adicionarCusto(anoJulgamento);
        custo += taxaJudicial.adicionarTaxa(estado);

        return custo;
    }
}
