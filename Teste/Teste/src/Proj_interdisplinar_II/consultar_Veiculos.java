package Proj_interdisplinar_II;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultar_Veiculos extends javax.swing.JFrame {

    public consultar_Veiculos() {
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
                    resultado.getString("id_Veiculo"),
                    resultado.getString("placa"),
                    resultado.getString("ano"),
                    resultado.getString("preco"),
                    resultado.getString("sigla_Estado"),
                    resultado.getString("nome_Loja"),
                    resultado.getString("nome_Marca"),
                    resultado.getString("nome_Modelo"),});
            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("O erro foi " + ex);
        }
    }

    public void Abrir(String sql) {
        try {
            String url = "jdbc:mysql://localhost:3308/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor
        } catch (SQLException ex) {
            System.out.println("O erro foi " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");
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
                "id_Veiculo", "Placa", "Ano", "Preço", "Sigla do Estado", "Nome da Loja", "Nome da Marca", "Nome do Modelo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 790, 250);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_placa.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 20, 150, 70);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_marca.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 20, 150, 70);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_modelo.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(450, 20, 150, 70);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_preco.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(660, 20, 150, 70);

        setSize(new java.awt.Dimension(903, 409));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.PopularJTable("SELECT * FROM veiculo");
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ABERTURA DA CONEXÃO
        Connection con = null;
        Statement statement = null;
        ResultSet results = null;
        PreparedStatement pstm = null;

        //EFETUAR CONSULTA POR PLACA
        try {
            String url = "jdbc:mysql://localhost/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = (Connection) DriverManager.getConnection(url, "root", "root");
            statement = con.createStatement();

            String Placa = JOptionPane.showInputDialog(null, "Digite a placa a ser consultada", "Placa", JOptionPane.INFORMATION_MESSAGE);

            String query = "SELECT * FROM veiculo WHERE veiculo.placa = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, Placa);

            results = pstm.executeQuery(); 
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (results.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    results.getString("id_Veiculo"),
                    results.getString("placa"),
                    results.getString("ano"),
                    results.getString("preco"),
                    results.getString("sigla_Estado"),
                    results.getString("nome_Loja"),
                    results.getString("nome_Marca"),
                    results.getString("nome_Modelo"),});
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(consultar_Veiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // ABERTURA DA CONEXÃO
        Connection con = null;
        Statement statement = null;
        ResultSet results = null;
        PreparedStatement pstm = null;

        //EFETUAR CONSULTA POR MARCA
        try {
            String url = "jdbc:mysql://localhost:3308/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = (Connection) DriverManager.getConnection(url, "root", "");
            statement = con.createStatement();

            String Marca = JOptionPane.showInputDialog(null, "Digite a marca a ser consultada", "Marca", JOptionPane.INFORMATION_MESSAGE);

            String query = "SELECT * FROM veiculo WHERE veiculo.nome_Marca = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, Marca);

            results = pstm.executeQuery(); 
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (results.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    results.getString("id_Veiculo"),
                    results.getString("placa"),
                    results.getString("ano"),
                    results.getString("preco"),
                    results.getString("sigla_Estado"),
                    results.getString("nome_Loja"),
                    results.getString("nome_Marca"),
                    results.getString("nome_Modelo"),});
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(consultar_Veiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // ABERTURA DA CONEXÃO
        Connection con = null;
        Statement statement = null;
        ResultSet results = null;
        PreparedStatement pstm = null;

        //EFETUAR CONSULTA POR MODELO
        try {
            String url = "jdbc:mysql://localhost:3308/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = (Connection) DriverManager.getConnection(url, "root", "");
            statement = con.createStatement();

            String Modelo = JOptionPane.showInputDialog(null, "Digite o modelo a ser consultado", "Modelo", JOptionPane.INFORMATION_MESSAGE);

            String query = "SELECT * FROM veiculo WHERE veiculo.nome_Modelo = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, Modelo);

            results = pstm.executeQuery(); 
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (results.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    results.getString("id_Veiculo"),
                    results.getString("placa"),
                    results.getString("ano"),
                    results.getString("preco"),
                    results.getString("sigla_Estado"),
                    results.getString("nome_Loja"),
                    results.getString("nome_Marca"),
                    results.getString("nome_Modelo"),});
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(consultar_Veiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // ABERTURA DA CONEXÃO
        Connection con = null;
        Statement statement = null;
        ResultSet results = null;
        PreparedStatement pstm = null;

        //EFETUAR CONSULTA POR FAIXA DE PREÇO
        try {
            String url = "jdbc:mysql://localhost:3308/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = (Connection) DriverManager.getConnection(url, "root", "");
            statement = con.createStatement();

            float menorPreco = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor mínimo do veículo a ser consultado", "Preço mínimo", JOptionPane.INFORMATION_MESSAGE));
            float maiorPreco = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor máximo do veículo a ser consultado", "Preço máximo", JOptionPane.INFORMATION_MESSAGE));

            String query = "SELECT * FROM veiculo WHERE veiculo.preco BETWEEN ? AND ?";   
            pstm = con.prepareStatement(query);
            pstm.setFloat(1, menorPreco);
            pstm.setFloat(2, maiorPreco);

            results = pstm.executeQuery(); 
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (results.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    results.getString("id_Veiculo"),
                    results.getString("placa"),
                    results.getString("ano"),
                    results.getString("preco"),
                    results.getString("sigla_Estado"),
                    results.getString("nome_Loja"),
                    results.getString("nome_Marca"),
                    results.getString("nome_Modelo"),});
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(consultar_Veiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(consultar_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultar_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultar_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultar_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultar_Veiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
