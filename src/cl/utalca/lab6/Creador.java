/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class Creador
{

    private Lector lector;
    private Sistema sistema;

    public Creador() throws IOException, ClassNotFoundException
    {
        this.lector = new Lector();
        this.sistema = new Sistema();
    }

    public Maquinaria inicializarVehiculoLivinado()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria: ");
        int factorCostoConstante = lector.leerNumero("Factor constante para el costo de detencion: ");
         int periodicidad = lector.leerNumero("Periodicidad de mantenciones de la maquinaria: ");

        Maquinaria vehiculoLiviano = new VehiculoLiviano(nombre, factorCostoConstante, periodicidad);

        return vehiculoLiviano;
    }

    public Maquinaria inicializarVehiculoPesado()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria");
        int factorCostoConstante = lector.leerNumero("Factor constante para el costo de detencion: ");
        int capacidadCarga = lector.leerNumero("Capacida de carga del vehiculo: ");
         int periodicidad = lector.leerNumero("Periodicidad de mantenciones de la maquinaria: ");

        Maquinaria vehiculoPesado = new VehiculoPesado( nombre, factorCostoConstante , periodicidad , capacidadCarga);

        return vehiculoPesado;
    }

    public Maquinaria inicializarMaquinariaExplotacion()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria");
        int factorCostoConstante = lector.leerNumero("Factor constante para el costo de detencion: ");
        int capacidadExplotacion = lector.leerNumero("Capacida de explotacion de la maquinaria: ");
        int periodicidad = lector.leerNumero("Periodicidad de mantenciones de la maquinaria: ");

        Maquinaria maquinariaExplotacion = new MaquinariaParaExplotacion( nombre, factorCostoConstante, periodicidad , capacidadExplotacion);

        return maquinariaExplotacion;
    }
    
     public Maquinaria inicializarMaquinariaRefinamiento()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria");
        int factorCostoConstante = lector.leerNumero("Factor constante para el costo de detencion: ");
        int capacidadRefinamiento = lector.leerNumero("Capacida de explotacion de la maquinaria: ");
        int periodicidad = lector.leerNumero("Periodicidad de mantenciones de la maquinaria: ");

        Maquinaria maquinariaRefinamiento = new MaquinariaParaRefinamiento( nombre, factorCostoConstante , periodicidad , capacidadRefinamiento);

        return maquinariaRefinamiento;
    }
     
    public Mantencion inicializarMantencion()
    {
        LocalDate fechaInicio = lector.leerFecha("Fecha de inicio de la mantencion: ");
        LocalDate fechaTermino = lector.leerFecha("Fecha de termino de la mantencion: ");
        
        Mantencion mantencion = new Mantencion(fechaInicio , fechaTermino);
        return mantencion;
    }
    
    public Componente inicializarComponente()
    {
        String nombrePieza = lector.leerLinea("Nombre del componente: ");
        int periodicidad = lector.leerNumero("Periodicidad en la mantencion del componente: ");
        int  holgura = lector.leerNumero("Numero de dias despues del periodo de periodicidad antes de que falle el componente: ");
        
        Componente componente = new Componente(nombrePieza , periodicidad , holgura);
        return componente;
    }
    
    public Pieza inicializarPieza()
    {
        String nombrePieza = lector.leerLinea("Nombre de la pieza: ");
        int periodicidad = lector.leerNumero("Periodicidad en la mantencion de la pieza: ");
        int  holgura = lector.leerNumero("Numero de dias despues del periodo de periodicidad antes de que falle la pieza: ");
        
        Pieza pieza = new Pieza(nombrePieza , periodicidad , holgura);
        return pieza;
        
    }

}
