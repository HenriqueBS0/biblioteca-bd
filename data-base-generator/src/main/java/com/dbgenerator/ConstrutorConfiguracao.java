package com.dbgenerator;

import com.dbgenerator.conexao.Conexao;
import com.dbgenerator.estruturas.BaseDados;

/**
 * Classe que abstrai as configurações do construtor de base de dados
 * 
 * @author henrique.10agr@gmail.com
 */

public class ConstrutorConfiguracao {
    public String gerenciador;
    public Conexao conexao;
    public BaseDados baseDados;
}