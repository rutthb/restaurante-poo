/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;

/**
 *
 * @author Antonio
 */
public class CupomFIscalDao {

    private Connection conexao;

    public CupomFIscalDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }


}
