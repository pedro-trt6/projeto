package br.cnj.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CasoJudicial {

    @Autowired
    private CustoJudicial custoJudicial;// = new CustoJudicial();
    @Autowired
    private TaxaJudicial taxaJudicial;// = new TaxaJudicial();
    private int numero;
    private String decisao;
    private String descricao;

    public CasoJudicial() {
        
    }

    public CasoJudicial(CustoJudicial custo, TaxaJudicial taxa) {
        this.custoJudicial = custo;
        this.taxaJudicial = taxa;
    }

    public CasoJudicial(int numero, String decisao, String descricao) {
        this.numero = numero;
        this.decisao = decisao;
        this.descricao = descricao;
    }

    public double finalizarCusto(double custo, String estado, int anoJulgamento) {
        custo += custoJudicial.adicionarCusto(anoJulgamento);
        custo += taxaJudicial.adicionarTaxa(estado);

        return custo;
    }

    public int getNumero() {
        return numero;
    }

    public String getDecisao() {
        return decisao;
    }

    public String getDescricao() {
        return descricao;
    }
}
