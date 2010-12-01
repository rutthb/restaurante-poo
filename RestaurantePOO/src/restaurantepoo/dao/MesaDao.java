/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.Mesa;
import restaurantepoo.logica.Produto;

/**
 *
 * @author Antonio
 */
public class MesaDao {

    private Connection conexao;

    public MesaDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public void adiciona(Mesa m1) throws SQLException{

        String  sql = "insert into mesa (horaabertura, horafechamento, valortotal, status) " +
                "values (?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, String.valueOf(m1.getHoraAbertura()));
        stmt.setString(2, String.valueOf(m1.getHoraFechamento()));
        stmt.setString(3, String.valueOf(m1.getValorTotal()));
        stmt.setString(4, String.valueOf(m1.getStatus()));


        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void criaMesa(Mesa m1) throws SQLException{

        String  sql = "insert into mesa (mesa,status,valortotal) " +
                "values (?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setInt(1, m1.getMesa());
        stmt.setBoolean(2, true);   //true para mesas livres
        stmt.setDouble(3, 0.0);

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void gravarProdutoMesa (Mesa m1,Produto p1){

        m1.addProduto(p1);

    }

    public  ArrayList<Mesa> getLista(String busca) throws SQLException, ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String sql = "Select * from mesa where mesa like ? ORDER BY mesa ASC";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1, busca);       // inserção do caracter de busca.

        ResultSet rs = stmt.executeQuery();

        ArrayList<Mesa> minhaLista = new ArrayList<Mesa>();

        while(rs.next()){
            Mesa m1 = new Mesa();
            m1.setMesa(rs.getInt("mesa"));
            m1.setHoraAbertura(sdf.parse(rs.getString("horaabertura")));
            m1.setHoraFechamento(sdf.parse(rs.getString("horafechamento")));
            m1.setValorTotal(Double.parseDouble(rs.getString("valortotal")));
            if(Integer.parseInt(rs.getString("status"))==1)
                m1.setStatus(true);
            else m1.setStatus(false);

            minhaLista.add(m1);
        }

        rs.close();
        stmt.close();
        return minhaLista;
    }

    public void altera(Mesa m1) throws SQLException{
        String sql = "update mesa set horaabertura=?, horafechamento=?, valortotal=?, status=?" +
                        " where mesa=?";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores

        stmt.setString(1, String.valueOf(sdf.format(m1.getHoraAbertura())));
        stmt.setString(2, String.valueOf(sdf.format(m1.getHoraFechamento())));
        stmt.setDouble(3, m1.getValorTotal());
        stmt.setBoolean(4, m1.getStatus());
        stmt.setInt(5, m1.getMesa());

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void alteraValorTotal(Mesa m1) throws SQLException{
        String sql = "update mesa set valortotal=? where mesa=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores

        stmt.setString(1, String.valueOf(m1.getValorTotal()));
        stmt.setString(2, String.valueOf(m1.getMesa()));

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void remove(Mesa m1) throws SQLException{
        String sql = "delete from mesa where mesa=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, String.valueOf(m1.getMesa()));

        stmt.execute();
        stmt.close();
    }

}
