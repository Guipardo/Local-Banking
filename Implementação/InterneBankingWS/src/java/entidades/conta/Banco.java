/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.conta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Banco {

    private final String uri = "jdbc:mysql://localhost:3306/shoplistBD";
    private final String usuario = "root";
    private final String senha = "clay";
    private Connection conexao;

    public Banco() {
    }

    public void abrirConexao() {
        conexao = this.getConnection();
    }

    public void fecharConexao() {
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(uri, usuario, senha);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Connection conexao() {
        conexao = this.getConnection();
        return conexao;
    }

}
