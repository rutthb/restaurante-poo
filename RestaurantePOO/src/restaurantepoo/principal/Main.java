/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.principal;

import java.sql.Connection;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.dao.FuncionarioDao;
import restaurantepoo.logica.Funcionario;

/**
 *
 * @author red
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{

        FuncionarioDao func = new FuncionarioDao();
        System.out.println(func.toString());

    }


}
