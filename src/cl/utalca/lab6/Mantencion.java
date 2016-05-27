/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

import java.time.LocalDate;

/**
 *
 * @author universidad
 */
public class Mantencion
{

    private LocalDate fechaInicio;
    private LocalDate fechaTermino;

    public Mantencion(LocalDate fechaInicio, LocalDate FechaTermino)
    {
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public LocalDate getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTermino()
    {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate FechaTermino)
    {
        this.fechaTermino = fechaTermino;
    }

    /**
     *
     * @param Fecha
     * @return
     */
    public LocalDate proximaFechaMantencion(int dias)
    {
        return fechaTermino.plusDays(dias);
    }

    public void mostrar()
    {
        
        System.out.println("Fecha de inicio de la mantencion: " + OperacionesFecha.obtenerFechaFormateada(fechaInicio, "dd/MM/yyyy")             );
        System.out.println("Fecha de termino de la mantencion: " + OperacionesFecha.obtenerFechaFormateada(fechaInicio, "dd/MM/yyyy")            );
    }

}
