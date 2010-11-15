/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantepoo.principal;

import java.sql.Connection;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.dao.FuncionarioDao;
import restaurantepoo.dao.ProdutoDao;
import restaurantepoo.logica.Funcionario;
import restaurantepoo.logica.Produto;

/**
 *
 * @author red
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{

        Produto p = new Produto("Sudo de Laranja", 2.50, "Suco de laranja natural 500 ml");
        System.out.println(p.toString());

        ProdutoDao pd = new ProdutoDao();
        System.out.println("conexão realizada com sucesso");

        pd.adiciona(p);

    }
}
