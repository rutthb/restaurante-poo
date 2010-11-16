/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.Configuracao;

/**
 *
 * @author Antonio
 */
public class ConfiguracaoDao {

    private Connection conexao;

    public ConfiguracaoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }

    public void criarConfiguracao() throws SQLException{
        Configuracao c = new Configuracao("Nome", "Telefone", "Endereço", "CNPJ", "Razao Social", "Insc Estadual", 0);
        ConfiguracaoDao cd = new ConfiguracaoDao();
        cd.adiciona(c);
    }

 public void adiciona(Configuracao c1) throws SQLException{

        String  sql = "insert into configuracao (cnpj, razaosocial, inscestadual, nummesas,  " +
                "nome, endereco, telefone, descricaorefeicao) values (?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, c1.getCnpj());
        stmt.setString(2, c1.getRazaoSocial());
        stmt.setString(3, c1.getInscEstadual());
        stmt.setString(4, String.valueOf(c1.getNumeroMesas()));
        stmt.setString(5, c1.getNome());
        stmt.setString(6, c1.getEndereco());
        stmt.setString(7, c1.getTelefone());
        stmt.setString(8, c1.getDescricaoRefeicao());


        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

    public void altera(Configuracao c1) throws SQLException{
        String sql = "update configuracao set cnpj=?, razaosocial=?, inscestadual=?, mummesas=?, " +
                        "nome=?, endereco=?, telefone=?, descricaorefeicao=?";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        // Seta os valores
        stmt.setString(1, c1.getCnpj());
        stmt.setString(2, c1.getRazaoSocial());
        stmt.setString(3, c1.getInscEstadual());
        stmt.setString(4, String.valueOf(c1.getNumeroMesas()));
        stmt.setString(5, c1.getNome());
        stmt.setString(6, c1.getEndereco());
        stmt.setString(7, c1.getTelefone());
        stmt.setString(8, c1.getDescricaoRefeicao());

        // Executa o código SQL
        stmt.execute();
        stmt.close();
    }

}
