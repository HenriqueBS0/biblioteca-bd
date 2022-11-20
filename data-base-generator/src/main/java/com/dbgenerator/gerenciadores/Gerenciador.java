package com.dbgenerator.gerenciadores;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbgenerator.conexao.Conexao;
import com.dbgenerator.estruturas.BaseDados;
import com.dbgenerator.estruturas.Tabela;
import com.dbgenerator.gerenciadores.montadores.interfaces.IFabricaMontadoresEstruturas;
import com.dbgenerator.gerenciadores.montadores.interfaces.IMontadorBaseDados;
import com.dbgenerator.gerenciadores.montadores.interfaces.IMontadorTabela;


/**
 * Classe responsável por manipular o banco de dados
 * 
 * @author henrique.10agr@gmail.com
 */
public class Gerenciador {

    private IFabricaMontadoresEstruturas fabricaMontadoresEstruturas;
    private String jdbcDriver;
    private String jdbcUrl;

    /** 
     * @return IFabricaMontadoresEstruturas
     */
    public IFabricaMontadoresEstruturas getFabricaMontadoresEstruturas() {
        return this.fabricaMontadoresEstruturas;
    }

    
    /** 
     * @param fabricaMontadoresEstruturas
     */
    public void setFabricaMontadoresEstruturas(IFabricaMontadoresEstruturas fabricaMontadoresEstruturas) {
        this.fabricaMontadoresEstruturas = fabricaMontadoresEstruturas;
    }

    
    /** 
     * @return String
     */
    public String getJdbcDriver() {
        return this.jdbcDriver;
    }

    
    /** 
     * @param jdbcDriver
     */
    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    
    /** 
     * @return String
     */
    public String getJdbcUrl() {
        return this.jdbcUrl;
    }

    
    /** 
     * @param jdbcUrl
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }


    
    /** 
     * Retorna o sql que cria a base de dados
     * @param baseDados
     * @return String
     */
    public String getSql(BaseDados baseDados) {
        return String.join("\n\n", getArrayComandos(baseDados));
    }

    
    /** 
     * Cria a base de dados
     * @param conexao
     * @param baseDados
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void executar(Conexao conexao, BaseDados baseDados) throws ClassNotFoundException, SQLException {
        Connection connection = Conexao.get(conexao, getJdbcDriver(), getJdbcUrl());
        Statement statement = connection.createStatement();

        connection.setAutoCommit(false);

        for (String comando : getArrayComandos(baseDados)) {
            statement.addBatch(comando);
        }

        statement.executeBatch();

        connection.commit();
        connection.close();
    }

    
    /** 
     * Retorna uma lista com todos os comandos sql que serão executados para gerar a base de dados
     * @param baseDados
     * @return ArrayList<String>
     */
    private ArrayList<String> getArrayComandos(BaseDados baseDados) {
        ArrayList<String> comandos = new ArrayList<String>();

        IMontadorBaseDados montadorBaseDados = getFabricaMontadoresEstruturas().montadorBaseDados();
        IMontadorTabela montadorTabela = getFabricaMontadoresEstruturas().montadorTabela();

        comandos.add(montadorBaseDados.getSql(baseDados));

        for (Tabela tabela : baseDados.tabelas) {
            comandos.add(montadorTabela.getSql(baseDados, tabela));
        }

        return comandos;
    }

}
