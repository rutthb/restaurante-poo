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
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.Mesa;
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

    public void getListaProdutosMesa(String numeroMesa, Mesa m) throws SQLException{

        String sql = "Select * from mesa_produto MP, produto P where P.produto = MP.produto AND mesa = ? and notafiscalitens = 0";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, numeroMesa);       // inserção do caracter de busca.

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Produto p1 = new Produto();
            p1.setProduto(rs.getInt("produto"));
            p1.setNome(rs.getString("nome"));
            p1.setPreco(Double.parseDouble(rs.getString("preco")));
            p1.setDescricao(rs.getString("descricao"));
            m.produtos.add(p1);
            m.quantidade.add(rs.getString("quantidade"));
        }
        rs.close();
        stmt.close();
    }

    public void gravaNumeroNotaMesa(String numeroMesa, int numeroNota) throws SQLException{

        String sql = "update mesa_produto SET notafiscalitens=? where mesa = ? and notafiscalitens = 0";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setInt(1, numeroNota);       // inserção do caracter de busca.
        stmt.setString(2, numeroMesa);       // inserção do caracter de busca.


        stmt.execute();
        stmt.close();
    }

    public void inserirProduto(String numeroMesa, String quantidade, Produto p) throws SQLException {
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
                    + "values (?,?,0,?)";
        } else {
            sql = "UPDATE mesa_produto SET quantidade = ? WHERE mesa = ? AND notafiscalitens = 0 AND produto=?";
        }
        stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, String.valueOf(Integer.parseInt(quantidade) + contagem));
        stmt.setString(2, numeroMesa);
        stmt.setString(3, String.valueOf(p.getProduto()));

        stmt.execute();
        stmt.close();
    }

}
