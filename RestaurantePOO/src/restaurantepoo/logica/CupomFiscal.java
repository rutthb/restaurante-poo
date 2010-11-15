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
    private enum tipoPagamento {dinheiro,credito,debito};
    private double valorPago;
    private String cpfCliente;

    public CupomFiscal() {
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



}
