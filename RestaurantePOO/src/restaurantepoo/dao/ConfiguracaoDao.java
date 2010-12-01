/*
 * Todos os métodos de envolvem banco de dados e a configuração do sistema.
 */

package restaurantepoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurantepoo.bancodados.CriaConexao;
import restaurantepoo.logica.Configuracao;

/**
 * Classe que contém todas as manipulações de informações de Configuração no banco de dados.
 *
 */
public class ConfiguracaoDao {

    private Connection conexao;

    /**
     * Cria conexão
     */
    public ConfiguracaoDao() throws SQLException{
        this.conexao = CriaConexao.getConexao();
    }



    public void criarConfiguracao() throws SQLException{
        Configuracao c = new Configuracao("Nome", "Telefone", "Endereço", "CNPJ", "Razao Social", "Insc Estadual", 0);
        ConfiguracaoDao cd = new ConfiguracaoDao();
        cd.adiciona(c);
    }

     public void busca (Configuracao c1) throws SQLException{
        String sql = "Select * from configuracao";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            //métodos getX recuperam os dados de acordo com o tipo sql do atributo
            c1.setCnpj(rs.getString("cnpj"));
            c1.setRazaoSocial(rs.getString("razaosocial"));
            c1.setInscEstadual(rs.getString("inscestadual"));
            c1.setNome(rs.getString("nome"));
            c1.setEndereco(rs.getString("endereco"));
            c1.setTelefone(rs.getString("telefone"));
            c1.setNumeroMesas(rs.getInt("nummesas"));
            c1.setDescricaoRefeicao(rs.getString("descricaorefeicao"));
         }
        }

    /**
     * Não é utilizado.
     * Método para inserção de registro na tabela Configuração.
     * Não é utilizado pois o banco vem com uma configuração genérica para indicar que os dados ainda não foram customizados.
     * @see #altera(restaurantepoo.logica.Configuracao)
     * @param c1
     * @throws SQLException
     */
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
    /**
     * Método para atualização da configuração do sistema (dados do estabelecimento, principalmente).
     * @param objeto configuração
     * @throws SQLException
     */
    public void altera(Configuracao c1) throws SQLException{
        String sql = "update configuracao set cnpj=?, razaosocial=?, inscestadual=?, nummesas=?, " +
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
