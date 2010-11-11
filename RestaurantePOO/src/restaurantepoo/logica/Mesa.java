/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.logica;

import sun.util.calendar.LocalGregorianCalendar.Date;

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
    private int numero;
    private Date horaAbertura;
    private Date horaFechamento;
    private double valorTotal;

    public Mesa() {
    }

    public Mesa(int numero, Date horaAbertura) {
        this.numero = numero;
        this.horaAbertura = horaAbertura;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }



}
