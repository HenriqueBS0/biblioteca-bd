package com.dbgenerator.gerenciadores.montadores.interfaces;

import com.dbgenerator.estruturas.BaseDados;

/**
 * Interface que define o que um montador de base de dados deve retornar
 * 
 * @author henrique.10agr@gmail.com
 */
public interface IMontadorBaseDados {
    public String getSql(BaseDados baseDados);
}
