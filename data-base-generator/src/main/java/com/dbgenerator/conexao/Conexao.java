package com.dbgenerator.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe com as configurações de conexão
 * 
 * @author henrique.10agr@gmail.com
 */
public class Conexao {
    public String host;
    public String port;
    public String user;
    public String pass;

    
    /** 
     * Retorna um objeto para manibulação do banco de dados
     * @param conexao
     * @param jdbcDriver
     * @param jdbcUrl
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection get(Conexao conexao, String jdbcDriver, String jdbcUrl) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);

        String urlConnetion = String.format("%s://%s:%s/", jdbcUrl, conexao.host, conexao.port);

        return DriverManager.getConnection(urlConnetion, conexao.user, conexao.pass);
    }
}
