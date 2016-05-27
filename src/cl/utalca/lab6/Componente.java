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
public class Componente implements Comparable<Componente> ,Serializable
{

    private String nombrePieza;
    private int periodicidad;
    private int holgura;
    private ArrayList<Pieza> piezas;
    private ArrayList<Mantencion> mantenciones;
    private Lector lector;

    public Componente(String nombrePieza, int periodicidad, int holgura)
    {
        this.nombrePieza = nombrePieza;
        this.periodicidad = periodicidad;
        this.holgura = holgura;
        this.piezas = new ArrayList<Pieza>();
        this.mantenciones = new ArrayList<Mantencion>();
        this.lector = new Lector();

    }

    public String getNombrePieza()
    {
        return this.nombrePieza;
    }

    public void setNombrePieza(String nombrePieza)
    {
        this.nombrePieza = nombrePieza;
    }

    public int getPeriodicidad()
    {
        return this.periodicidad;
    }

    public void setPeriodicidad(int periodicidad)
    {
        this.periodicidad = periodicidad;
    }

    public int getHolgura()
    {
        return this.holgura;
    }

    public void setHolgura(int holgura)
    {
        this.holgura = holgura;
    }

    public boolean addPieza(Pieza e)
    {
        return piezas.add(e);
    }

    public boolean removePieza(Pieza o)
    {
        return piezas.remove(o);
    }

    public boolean addMantencion(Mantencion e)
    {
        return mantenciones.add(e);
    }

    public boolean removeMantencion(Mantencion o)
    {
        return mantenciones.remove(o);
    }

    public int sizeMantenciones()
    {
        return mantenciones.size();
    }

    public String fechaMantencion()
    {
        int cantidad = sizeMantenciones();
        Mantencion mantencion = mantenciones.get(cantidad - 1);
        if (mantencion != null)
        {
            String fecha = OperacionesFecha.obtenerFechaFormateada(mantencion.proximaFechaMantencion(periodicidad), "dd/MM/yyyy");
            return fecha;
        }
        return "No hay registro de mantenciones";

    }

    public Pieza listarPiezas(String mensaje)
    {

        System.out.println(mensaje);
        for (int i = 0; i < piezas.size(); i++)
        {
            Pieza pieza = piezas.get(i);
            System.out.printf("%d - %s\n", (i + 1), pieza.getNombrePieza());
        }

        int indice = lector.leerNumero("Ingrese opcion:", 1, piezas.size());
        return piezas.get(indice - 1);
    }

    public Mantencion listarMantenciones(String mensaje)
    {

        System.out.println(mensaje);
        for (int i = 0; i < sizeMantenciones(); i++)
        {
            Mantencion mantencion = mantenciones.get(i);
            System.out.printf("%d - %s\n", (i + 1), mantencion.proximaFechaMantencion(periodicidad));
        }

        int indice = lector.leerNumero("Ingrese opcion:", 1, sizeMantenciones());
        return mantenciones.get(indice - 1);
    }

    public void mostrar()
    {
        System.out.println("Nombre del componente: " + nombrePieza);
        System.out.println("Periodicidad de la mantencion: " + periodicidad);
        System.out.println("Holgura en dias antes de la falla: " + holgura);
        for (Mantencion mantencion : mantenciones)
        {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println(" Mantenciones realizadas a la componetes                       |");
            System.out.println("---------------------------------------------------------------");
            mantencion.mostrar();
        }
        //System.out.println("Fecha de la proxima mantencion: " + fechaMantencion()               );
    }

    @Override
    public int compareTo(Componente o)
    {
        return (int) (this.holgura - o.getHolgura());

    }

}
