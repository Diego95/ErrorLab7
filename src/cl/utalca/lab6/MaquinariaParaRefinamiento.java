/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author universidad
 */
public class MaquinariaParaRefinamiento extends Maquinaria implements Serializable{
    
    /**
     *
     * @param nombre
     * @param componentes
     * @param piezas
     * @param enMantencion
     * @param factorCostoConstante
     */
    private int capacidadRefinamiento;

    public MaquinariaParaRefinamiento( String nombre, int factorCostoConstante, int periodicidad , int capacidadRefinamiento)
    {
        super(nombre, factorCostoConstante, periodicidad);
        this.capacidadRefinamiento = capacidadRefinamiento;
    }

  

    public int getCapacidadRefinamiento()
    {
        return capacidadRefinamiento;
    }

    public void setCapacidadRefinamiento(int capacidadRefinamiento)
    {
        this.capacidadRefinamiento = capacidadRefinamiento;
    }
  
   
    @Override
    public int calcularCosto() {
       
        int costo = (super.factorCostoConstante * capacidadRefinamiento);
        return costo;
    }
    
     public void mostrar()
    {
        super.mostrar();
        System.out.println("Capacidad de refinamiento: " +  capacidadRefinamiento +          "|" );
    }
    
    @Override
    public int compareTo(Maquinaria o)
    {
        return (int) (super.factorCostoConstante - o.getFactorCostoConstante());
    }
    
}
