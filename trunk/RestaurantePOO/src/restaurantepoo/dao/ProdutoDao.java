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
import restaurantepoo.logica.Produto;

/**
 *
 * @author Antonio
 */
public class ProdutoDao {

    private Connection conexao;

    public ProdutoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public void adiciona(Produto p) throws SQLException{
        
        String  sql = "insert into produto (nome, descricao, preco) " +
                "values (?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getDescricao());
        stmt.setString(3, String.valueOf(p.getPreco()));

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }


    public void busca(Produto p1) throws SQLException{
        String sql = "Select * from produto where produto like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, String.valueOf(p1.getProduto()));       // inserção do caracter de busca.

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            p1.setNome(rs.getString("nome"));
            p1.setPreco(Double.parseDouble(rs.getString("preco")));
            p1.setDescricao(rs.getString("descricao"));
        }

        rs.close();
        stmt.close();
    }

    public  List<Produto> getLista(String busca) throws SQLException{
        String sql = "Select * from produto where nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, busca);       // inserção do caracter de busca.

        ResultSet rs = stmt.executeQuery();

        List<Produto> minhaLista = new ArrayList<Produto>();

        while(rs.next()){
            Produto p1 = new Produto();
            p1.setProduto(rs.getInt("produto"));
            p1.setNome(rs.getString("nome"));
            p1.setPreco(Double.parseDouble(rs.getString("preco")));
            p1.setDescricao(rs.getString("descricao"));

            minhaLista.add(p1);
        }

        rs.close();
        stmt.close();
        return minhaLista;
    }

    public void altera(Produto p1) throws SQLException{
        String sql = "update produto set nome=?, preco=?" +
                        ", descricao=? where produto=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores

        stmt.setString(1, p1.getNome());
        stmt.setString(2, String.valueOf(p1.getPreco()));
        stmt.setString(3, p1.getDescricao());
        stmt.setString(4, String.valueOf(p1.getProduto()));

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void remove(Produto p1) throws SQLException{
        String sql = "delete from produto where produto=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, String.valueOf(p1.getProduto()));

        stmt.execute();
        stmt.close();
    }

}
