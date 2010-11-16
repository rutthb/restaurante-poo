/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.logica;

/**
 *
 * @author Antonio
 */
public class Configuracao {
    private String nome;
    private String telefone;
    private String endereco;
    private String cnpj;
    private String razaoSocial;
    private String inscEstadual;
    private int numeroMesas;
    private String descricaoRefeicao;


    public Configuracao() {
    }

    public Configuracao(String nome, String telefone, String endereco, String cnpj, String razaoSocial, String inscEstadual, int numeroMesas) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscEstadual = inscEstadual;
        this.numeroMesas = numeroMesas;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroMesas() {
        return numeroMesas;
    }

    public void setNumeroMesas(int numeroMesas) {
        this.numeroMesas = numeroMesas;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricaoRefeicao() {
        return descricaoRefeicao;
    }

    public void setDescricaoRefeicao(String descricaoRefeicao) {
        this.descricaoRefeicao = descricaoRefeicao;
    }

    @Override
    public String toString() {
        return "Configuracao{" + "nome=" + nome + "telefone=" + telefone + "endereco=" + endereco + "cnpj=" + cnpj + "razaoSocial=" + razaoSocial + "inscEstadual=" + inscEstadual + "numeroMesas=" + numeroMesas + "descricaoRefeicao=" + descricaoRefeicao + '}';
    }


}
