/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proj_interdisplinar_II;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Luans
 */
public class Banco {
    public Statement statement = null;
    private Connection con = null;
    
    
    public void iniciaConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/teste" + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
            con = DriverManager.getConnection(url, "root", "root");
            statement = con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir conexão \n Mais detalhes :" + e.getMessage());
        }catch(Exception e2){
            System.out.println("Erro ao iniciar conexão. mais detalhes "+ e2.getMessage());
        }
    }
    
    
     public void finalizaConexao() {

        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (Exception ex3) {
            System.out.println("Erro ao fechar conexão :" + ex3.getMessage());

        }
    }
}
