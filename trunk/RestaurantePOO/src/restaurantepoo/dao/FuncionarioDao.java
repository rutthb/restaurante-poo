/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.Funcionario;

/**
 *
 * @author Antonio
 */
public class FuncionarioDao {

    private Connection conexao;

    public FuncionarioDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public void adiciona(Funcionario f1) throws SQLException{

        String  sql = "insert into funcionario (nome, cpf, endereco, telefone, funcao, salario) " +
                "values (?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, f1.getNome());
        stmt.setString(2, f1.getCpf());
        stmt.setString(3, f1.getEndereco());
        stmt.setString(4, f1.getTelefone());
        stmt.setString(5, f1.getFuncao());
        stmt.setString(6, String.valueOf(f1.getSalario()));


        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public  List<Funcionario> getLista(String busca) throws SQLException{
        String sql = "Select * from funcionario where nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, busca);       // inserção do caracter de busca.

        ResultSet rs = stmt.executeQuery();

        List<Funcionario> minhaLista = new ArrayList<Funcionario>();

        while(rs.next()){
            Funcionario p1 = new Funcionario();
            p1.setFuncionario(rs.getInt("funcionario"));
            p1.setNome(rs.getString("nome"));
            p1.setSalario(Double.parseDouble(rs.getString("salario")));
            p1.setCpf(rs.getString("cpf"));
            p1.setEndereco(rs.getString("endereco"));
            p1.setTelefone(rs.getString("telefone"));
            p1.setFuncao(rs.getString("funcao"));

            minhaLista.add(p1);
        }

        rs.close();
        stmt.close();
        return minhaLista;
    }

    public void altera(Funcionario f1) throws SQLException{
        String sql = "update funcionario set nome=?, cpf=?, endereco=?, telefone=?, funcao=?" +
                        ", salario=? where funcionario=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores

        stmt.setString(1, f1.getNome());
        stmt.setString(2, f1.getCpf());
        stmt.setString(3, f1.getEndereco());
        stmt.setString(4, f1.getTelefone());
        stmt.setString(5, f1.getFuncao());
        stmt.setString(6, String.valueOf(f1.getSalario()));

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void remove(Funcionario f1) throws SQLException{
        String sql = "delete from funcionario where funcionario=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, String.valueOf(f1.getFuncionario()));

        stmt.execute();
        stmt.close();
    }

    public void busca(Funcionario f1) throws SQLException{
        String sql = "Select * from funcionario where produto like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, String.valueOf(f1.getFuncionario()));       // inserção do caracter de busca.

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            f1.setNome(rs.getString("nome"));
        }

        rs.close();
        stmt.close();
    }
}
