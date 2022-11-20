package com.dbgenerator.gerenciadores.montadores.mysql;

import com.dbgenerator.gerenciadores.montadores.interfaces.IFabricaMontadoresEstruturas;
import com.dbgenerator.gerenciadores.montadores.interfaces.IMontadorBaseDados;
import com.dbgenerator.gerenciadores.montadores.interfaces.IMontadorTabela;

/**
 * Classe responsável por criar os montadores de sql do MySql
 * 
 * @author henrique.10agr@gmail.com
 */
public class FabricaMontadoresEstruturasMySql implements IFabricaMontadoresEstruturas {
    
    /** 
     * @return IMontadorBaseDados
     */
    public IMontadorBaseDados montadorBaseDados() {
        return new MontadorBaseDadosMySql();
    }

    
    /** 
     * @return IMontadorTabela
     */
    public IMontadorTabela montadorTabela() {
        return new MontadorTabelaMySql();
    }    
}
