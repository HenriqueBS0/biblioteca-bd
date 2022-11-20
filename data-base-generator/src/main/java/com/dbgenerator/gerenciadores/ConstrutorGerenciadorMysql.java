package com.dbgenerator.gerenciadores;

import com.dbgenerator.gerenciadores.montadores.mysql.FabricaMontadoresEstruturasMySql;

/**
 * Classe que constrói um gerenciador mysql
 * 
 * @author henrique.10agr@gmail.com
 */
public class ConstrutorGerenciadorMysql extends ConstrutorGerenciador {

    public void setFabricaMontadoresEstruturas() {
        gerenciador.setFabricaMontadoresEstruturas(new FabricaMontadoresEstruturasMySql());
    }

    public void setJdbcDriver() {
        gerenciador.setJdbcDriver("com.mysql.cj.jdbc.Driver");
    }

    public void setJdbcUrl() {
        gerenciador.setJdbcUrl("jdbc:mysql");
    }

    
    /** 
     * @return Gerenciador
     */
    public Gerenciador construir() {
        setFabricaMontadoresEstruturas();
        setJdbcDriver();
        setJdbcUrl();
        return gerenciador;
    }   
}
