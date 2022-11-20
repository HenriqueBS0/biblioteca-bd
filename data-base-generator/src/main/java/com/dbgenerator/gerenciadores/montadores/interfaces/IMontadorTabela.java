package com.dbgenerator.gerenciadores.montadores.interfaces;

import com.dbgenerator.estruturas.BaseDados;
import com.dbgenerator.estruturas.Tabela;

/**
 * Interface que define o que um montador de tabela deve retornar
 * 
 * @author henrique.10agr@gmail.com
 */

public interface IMontadorTabela {
    public String getSql(BaseDados baseDados, Tabela tabela);
}
