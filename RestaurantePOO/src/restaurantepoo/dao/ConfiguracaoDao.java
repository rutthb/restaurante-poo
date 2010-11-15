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

}
