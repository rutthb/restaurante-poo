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
import restaurantepoo.logica.NotaFiscalItens;

/**
 *
 * @author Antonio
 */
public class NotaFiscalItensDao {

    private Connection conexao;

    public NotaFiscalItensDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public int adiciona(NotaFiscalItens nf) throws SQLException{

        int id = 0;

        String  sql = "insert into notafiscalitens (funcionario, valorpago, cpfcliente, tipopagamento) " +
                "values (?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, nf.getFunc().getNome());
        stmt.setString(2, String.valueOf(nf.getValorPago()));
        stmt.setString(3, nf.getCpfCliente());
        stmt.setString(4, nf.getTipoPagamento());

        // Executa o código SQL
        stmt.execute();

        sql = "SELECT COUNT(*) id FROM notafiscalitens";
        stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            id = rs.getInt("id");
        }

        rs.close();
        stmt.close();

        return id;
    }
}
