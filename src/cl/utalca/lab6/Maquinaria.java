/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author universidad
 */
public abstract class Maquinaria implements Comparable<Maquinaria> , Serializable
{

    private String nombre;
    private ArrayList<Componente> componentes;
    private ArrayList<Pieza> piezas;
    private ArrayList<Mantencion> mantenciones;
    int factorCostoConstante;
    private int periodicidad;
    private Lector lector;

    public Maquinaria(String nombre, int factorCostoConstante, int periodicidad)
    {

        this.nombre = nombre;
        this.componentes = new ArrayList<Componente>();
        this.piezas = new ArrayList<Pieza>();
        this.factorCostoConstante = factorCostoConstante;
        this.mantenciones = new ArrayList<Mantencion>();
        this.periodicidad = periodicidad;
        this.lector = new Lector();
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getFactorCostoConstante()
    {
        return factorCostoConstante;
    }

    public void setFactorCostoConstante(int factorCostoConstante)
    {
        this.factorCostoConstante = factorCostoConstante;
    }

    public abstract int calcularCosto();

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

    private int sizeMantenciones()
    {
        return this.mantenciones.size();
    }

    public boolean addMantencion(Mantencion e)
    {
        return mantenciones.add(e);
    }

    public boolean removeMantencion(Mantencion o)
    {
        return mantenciones.remove(o);
    }

    public boolean addComponente(Componente e)
    {
        return componentes.add(e);
    }

    public boolean removeComponente(Componente o)
    {
        return componentes.remove(o);
    }

    public Componente obtenerComponente(String nombre)
    {
        for (Componente componente : componentes)
        {
            if (componente.getNombrePieza().compareTo(nombre) == 0)
            {
                return componente;
            }
        }
        return null;
    }

    public boolean addPieza(Pieza e)
    {
        return piezas.add(e);
    }

    public boolean removePieza(Pieza o)
    {
        return piezas.remove(o);
    }

    public Pieza obtenerPieza(String nombre)
    {
        for (Pieza pieza : piezas)
        {
            if (pieza.getNombrePieza().compareTo(nombre) == 0)
            {
                return pieza;
            }
        }
        return null;
    }

    public Componente listarComponentesMaquinaria(String mensaje)
    {

        System.out.println(mensaje);
        for (int i = 0; i < componentes.size(); i++)
        {
            Componente componente = componentes.get(i);
            System.out.printf("%d - %s\n", (i + 1), componente.getNombrePieza());
        }

        int indice = lector.leerNumero("Ingrese opcion:", 1, componentes.size());
        return componentes.get(indice - 1);
    }

    public Pieza listarPiezasMaquinaria(String mensaje)
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

    public Mantencion listarMantencionesMaquinaria(String mensaje)
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

        System.out.println("Nombre del vehiculo:" + nombre + "|");
        System.out.println("Factor de costo de detencion: " + factorCostoConstante + "|");

        for (Componente componente : componentes)
        {

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("\tComponentes de la maquinaria                                 |");
            System.out.println("---------------------------------------------------------------");
            componente.mostrar();

        }

        for (Pieza pieza : piezas)
        {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("\tPiezas de la maquinaria                                      |");
            System.out.println("---------------------------------------------------------------");
            pieza.mostrar();
        }

        for (Mantencion mantencion : mantenciones)
        {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("\tMantenciones realizadas a la maquinaria                      |");
            System.out.println("---------------------------------------------------------------");
            mantencion.mostrar();
        }
        // System.out.println("Fecha de la proxima mantencion " + fechaMantencion()          );

    }

    public ArrayList<Pieza> copiarPiezas()
    {
        ArrayList<Pieza> ordenar = new ArrayList<Pieza>();

        ordenar = piezas;
        return ordenar;
    }
    
    public void ordenarPiezas()
    {
        Collections.sort(copiarPiezas());
    }
    
     public ArrayList<Componente> copiarComponentes()
    {
        ArrayList<Componente> ordenar = new ArrayList<Componente>();

        ordenar = componentes;
        return ordenar;
    }
    
    public void ordenarComponentes()
    {
        Collections.sort(copiarComponentes());
    }

}
