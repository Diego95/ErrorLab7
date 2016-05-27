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
public class VehiculoPesado extends Maquinaria implements Serializable
{

    private int capacidadCarga;

    public VehiculoPesado( String nombre, int factorCostoConstante, int periodicidad , int capacidadCarga)
    {
        super(nombre, factorCostoConstante, periodicidad);
        this.capacidadCarga = capacidadCarga;
    }

   

    public int getCapacidadCarga()
    {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga)
    {
        this.capacidadCarga = capacidadCarga;
    }
  
    @Override
    public int calcularCosto() {
        return super.factorCostoConstante * capacidadCarga;
    }
    
     public void mostrar()
    {
        super.mostrar();
        System.out.println("Capacidad de carga: " +  capacidadCarga                       );
    }
    
     @Override
    public int compareTo(Maquinaria o)
    {
        return (int) (super.factorCostoConstante - o.getFactorCostoConstante());
    }
}
