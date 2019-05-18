/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proj_interdisplinar_II;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author logon
 */
public class cadastro_MarcaModelo extends javax.swing.JFrame {

    /**
     * Creates new form cadastro_Estado
     */
    public cadastro_MarcaModelo() {
        initComponents();
    }

    public void PopularJTable(String sql) {
        try {
            String url = "jdbc:mysql://localhost:3306/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "root");
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (resultado.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultado.getString("nome_Marca"),
                    resultado.getString("nome_Modelo")
                });
            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome da Marca", "Nome do Modelo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 380, 310);

        jButton1.setText("Incluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 40, 100, 25);

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 80, 100, 25);

        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(410, 120, 100, 25);

        setSize(new java.awt.Dimension(574, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.PopularJTable("SELECT * FROM Marca_e_Modelo order by nome_Marca");
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        Statement statement = null;
        try {
            String url = "jdbc:mysql://localhost:3306/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = DriverManager.getConnection(url, "root", "root");
            statement = con.createStatement();

            String marca = JOptionPane.showInputDialog(null,"Digite uma marca: ","Marca",JOptionPane.INFORMATION_MESSAGE);
            String modelo = JOptionPane.showInputDialog(null,"Digite um modelo: ","Modelo",JOptionPane.INFORMATION_MESSAGE);

            String query = "INSERT INTO Marca_e_Modelo (nome_Marca,nome_Modelo) values('" + marca + "','" + modelo + "')";

            int res = statement.executeUpdate(query);

            this.setVisible(false); //this will close frame i.e. NewJFrame

            new cadastro_MarcaModelo().setVisible(true);

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        Statement statement = null;
        try {
            String url = "jdbc:mysql://localhost:3306/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = DriverManager.getConnection(url, "root", "root");
            statement = con.createStatement();

            String cod = JOptionPane.showInputDialog(null,"Digite o nome do modelo para excluir: ","Modelo",JOptionPane.INFORMATION_MESSAGE);

            String query = "Delete from Marca_e_Modelo where nome_Modelo = '"+cod+"'";

            int res = statement.executeUpdate(query);

            this.setVisible(false); //this will close frame i.e. NewJFrame

            new cadastro_MarcaModelo().setVisible(true);

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        Statement statement = null;
        try {
            String url = "jdbc:mysql://localhost:3306/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = DriverManager.getConnection(url, "root", "root");
            statement = con.createStatement();
            
            String cod = JOptionPane.showInputDialog(null,"Digite o modelo do veiculo para alterar: ","Marca",JOptionPane.INFORMATION_MESSAGE);
            
            String marca = JOptionPane.showInputDialog(null,"Digite a nova marca do veiculo: ","Marca",JOptionPane.INFORMATION_MESSAGE);
            String modelo = JOptionPane.showInputDialog(null,"Digite o novo modelo do veiculo: ","Modelo",JOptionPane.INFORMATION_MESSAGE);

            String query = "UPDATE Marca_e_Modelo SET nome_Marca = '"+marca+"', nome_Modelo = '"+modelo+"' WHERE nome_Modelo = '"+cod+"'";

            int res = statement.executeUpdate(query);

            this.setVisible(false); //this will close frame i.e. NewJFrame

            new cadastro_MarcaModelo().setVisible(true);

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(cadastro_MarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro_MarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro_MarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro_MarcaModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro_MarcaModelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
