/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.logica;

/**
 *
 * @author Antonio
 */
public class CupomFiscal {

    private int cupomFIscal;
    private String tipoPagamento;
    private double valorPago;
    private String cpfCliente;
    private Funcionario func;
    private Configuracao conf;

    public CupomFiscal() {
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Configuracao getConf() {
        return conf;
    }


    public CupomFiscal(double valorPago, String cpfCliente) {
        this.valorPago = valorPago;
        this.cpfCliente = cpfCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getCupomFIscal() {
        return cupomFIscal;
    }

    public void setCupomFIscal(int cupomFIscal) {
        this.cupomFIscal = cupomFIscal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }



}
