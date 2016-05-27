/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author universidad
 */
public class Sistema
{

    private ArrayList<Maquinaria> maquinarias;
    private ArrayList<Maquinaria> maquinariasOrdenadas;
    private Respaldar respaldo;
    

    public Sistema() throws IOException, ClassNotFoundException
    {   
         this.respaldo = new Respaldar();
        recuperarDatos();
        this.maquinariasOrdenadas = new ArrayList<Maquinaria>();
    }
    
    public void recuperarDatos() throws IOException, ClassNotFoundException
    {
        
        this.maquinarias = respaldo.recuperar();
        if (maquinarias == null)
        {
           this.maquinarias = new ArrayList<Maquinaria>(); 
           
        }
       
    }
    
    public void datosEscritura() throws IOException
    {
        respaldo.escritura(maquinarias);
    }

    public boolean addMaquinaria(Maquinaria e)
    {
        return maquinarias.add(e);
    }

    public boolean removeMaquinaria(Maquinaria maquina)
    {
        return maquinarias.remove(maquina);
    }

    public Maquinaria obtenerMaquinaria(String nombre)
    {
        for (Maquinaria maquinaria : maquinarias)
        {
            if(maquinaria.getNombre().compareTo(nombre) == 0)
            {
                 return maquinaria;
            } 
        }
        return null;
    }
    
    public  ArrayList<Maquinaria> copiar()
    {
        maquinariasOrdenadas = maquinarias;
        
        return maquinariasOrdenadas;
    }
    public void ordenarMaquinarias()
    {
       Collections.sort(copiar()); 
    }
    

    public void costoDeDetencion()
    {
        for (Maquinaria maquinaria : maquinarias)
        {
            if (maquinaria instanceof VehiculoLiviano)
            {
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("   Costo de detencion del vehiculo liviano                    |");
                System.out.println("---------------------------------------------------------------");
                System.out.println("\t"+maquinaria.getNombre()+" = "+maquinaria.calcularCosto()     );

            } else if (maquinaria instanceof VehiculoPesado)
            {
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("  Costo de detencion vehiculo pesado                          |");
                System.out.println("---------------------------------------------------------------");
                System.out.println("\t"+maquinaria.getNombre()+" = "+maquinaria.calcularCosto()     );
            } else if (maquinaria instanceof MaquinariaParaExplotacion)
            {
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("  Costo de detencion maquinaria para explotacion               |");
                System.out.println("---------------------------------------------------------------");
                System.out.println("\t"+maquinaria.getNombre()+" = "+maquinaria.calcularCosto()   );
            } else
            {
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("  Costo de detencion maquinaria para refinamiento             |");
                System.out.println("---------------------------------------------------------------");
                System.out.println("\t"+maquinaria.getNombre()+" = "+maquinaria.calcularCosto()   );
            }

            System.out.println("---------------------------------------------------------------");
        }
    }

    public void mostrarMaquinarias()
    {
        for (Maquinaria maquinaria : maquinarias)
        {
            if (maquinaria instanceof VehiculoLiviano)
            {
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("\t Vehiculos livianos"                                           );
                System.out.println("---------------------------------------------------------------");
                maquinaria.mostrar();

            } else if (maquinaria instanceof VehiculoPesado)
            {
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("\t Vehiculos pesados"                                            );
                System.out.println("---------------------------------------------------------------");
                maquinaria.mostrar();
            } else if (maquinaria instanceof MaquinariaParaExplotacion)
            {
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("\t Maquinarias para explotacion"                                );
                System.out.println("---------------------------------------------------------------");
                maquinaria.mostrar();
            } else
            {
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("\t Maquinarias para refinamiento"                              );
                System.out.println("---------------------------------------------------------------");
                maquinaria.mostrar();
            }

            System.out.println("---------------------------------------------------------------");
        }
    }
    

}
