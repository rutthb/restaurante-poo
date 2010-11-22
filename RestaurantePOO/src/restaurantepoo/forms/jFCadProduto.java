/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jFCadFuncionario.java
 *
 * Created on 15/11/2010, 20:55:26
 */

package restaurantepoo.forms;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import restaurantepoo.dao.ProdutoDao;
import restaurantepoo.logica.Produto;

/**
 *
 * @author red
 */
public class jFCadProduto extends javax.swing.JFrame {

    /** Creates new form jFCadFuncionario */
    public jFCadProduto() throws SQLException {
        initComponents();
        populaTabela("");
    }

   DefaultTableModel tmProduto = new DefaultTableModel(
            new Object [][]{
            },
            new String[]{"produto", "nome", "preco"});

    private List<Produto> produtos;
    ListSelectionModel lsmProduto;


     private void populaTabela(String busca) throws SQLException{

        ProdutoDao pd = new ProdutoDao();
        produtos = pd.getLista("%"+busca+"%");

        for (Produto p1 : produtos) {
            insereTabela(p1);
        }
    }

    private void insereTabela(Produto p1){

        tmProduto.addRow(new String[]{
            String.valueOf(p1.getProduto()),
            p1.getNome(),
            String.valueOf(p1.getPreco())
        });
    }

     private void novoCadastro(){

        Produto p1 = new Produto();

        preencherObjeto(p1);

        try {
            ProdutoDao dao = new ProdutoDao();
            dao.adiciona(p1);
            tmProduto.setNumRows(0);
            populaTabela("");
        } catch (SQLException ex) {
            Logger.getLogger(jFCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void alteraCadastro(){

        Produto p1 = new Produto();
        p1.setProduto(Integer.parseInt(id.getText()));
        preencherObjeto(p1);

        try {
            ProdutoDao dao = new ProdutoDao();
            dao.altera(p1);
            tmProduto.setNumRows(0);
            populaTabela("");
        } catch (SQLException ex) {
            Logger.getLogger(jFCadProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        private void removerCadastro(){

        Produto p1 = new Produto();
        p1.setProduto(Integer.parseInt(id.getText()));
        
        ProdutoDao dao;
        try {
            dao = new ProdutoDao();
            dao.remove(p1);
            tmProduto.setNumRows(0);
            populaTabela("");
        } catch (SQLException ex) {
            Logger.getLogger(jFCadProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparCampos(){
        id.setText("");
        nome.setText("");
        descricao.setText("");
        preco.setText("");
    }

    private  void desabilitaDados(){
        id.setEditable(false);
        nome.setEditable(false);
        descricao.setEnabled(false);
        preco.setEditable(false);

    }

    private void habilitaDados(){
        nome.setEditable(true);
        descricao.setEnabled(true);
        preco.setEditable(true);
    }

    private boolean verificaStrings(){

        if (!nome.getText().equals("") && !preco.getText().equals("") && !descricao.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
            return false;
        }
    }

    private boolean verificaDouble(){
        double temp;
        try{
            temp = Double.valueOf(preco.getText());
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Campo de preço deve ter o formato \"9999.99\"");
            return false;
        }
    }

    private void escolherLinha(){

        int linha = tabela.getSelectedRow();
        System.out.println(linha);

        Produto p1 = new Produto();
        String temp;

        temp = String.valueOf(tabela.getValueAt(linha, 0));
        p1.setProduto(Integer.parseInt(temp));

        preencherCampos(p1);

    }

    private void preencherCampos(Produto p1){
        System.out.println(p1);
        
        try {
            ProdutoDao dao = new ProdutoDao();
            dao.busca(p1);
        } catch (SQLException ex) {
            Logger.getLogger(jFCadProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(p1);

        id.setEditable(true);
        id.setText(String.valueOf(p1.getProduto()));
        id.setEditable(false);

        nome.setText(p1.getNome());
        preco.setText(String.valueOf(p1.getPreco()));
        descricao.setText(p1.getDescricao());

    }

    private void preencherObjeto(Produto p1){

        p1.setNome(nome.getText());
        p1.setDescricao(descricao.getText());
        p1.setPreco(Double.parseDouble(preco.getText()));
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JTextField();
        preco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setNextFocusableComponent(jLabel4);
        jPanel1.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, -1));

        preco.setNextFocusableComponent(excluir);
        jPanel1.add(preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        jLabel4.getAccessibleContext().setAccessibleName("Preco");

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel1.add(salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 85, 25));

        cancelar.setText("Cancelar");
        cancelar.setNextFocusableComponent(nome);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 85, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel7.setText("Cadastro de Produto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 41, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Food-32.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 50, 49));

        tabela.setModel(tmProduto);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 96, 291, 312));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Produtos Existentes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 68, -1, 22));
        jLabel8.getAccessibleContext().setAccessibleName("");

        jTextPane1.setBackground(new java.awt.Color(240, 240, 240));
        jTextPane1.setEditable(false);
        jTextPane1.setText("Clique sobre o nome para editar os dados.");
        jScrollPane3.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 426, -1, -1));

        excluir.setText("Excluir");
        excluir.setEnabled(false);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        jPanel1.add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 85, 25));

        descricao.setColumns(20);
        descricao.setRows(5);
        descricao.setNextFocusableComponent(preco);
        jScrollPane2.setViewportView(descricao);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 240, -1));

        editar.setText("Atualizar");
        editar.setEnabled(false);
        editar.setMaximumSize(new java.awt.Dimension(63, 23));
        editar.setMinimumSize(new java.awt.Dimension(63, 23));
        editar.setPreferredSize(new java.awt.Dimension(63, 23));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jPanel1.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 85, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Número:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        id.setEditable(false);
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if(id.getText().equals(""))
            dispose();
        else{
            editar.setEnabled(false);
            excluir.setEnabled(false);
            salvar.setEnabled(true);
            limparCampos();
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        if (verificaStrings() && verificaDouble()){
            novoCadastro();
            limparCampos();
            editar.setEnabled(false);
            excluir.setEnabled(false);
            salvar.setEnabled(true);
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (verificaStrings() && verificaDouble()){
            alteraCadastro();
            limparCampos();
            editar.setEnabled(false);
            excluir.setEnabled(false);
            salvar.setEnabled(true);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        habilitaDados();
        escolherLinha();
        editar.setEnabled(true);
        excluir.setEnabled(true);
        salvar.setEnabled(false);
    }//GEN-LAST:event_tabelaMouseClicked

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        removerCadastro();
        limparCampos();
        editar.setEnabled(false);
        excluir.setEnabled(false);
        salvar.setEnabled(true);
    }//GEN-LAST:event_excluirActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new jFCadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextArea descricao;
    private javax.swing.JButton editar;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField preco;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
