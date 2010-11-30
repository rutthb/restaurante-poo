/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.Produto;

/**
 *
 * @author Antonio
 */
public class MesaProdutoDao {

    private Connection conexao;

    public MesaProdutoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public void inserirProduto(String numeroMesa, int quantidade, Produto p) throws SQLException {
        int contagem = 0;

        String sql = "SELECT quantidade FROM mesa_produto where mesa = ? AND notafiscalitens = 0 AND produto=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, numeroMesa);       // inserção do caracter de busca.
        stmt.setString(2, String.valueOf(p.getProduto()));

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contagem = rs.getInt("quantidade");
        }

        if (contagem == 0) {
            sql = "insert into mesa_produto (quantidade, mesa, notafiscalitens, produto) "
                    + "values (?,?,?,?)";
        } else {
            sql = "UPDATE mesa_produto SET quantidade = ? WHERE mesa = ? AND notafiscalitens = ? AND produto=?";
        }
        stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, String.valueOf(quantidade + contagem));
        stmt.setString(2, numeroMesa);
        stmt.setString(3, "0");
        stmt.setString(4, String.valueOf(p.getProduto()));

        stmt.execute();
        stmt.close();
    }

}
