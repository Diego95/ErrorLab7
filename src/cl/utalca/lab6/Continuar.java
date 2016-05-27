/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

/**
 *
 * @author Diego
 */
public enum Continuar
{
    SI("Si") , NO("No");
    
    private String descripcion;

    private Continuar(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
    
    
}
