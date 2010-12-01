/*
 * Todos os métodos de envolvem banco de dados e Funcionário.
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
 * Classe que contém todas as manipulações de informações de funcionário no banco de dados.
 * 
 */
public class FuncionarioDao {

    private Connection conexao;
    /**
     * Cria conexão
     * @throws SQLException
     */
    public FuncionarioDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }
    /**
     * Método para inserções de registros na tabela funcionário
     * @param objeto funcionário
     * @throws SQLException
     */
    public void adiciona(Funcionario f1) throws SQLException{
        //Montagem da string sql que será rodada no banco de dados
        String  sql = "insert into funcionario (nome, cpf, endereco, telefone, funcao, salario) " +
                "values (?,?,?,?,?,?)";
        //Método preparedStatement de coneção para criar o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, f1.getNome());
        stmt.setString(2, f1.getCpf());
        stmt.setString(3, f1.getEndereco());
        stmt.setString(4, f1.getTelefone());
        stmt.setString(5, f1.getFuncao());
        stmt.setString(6, String.valueOf(f1.getSalario()));


        // Executa a string sql
        stmt.execute();
        //Fecha conexão
        stmt.close();
    }
    /**
     * Lista de Funcionários cadastrados no sistema de acordo com algum critério de seleção.
     * @param busca string de seleção para buscar um ou mais funcionários funcionário
     * @return ArrayList de funcionários que se enquadraram na busca
     * @throws SQLException
     */
    public  List<Funcionario> getLista(String busca) throws SQLException{
        String sql = "Select * from funcionario where nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        // inserção do caracter de busca.
        stmt.setString(1, busca);       

        //executa a query no banco de dados
        ResultSet rs = stmt.executeQuery();

        //cria o arraylist de funcionários para armazenar todos os funcionários que retornaram da busca no banco
        List<Funcionario> minhaLista = new ArrayList<Funcionario>();

        //funcionario por funcionário é adicionado no arraylist
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

    /**
     * Método para atualização de dados de funcionário
     * @param objeto funcionário que será atualizado
     * @throws SQLException
     */
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
    /**
     * Método para remoção do cadastro de funcionário
     * @param objeto funcionário
     * @throws SQLException
     */
    public void remove(Funcionario f1) throws SQLException{
        String sql = "delete from funcionario where funcionario=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, String.valueOf(f1.getFuncionario()));

        stmt.execute();
        stmt.close();
    }

    public void busca(Funcionario f1) throws SQLException{
        String sql = "Select * from funcionario where funcionario = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        // inserção do caracter de busca.
        stmt.setString(1, String.valueOf(f1.getFuncionario()));

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            f1.setNome(rs.getString("nome"));
            f1.setCpf(rs.getString("cpf"));
            f1.setEndereco(rs.getString("endereco"));
            f1.setTelefone(rs.getString("telefone"));
            f1.setFuncao(rs.getString("funcao"));
            f1.setSalario(rs.getDouble("salario"));
        }

        rs.close();
        stmt.close();
    }
}
