package com.dbgenerator.gerenciadores.montadores.mysql;

import java.util.ArrayList;

import com.dbgenerator.estruturas.BaseDados;
import com.dbgenerator.estruturas.Coluna;
import com.dbgenerator.estruturas.Tabela;
import com.dbgenerator.gerenciadores.montadores.interfaces.IMontadorTabela;

/**
 * Classe responsável por gerar o sql que cria uma tabela no MySql
 * 
 * @author henrique.10agr@gmail.com
 */
public class MontadorTabelaMySql implements IMontadorTabela {

    
    /** 
     * Retorna o comando que gerá uma tabela no mysql
     * @param baseDados
     * @param tabela
     * @return String
     */
    public String getSql(BaseDados baseDados, Tabela tabela) {
        ArrayList<String> colunas = new ArrayList<String>();

        for (Coluna coluna : tabela.colunas) {
            colunas.add(getSqlCriacaoColunaTabela(coluna));
        }

        String modelo = "CREATE TABLE `{{base-dados-nome}}`.`{{tabela-nome}}` (\n{{colunas}}\n);";

        modelo = modelo.replace("{{base-dados-nome}}", baseDados.nome);
        modelo = modelo.replace("{{tabela-nome}}", tabela.nome);
        modelo = modelo.replace("{{colunas}}", String.join(",\n", colunas));

        return modelo;
    }

    
    /** 
     * Retorna a parte do comando que define um coluna na tabela 
     * @param coluna
     * @return String
     */
    private String getSqlCriacaoColunaTabela(Coluna coluna) {
        String modelo = "{{tabulacao}}`{{coluna-nome}}` {{coluna-tipo}}";

        modelo = modelo.replace("{{tabulacao}}", "   ");
        modelo = modelo.replace("{{coluna-nome}}", coluna.nome);
        modelo = modelo.replace("{{coluna-tipo}}", coluna.tipo);

        StringBuilder colunaStringBuilder = new StringBuilder();

        colunaStringBuilder.append(modelo);

        if(coluna.chavePrimaria) {
            colunaStringBuilder.append(" PRIMARY KEY");
        }
        else if(coluna.naoNula) {
            colunaStringBuilder.append(" NOT NULL");
        }

        if(coluna.serial) {
            colunaStringBuilder.append(" AUTO_INCREMENT");
        }

        return colunaStringBuilder.toString();
    }
}
