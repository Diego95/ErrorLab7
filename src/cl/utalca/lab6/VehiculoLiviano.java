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
public class VehiculoLiviano extends Maquinaria  implements Serializable{

    public VehiculoLiviano(String nombre, int factorCostoConstante, int periodicidad)
    {
        super(nombre, factorCostoConstante, periodicidad);
    }

  public void mostrar()
  {
      super.mostrar();
  }
  
  
    @Override
    public int calcularCosto() {
        return super.factorCostoConstante;
    }
    

   @Override
    public int compareTo(Maquinaria o)
    {
        return (int) (super.factorCostoConstante - o.getFactorCostoConstante());
    }

}
