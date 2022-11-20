package com.dbgenerator.gerenciadores.montadores.interfaces;

/**
 * Interface que define os objetos que a fabrica de montadores de estruturas deve retornar
 * 
 * @author henrique.10agr@gmail.com
 */
public interface IFabricaMontadoresEstruturas {
    public IMontadorBaseDados montadorBaseDados();
    public IMontadorTabela montadorTabela();
}
