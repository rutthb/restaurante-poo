/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.NotaFiscalRefeicao;

/**
 *
 * @author Antonio
 */
public class NotaFIscalRefeicaoDao {

    private Connection conexao;

    public NotaFIscalRefeicaoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public void adiciona(NotaFiscalRefeicao nf) throws SQLException{

        String  sql = "insert into notafiscalrefeicao (funcionario, valorpago, cpfcliente, tipopagamento, descricaorefeicao, qtdrefeicoes) " +
                "values (?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, nf.getFunc());
        stmt.setString(2, String.valueOf(nf.getValorPago()));
        stmt.setString(3, nf.getCpfCliente());
        stmt.setString(4, nf.getTipoPagamento());
        stmt.setString(5, nf.getConf().getDescricaoRefeicao());
        stmt.setString(6, String.valueOf(nf.getQtdRefeicoes()));


        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

}
