package com.dbgenerator.gerenciadores;

/**
 * Classe abstrata de um construtor de gerenciador, define quais métodos devem ser implementados
 * para se criar um gerenciador 
 * 
 * @author henrique.10agr@gmail.com
 */
abstract public class ConstrutorGerenciador {

    public Gerenciador gerenciador = new Gerenciador();

    abstract void setFabricaMontadoresEstruturas();
    abstract void setJdbcDriver();
    abstract void setJdbcUrl();
    abstract Gerenciador construir();
}
