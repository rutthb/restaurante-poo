/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantepoo.logica;

import java.sql.Connection;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;

/**
 *
 * @author Antonio
 *
 * @ public Funcionario(String nome, String telefone, String endereco, String cpf, double salario, String funcao) {
 *
 * @param funcionario (Id do funcionario)
 * @param nome
 * @param telefone
 * @param cpf
 * @param salario
 * @param funcao
 *
 * @see Mesa
 *
 */
public class Funcionario {

    int funcionario;
    String nome;
    String telefone;
    String endereco;
    String cpf;
    double salario;
    String funcao;

    public Funcionario(String nome, String telefone, String endereco, String cpf, double salario, String funcao) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "funcionario=" + funcionario + "nome=" + nome + "telefone=" + telefone + "endereco=" + endereco + "cpf=" + cpf + "salario=" + salario + "funcao=" + funcao + '}';
    }

}
