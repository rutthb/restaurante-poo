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
    private boolean status;     // 1 = livre e 0 = ocupada
    public  ArrayList<Produto> produtos;
    public ArrayList<String> quantidade;

    public Mesa() {
        produtos = new ArrayList<Produto>();
        quantidade = new ArrayList<String>();
    }

    public Mesa(boolean status) {
        this.status = status;
    }

    public void addProduto(Produto p){
        produtos.add(p);
    }

    public Produto getProduto(int i){
        return produtos.get(i);
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

    @Override
    public String toString() {
        return "\nMesa{" + "\nmesa=" + mesa + "\nhoraAbertura=" + horaAbertura + "\nhoraFechamento=" + horaFechamento + "\nvalorTotal=" + valorTotal + "\nstatus=" + status + "\nprodutos=" + produtos + '}';
    }



}
