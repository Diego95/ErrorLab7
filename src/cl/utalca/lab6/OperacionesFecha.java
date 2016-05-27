package cl.utalca.lab6;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author universidad
 */
public class OperacionesFecha
{
    
    /**
     * Retorna un string con la fecha formateada
     * @param fecha Fecha a formatear
     * @param format formato del String
     * @return String con fecha formateada
     */
    public static String obtenerFechaFormateada(LocalDate fecha, String format)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return fecha.format(formatter);
    }
    
    /**
     * Compara si 2 fechas son iguales en dia, mes y año.
     * 
     * @param fecha1 Primera fecha a comparar.
     * @param fecha2 Segunda fecha a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    public static boolean compararFechas(LocalDate fecha1, LocalDate fecha2){
        if (fecha1.getDayOfWeek() != fecha2.getDayOfWeek()){
            return false;
        }
        if (fecha1.getDayOfMonth() != fecha2.getDayOfMonth()){
            return false;
        }
        if (fecha1.getDayOfYear() != fecha1.getDayOfYear()){
            return false;
        }
        
        return true;
    }
}