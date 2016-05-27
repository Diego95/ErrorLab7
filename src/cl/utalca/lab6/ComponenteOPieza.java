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
public enum ComponenteOPieza
{
    PIEZA("Pieza"), COMPONENTE("Componente");

    private String Descripcion;

    private ComponenteOPieza(String Descripcion)
    {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion()
    {
        return Descripcion;
    }
}
