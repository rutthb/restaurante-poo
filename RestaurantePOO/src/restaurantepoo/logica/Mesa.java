/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.logica;

import java.util.ArrayList;
import java.util.Date;



/**
 *
 * @author Antonio
 *
 * - Classe onde serão guardados os produtos conumidos por uma determinada mesa
 * - O numero total de mesas é limitado, as mesas podem estar ocupadas ou livres
 * 
 */
public class Mesa {

    private int mesa;
    private Date horaAbertura;
    private Date horaFechamento;
    private double valorTotal;
    private boolean status;
    public ArrayList<Produto> produtos;

    public Mesa() {
    }

    public Mesa(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Date horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Date getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(Date horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    /**
     * Consulta ao banco de dados para saber o numero de sequência de
     * abertura da mesa utlizada
     *
     * @return inteiro
     */
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }



}
