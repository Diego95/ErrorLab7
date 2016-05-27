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
public class MaquinariaParaExplotacion extends Maquinaria implements Serializable
{

    private int capacidadExplotacion;

    public MaquinariaParaExplotacion(String nombre, int factorCostoConstante, int periodicidad, int capacidadExplotacion)
    {
        super(nombre, factorCostoConstante, periodicidad);
        this.capacidadExplotacion = capacidadExplotacion;
    }

    public int getCapacidadExplotacion()
    {
        return capacidadExplotacion;
    }

    public void setCapacidadExplotacion(int capacidadExplotacion)
    {
        this.capacidadExplotacion = capacidadExplotacion;
    }

    @Override
    public int calcularCosto()
    {
        return (super.factorCostoConstante * capacidadExplotacion);
    }

    @Override
    public void mostrar()
    {
        super.mostrar();
        System.out.println("Capacidad de explotacion: " + capacidadExplotacion + "|");
    }

    @Override
    public int compareTo(Maquinaria o)
    {
        return (int) (super.factorCostoConstante - o.getFactorCostoConstante());
    }

}
