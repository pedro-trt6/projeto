package br.cnj.projeto.model;

import br.cnj.projeto.CustoJudicial;
import br.cnj.projeto.TaxaJudicial;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CasoJudicial {

    //private CustoJudicial custoJudicial;// = new CustoJudicial();
    //@Autowired
    //private TaxaJudicial taxaJudicial;// = new TaxaJudicial();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    private String decisao;
    private String descricao;
    private int tipoDecisao;

    public CasoJudicial() {
        
    }

    public CasoJudicial(CustoJudicial custo, TaxaJudicial taxa) {
        //this.custoJudicial = custo;
        //this.taxaJudicial = taxa;
    }

    public CasoJudicial(int numero, String decisao, String descricao) {
        this.numero = numero;
        this.decisao = decisao;
        this.descricao = descricao;
    }

    public double finalizarCusto(double custo, String estado, int anoJulgamento) {
        //custo += custoJudicial.adicionarCusto(anoJulgamento);
        //custo += taxaJudicial.adicionarTaxa(estado);

        return custo;
    }

    public int getNumero() {
        return numero;
    }

    public String getDecisao() {
        return decisao;
    }

    public int getTipoDecisao() {
        return tipoDecisao;
    }

    public String getDescricao() {
        return descricao;
    }
}