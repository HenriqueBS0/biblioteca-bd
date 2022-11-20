package com.dbgenerator.estruturas;

/**
 * Classe que abstrai uma estrutura genérica de uma coluna
 * 
 * @author henrique.10agr@gmail.com
 */
public class Coluna {
    public String nome;
    public String tipo; 
    public boolean chavePrimaria;
    public boolean naoNula;
    public boolean serial;
}