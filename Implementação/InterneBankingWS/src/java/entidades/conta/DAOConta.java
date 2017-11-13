/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.conta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class DAOConta implements DAOGenerico<Conta> {

    private boolean resposta;
    private String sql;
    private int contador;

    public DAOConta() {
    }

    @Override
    public boolean criar(Conta conta) {
        resposta = false;
        contador = 0;
        Banco banco = new Banco();

        sql = "INSERT INTO conta (numero,agencia,saldo,titular,senha) values (?,?,?,?,?);";
        try {
            PreparedStatement pst = banco.conexao().prepareStatement(sql);
            pst.setInt(1, conta.getNumero());
            pst.setInt(2, conta.getAgencia());
            pst.setDouble(3, conta.getSaldo());
            pst.setString(4, conta.getTitular());
            pst.setString(5, conta.getSenha());

            contador = pst.executeUpdate();
            resposta = (contador > 0);
            banco.fecharConexao();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resposta;
    }

    @Override
    public Conta ler(int id) {
        Conta conta = new Conta();
        Banco banco = new Banco();
        sql = "SELECT FROM conta WHERE numero='?';";
        try {
            PreparedStatement pst = banco.conexao().prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                conta.setNumero(resultado.getInt("numero"));
                conta.setAgencia(resultado.getInt("agencia"));
                conta.setSaldo(resultado.getDouble("saldo"));
                conta.setTitular(resultado.getString("titular"));
                conta.setSenha(resultado.getString("senha"));
            }
            banco.fecharConexao();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conta;
    }

    @Override
    public List<Conta> lerTodos() {
        List<Conta> listaContas = new ArrayList<>();
        Banco banco = new Banco();
        sql = "SELECT * FROM conta;";
        try {
            PreparedStatement pst = banco.conexao().prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Conta conta = new Conta();
                conta.setNumero(resultado.getInt("numero"));
                conta.setAgencia(resultado.getInt("agencia"));
                conta.setSaldo(resultado.getDouble("saldo"));
                conta.setTitular(resultado.getString("titular"));
                conta.setSenha(resultado.getString("senha"));
                listaContas.add(conta);
            }
            banco.fecharConexao();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaContas;
    }

    @Override
    public Conta lerPorNome(String nome) {
        Conta conta = new Conta();
        Banco banco = new Banco();
        sql = "SELECT FROM conta WHERE titular='?';";
        try {
            PreparedStatement pst = banco.conexao().prepareStatement(sql);
            pst.setString(1, nome);

            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                conta.setNumero(resultado.getInt("numero"));
                conta.setAgencia(resultado.getInt("agencia"));
                conta.setSaldo(resultado.getDouble("saldo"));
                conta.setSenha(resultado.getString("senha"));
                conta.setTitular(nome);
            }
            banco.fecharConexao();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conta;
    }

    @Override
    public boolean atualizar(Conta conta) {
        resposta = false;
        contador = 0;
        Banco banco = new Banco();

        sql = "UPDATE conta SET agencia='?',saldo='?',titular='?',senha='?' WHERE numero='?';";
        try {
            PreparedStatement pst = banco.conexao().prepareStatement(sql);
            pst.setInt(1, conta.getAgencia());
            pst.setDouble(2, conta.getSaldo());
            pst.setString(3, conta.getTitular());
            pst.setString(4, conta.getSenha());
            pst.setInt(5, conta.getNumero());

            contador = pst.executeUpdate();
            resposta = (contador > 0);
            banco.fecharConexao();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resposta;
    }

    @Override
    public boolean deletar(Conta conta) {
        resposta = false;
        contador = 0;
        Banco banco = new Banco();

        sql = "DELETE FROM conta WHERE numero='?';";
        try {
            PreparedStatement pst = banco.conexao().prepareStatement(sql);
            pst.setInt(1, conta.getNumero());

            contador = pst.executeUpdate();
            resposta = (contador > 0);
            banco.fecharConexao();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resposta;
    }

    public boolean validarLogin(int numero, int agencia, String senha) {
        resposta = true;
        try {
            Conta conta = this.ler(numero);
            if (conta.getNumero() != numero) {
                resposta = false;
            }
            if (conta.getAgencia() != agencia) {
                resposta = false;
            }
            if (!conta.getSenha().equals(senha)) {
                resposta = false;
            }
        } catch (NullPointerException ex) {
            return false;
        }
        return resposta;
    }

    public Conta login(int numero, int agencia, String senha) {
        Conta conta = new Conta();
        resposta = this.validarLogin(numero, agencia, senha);
        if (resposta) {
            conta = this.ler(numero);
        }
        return conta;
    }

}
