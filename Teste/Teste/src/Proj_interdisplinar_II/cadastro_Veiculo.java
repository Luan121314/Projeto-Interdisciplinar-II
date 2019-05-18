/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proj_interdisplinar_II;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cadastro_Veiculo extends javax.swing.JFrame {

    public cadastro_Veiculo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeiculos = new javax.swing.JTable();
        btnIncluir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistEstado = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlist_Marca = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jlist_modelo = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jlistLoja = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_Veiculo", "Nome do Modelo", "Nome da Marca", "Placa", "Ano", "Preço", "Sigla do Estado", "Nome da Loja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVeiculos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 790, 170);

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncluir);
        btnIncluir.setBounds(600, 40, 100, 25);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(600, 80, 100, 25);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(600, 120, 100, 25);

        jlistEstado.setModel(new DefaultListModel());
        jlistEstado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jlistEstado);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 40, 70, 120);

        jlist_Marca.setModel(new DefaultListModel());
        jlist_Marca.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlist_MarcaValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jlist_Marca);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(50, 40, 100, 120);

        jlist_modelo.setModel(new DefaultListModel());
        jlist_modelo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlist_modelo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                EVTmodeloSelecionado(evt);
            }
        });
        jScrollPane5.setViewportView(jlist_modelo);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(170, 40, 80, 120);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estado");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 20, 70, 15);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Marca");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 20, 100, 15);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Modelo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 20, 80, 15);

        jlistLoja.setModel(new DefaultListModel());
        jlistLoja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane9.setViewportView(jlistLoja);

        getContentPane().add(jScrollPane9);
        jScrollPane9.setBounds(370, 40, 70, 120);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Loja");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(370, 20, 70, 15);

        setSize(new java.awt.Dimension(849, 449));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    ResultSet results = null;
    ResultSet resultsMarca = null;
    ResultSet resultsModelo = null;
    Banco banco = new Banco();

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        exibirMarca();
        exibirModelo(true);
        exibirEstado();
        exibirLoja();
        exibirJtable();
    }//GEN-LAST:event_formWindowOpened

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        TelaCadastro telaCadastro1 = new TelaCadastro();
        telaCadastro1.setVisible(true);
        //String query = "INSERT INTO veiculo (placa,ano,preco,sigla_estado,nome_Loja,nome_Marca,nome_Modelo) values('" + Placa + "'," + ano + ","+Preco+",'"+sigla_Estado+"','"+nome_loja+"','"+nome_Marca+"','"+nome_Modelo+"')";

    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            String identificador = (String) jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(), 0);
            banco.iniciaConexao();
            try {
                String query = "delete from veiculo where id_Veiculo = '" + identificador + "';";
                banco.statement.executeUpdate(query);

            } catch (Exception e) {
            } finally {
                banco.finalizaConexao();
                exibirJtable();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecione o item que deseja excluir");
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String nome_Modelo = "";
        String nome_Marca = "";
        String sigla_Estado = "";
        String nome_loja = "";
        String id_Veiculo = "";

        try {
            nome_Modelo = jlist_modelo.getSelectedValue();
            nome_Marca = jlist_Marca.getSelectedValue();
            sigla_Estado = jlistEstado.getSelectedValue();
            nome_loja = jlistLoja.getSelectedValue();
            id_Veiculo = (String) jTableVeiculos.getValueAt(jTableVeiculos.getSelectedRow(), 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecione um item da lista que deseja alterar");
        }
        if (!jlist_modelo.isSelectionEmpty() && !jlist_Marca.isSelectionEmpty() && !jlistEstado.isSelectionEmpty() && !jlistLoja.isSelectionEmpty() && jTableVeiculos.isColumnSelected(jTableVeiculos.getSelectedColumn())) {

            String query = "update veiculo set nome_Marca = '" + nome_Marca + "', nome_Modelo = '" + nome_Modelo + "', sigla_Estado = '" + sigla_Estado + "', nome_loja = '" + nome_loja + "' where id_Veiculo = '" + id_Veiculo + "';";
            System.out.println(query);
            try {
                banco.iniciaConexao();
                banco.statement.executeUpdate(query);
            } catch (Exception e) {
            } finally {
                banco.finalizaConexao();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione marca , modelo, estado e loja para alterar");
        }
        exibirJtable();

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jlist_MarcaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlist_MarcaValueChanged
        exibirModelo(false);//parâmetro-->listar todos ?
        
    }//GEN-LAST:event_jlist_MarcaValueChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        jlist_modelo.clearSelection();
        jlist_Marca.clearSelection();
        exibirModelo(true);
        exibirMarca();
        exibirJtable();

    }//GEN-LAST:event_formMouseClicked

    private void EVTmodeloSelecionado(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_EVTmodeloSelecionado

    }//GEN-LAST:event_EVTmodeloSelecionado

    public void exibirMarca() {
        DefaultListModel modeloMarca = (DefaultListModel) (jlist_Marca.getModel());
        modeloMarca.clear();
        String query = "select distinct nome_Marca from  marca_e_modelo order by nome_Marca ;";
        String dadoBanco = "";

        banco.iniciaConexao();
        try {
            //listar no jlist todas os id que estão no banco
            resultsMarca = banco.statement.executeQuery(query);

            while (resultsMarca.next()) {
                dadoBanco = resultsMarca.getString("nome_Marca");
                modeloMarca.addElement(dadoBanco);
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, "Erro ao executar instrução lista marcas \n Mais detalhes :\n" + e2.getMessage());
        } finally {
            banco.finalizaConexao();

        }
    }

    public void exibirModelo(boolean todos) {
        DefaultListModel modeloModelo = (DefaultListModel) (jlist_modelo.getModel());
        modeloModelo.clear();
        String marca = jlist_Marca.getSelectedValue();
        String query = "";
        if (todos) {
            query = "select distinct nome_Modelo from  marca_e_modelo order by nome_Modelo ;";
        } else {
            query = "select distinct nome_Modelo from  marca_e_modelo where nome_Marca = '" + marca + "' order by nome_Modelo ;";
        }

        String dadoBanco = "";

        banco.iniciaConexao();
        try {
            //listar no jlist todas os id que estão no banco
            resultsModelo = banco.statement.executeQuery(query);
            while (resultsModelo.next()) {
                dadoBanco = "";
                dadoBanco = resultsModelo.getString("nome_Modelo");
                modeloModelo.addElement(dadoBanco);
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, "Erro ao executar instrução lista modelos \n Mais detalhes :\n" + e2.getMessage());
        } finally {
            banco.finalizaConexao();

        }
    }

    public void exibirEstado() {
        DefaultListModel modeloEstado = (DefaultListModel) (jlistEstado.getModel());
        modeloEstado.clear();
        String query = "";
        query = "select distinct sigla_Estado from  estado order by sigla_Estado ;";
        String dadoBanco = "";
        banco.iniciaConexao();
        try {
            //listar no jlist todas os Estados que estão no banco
            results = banco.statement.executeQuery(query);
            while (results.next()) {
                dadoBanco = results.getString("sigla_Estado");
                modeloEstado.addElement(dadoBanco);
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, "Erro ao executar instrução lista Estados \n Mais detalhes :\n" + e2.getMessage());
        } finally {
            banco.finalizaConexao();

        }
    }

    public void exibirLoja() {
        DefaultListModel modeloLoja = (DefaultListModel) (jlistLoja.getModel());
        String query = "select nome_loja from  loja order by nome_loja ;";
        String dadoBanco = "";

        banco.iniciaConexao();
        try {
            //listar no jlist todas os lojas que estão no banco
            results = banco.statement.executeQuery(query);
            while (results.next()) {
                dadoBanco = results.getString("nome_loja");
                modeloLoja.addElement(dadoBanco);
            }
        } catch (SQLException e2) {
            JOptionPane.showMessageDialog(null, "Erro ao executar instrução lista loja \n Mais detalhes :\n" + e2.getMessage());
        } finally {
            banco.finalizaConexao();

        }
    }

    public void exibirJtable() {
        DefaultTableModel tbVeiculos = (DefaultTableModel) jTableVeiculos.getModel();
        tbVeiculos.setNumRows(0);

        String query = "";
        
        query = "select * from veiculo order by nome_Modelo;";

        try {

            banco.iniciaConexao();
            results = banco.statement.executeQuery(query);
            while (results.next()) {
                tbVeiculos.addRow(new Object[]{
                    results.getString("id_Veiculo"),
                    results.getString("nome_Modelo"),
                    results.getString("nome_Marca"),
                    results.getString("placa"),
                    results.getString("ano"),
                    results.getString("preco"),
                    results.getString("sigla_Estado"),
                    results.getString("nome_loja")
                });
            }
        } catch (Exception e3) {
            JOptionPane.showMessageDialog(null, "Erro ao executar instrução listar veiculos \nMais detalhes: \n" + e3.getMessage());
        }
        banco.finalizaConexao();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cadastro_Veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro_Veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro_Veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro_Veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro_Veiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableVeiculos;
    private javax.swing.JList<String> jlistEstado;
    private javax.swing.JList<String> jlistLoja;
    private javax.swing.JList<String> jlist_Marca;
    private javax.swing.JList<String> jlist_modelo;
    // End of variables declaration//GEN-END:variables
}
