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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Respaldar
{
    private final String nombreDelArchivo;
    private final File archivo;

    public Respaldar()
    {
        this.nombreDelArchivo = "datos.txt";
        this.archivo = new File(nombreDelArchivo);
    }

    public void escritura(ArrayList<Maquinaria> maquinarias) throws IOException
    {
        if (!this.archivo.exists()){
            this.archivo.createNewFile();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))){
            out.writeObject(maquinarias);
        }
    }

    public ArrayList<Maquinaria> recuperar() throws IOException, ClassNotFoundException
    {
        if (!this.archivo.exists()){
            return null;
        }
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))){
            return (ArrayList<Maquinaria>)in.readObject();
        }
    }
}
