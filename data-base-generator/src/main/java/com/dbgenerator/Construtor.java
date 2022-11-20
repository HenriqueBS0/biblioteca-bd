package com.dbgenerator;

import java.sql.SQLException;

import com.dbgenerator.gerenciadores.ConstrutorGerenciadorMysql;
import com.dbgenerator.gerenciadores.Gerenciador;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe Principal da biblioteca
 * 
 * @author henrique.10agr@gmail.com
 */
public class Construtor {

    ConstrutorConfiguracao configuracao;

    /**
     * Gera uma nova instância da classe
     * @param json json com as configurações do banco de dados
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public Construtor(String json) throws JsonMappingException, JsonProcessingException {
        configuracao = getConfiguracaoFromJson(json);
    }

    
    /** 
     * Converte o json de entrada para um objeto de configurações
     * @param json
     * @return ConstrutorConfiguracao
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    private ConstrutorConfiguracao getConfiguracaoFromJson(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(json, ConstrutorConfiguracao.class);
    }

    
    /** 
     * Retorna a string contendo o sql para a criação da base de dados
     * @return String
     */
    public String getSql() {
        return getGerenciador(configuracao.gerenciador).getSql(configuracao.baseDados);
    }

    
    /** 
     * Cria a base de dados
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void executar() throws ClassNotFoundException, SQLException {
        getGerenciador(configuracao.gerenciador).executar(configuracao.conexao, configuracao.baseDados);
    }

    
    /**
     * Retorna um gerenciador de acordo com o SGBD informado  
     * @param nome nome do gerênciador (mysql)
     * @return Gerenciador
     */
    private Gerenciador getGerenciador(String nome) {
        switch (nome) {
            case "mysql":
                return (new ConstrutorGerenciadorMysql()).construir();
        }

        return null;
    } 
}
