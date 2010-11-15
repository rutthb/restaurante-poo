/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.logica;

/**
 *
 * @author Antonio
 */
public class NotaFiscalRefeicao extends CupomFiscal{

    private int qtdRefeicoes;

    public NotaFiscalRefeicao(double valorPago, String cpfCliente) {
    }

    public NotaFiscalRefeicao() {
    }

    public int getQtdRefeicoes() {
        return qtdRefeicoes;
    }

    public void setQtdRefeicoes(int qtdRefeicoes) {
        this.qtdRefeicoes = qtdRefeicoes;
    }


    public void escreveDescricao(){
        Configuracao config = new Configuracao();
        System.out.println(config.getDescricaoRefeicao());
    }

}
