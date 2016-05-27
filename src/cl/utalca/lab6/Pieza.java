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
class Pieza implements Comparable<Pieza> , Serializable{
    
    private String nombrePieza;
    private int periodicidad;
    private int holgura;
    private ArrayList<Mantencion>  mantenciones ;
     
   
   

    public Pieza(String nombrePieza, int periodicidad, int holgura) {
        this.nombrePieza = nombrePieza;
        this.periodicidad = periodicidad;
        this.holgura = holgura;
        this.mantenciones = new ArrayList<Mantencion>();
        
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }

    public int getHolgura() {
        return holgura;
    }

    public void setHolgura(int holgura) {
        this.holgura = holgura;
    }

    
     private int sizeMantenciones() {
        return mantenciones.size();
    }
    
    public String  fechaMantencion()
    {
      int cantidad = sizeMantenciones();
      Mantencion mantencion = mantenciones.get(cantidad - 1);
        if (mantencion != null)
        {
             String fecha = OperacionesFecha.obtenerFechaFormateada(mantencion.proximaFechaMantencion(periodicidad) , "dd/MM/yyyy" );
            return fecha;
        }
        return "No hay registro de mantenciones";
    }

    public boolean addMantencion(Mantencion mantencion)
    {
        return this.mantenciones.add(mantencion);
    }

    public void mostrar()
    {
        System.out.println("Nombre del componente: " +  nombrePieza                         );
        System.out.println("Periodicidad de la mantencion: " +  periodicidad                  );
        System.out.println("Holgura en dias antes de la falla: " + holgura                  );
        for (Mantencion mantencion : mantenciones)
        {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("\tMantenciones realizadas a la maquinaria                      |");
            System.out.println("---------------------------------------------------------------");
            mantencion.mostrar();                                       
        }
        //System.out.println("fecha de la proxima mantencion: " +  fechaMantencion()              );
    
    }

    @Override
    public int compareTo(Pieza o)
    {
        return (int) (this.holgura - o.getHolgura());
    }
}
