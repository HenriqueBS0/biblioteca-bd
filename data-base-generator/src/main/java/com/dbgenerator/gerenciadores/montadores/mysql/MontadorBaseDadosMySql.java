package com.dbgenerator.gerenciadores.montadores.mysql;

import com.dbgenerator.estruturas.BaseDados;
import com.dbgenerator.gerenciadores.montadores.interfaces.IMontadorBaseDados;

/**
 * Classe responsável por gerar o sql que cria uma base de dados no MySql
 * 
 * @author henrique.10agr@gmail.com
 */
public class MontadorBaseDadosMySql implements IMontadorBaseDados {
    
    /** 
     * Retorna o comando responsável por gerar a base de dados
     * @param baseDados
     * @return String
     */
    public String getSql(BaseDados baseDados) {        
        String modelo = "CREATE DATABASE `{{base-dados-nome}}`;" ;
        return modelo.replace("{{base-dados-nome}}", baseDados.nome);
    }
}
