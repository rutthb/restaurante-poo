package restaurantepoo.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Registra o driver e estabelece uma conexão com o banco de dados MySQL.
 * Captura de exceções SQLException é de uso obrigatório para JDBC.
 * Informa o erro em caso de exceção.
 *
 */
public class CriaConexao {
    //Registra o driver e estabelece uma conexão. Informa o erro em caso de exceção./
    public static Connection getConexao() throws SQLException {
        try { //Captura de exceções SQLException, uso obrigatório para JDBC
            //Registra um driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao Banco");
            //Estabelece uma conexão
            return DriverManager.getConnection("jdbc:mysql://localhost/restaurantepoo", "root", "root");

        } catch (ClassNotFoundException e) {
            //Exceção gerada para informar o erro
            throw new SQLException(e.getMessage());
        }
    }
}
