/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Antonio
 */
public class CriaConexao {

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao Banco");
            return DriverManager.getConnection("jdbc:mysql://localhost/restaurante", "root", "admin");

        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }

    }
}
