/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.logica;

/**
 *
 * @author Antonio
 */
public class Produto {

    private int produto;
    private String nome;
    private double preco;
    private String descricao;

    public Produto() {
    }

    public Produto(int produto, String nome, double preco, String descricao) {
        this.produto = produto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    

}
