package cl.utalca.lab6;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Calendar;

public class Lector
{

    private Scanner scanner;

    public Lector()
    {
        this.scanner = new Scanner(System.in);
    }

    public int leerNumero(String mensaje)
    {
        while (true)
        {
            try
            {
                System.out.print(mensaje + " ");
                int numero = Integer.parseInt(this.scanner.nextLine());
                return numero;
            } catch (Exception e)
            {
                System.out.println("Error, vuelva a intentarlo.");
            }
        }
    }

    public int leerNumero(String mensaje, int minimo, int maximo)
    {
        while (true)
        {
            try
            {
                System.out.print(mensaje + " ");
                int numero = Integer.parseInt(this.scanner.nextLine());
                if (minimo <= numero && numero <= maximo)
                {
                    return numero;
                } else
                {
                    System.out.printf("Valor ingresado no corresponde al intervalo [%d, %d]\n", minimo, maximo);
                }
            } catch (Exception e)
            {
                System.out.println("Error, vuelva a intentarlo.");
            }
        }
    }

    public int leerNumero(String mensaje, int minimo)
    {
        while (true)
        {
            try
            {
                System.out.print(mensaje + " ");
                int numero = Integer.parseInt(this.scanner.nextLine());
                if (minimo <= numero)
                {
                    return numero;
                } else
                {
                    System.out.printf("Valor ingresado no corresponde al intervalo >= %d\n", minimo);
                }
            } catch (Exception e)
            {
                System.out.println("Error, vuelva a intentarlo.");
            }
        }
    }

    public String leerLinea(String mensaje)
    {
        System.out.print(mensaje + " ");
        String linea = this.scanner.nextLine();
        return linea;
    }

    public LocalDate leerFecha(String mensaje)
    {
        System.out.println(mensaje + " ");
        while (true)
        {
            System.out.println("Fecha: "
                    + "------------------------------------------------------------------");
            int dia = leerNumero("Dia: ");
            int mes = leerNumero("Mes: ");
            int anio = leerNumero("Anio: ");
            System.out.println("------------------------------------------------------------------");

            try
            {
                LocalDate fecha = LocalDate.of(anio, mes, dia);
                return fecha;
            } catch (DateTimeException e)
            {
                System.out.println("Fecha arronea, por favor ingresela denuevo");
            }
        }
    }

    public Continuar leerContinuar(String mensaje)
    {
        Continuar[] tipos = Continuar.values();

        System.out.println(mensaje);
        for (int i = 0; i < tipos.length; i++)
        {
            Continuar tipo = tipos[i];
            System.out.printf("%d - %s\n", (i + 1), tipo.getDescripcion());
        }

        int indice = leerNumero("Ingrese opcion:", 1, tipos.length);
        return tipos[indice - 1];
    }
    
     public ComponenteOPieza leerComponenteOPieza(String mensaje)
    {
        ComponenteOPieza[] tipos = ComponenteOPieza.values();
        
        System.out.println(mensaje);
        for(int i = 0 ; i < tipos.length; i++)
        {
            ComponenteOPieza tipo = tipos[i];
            System.out.printf( "%d - %s\n", (i+1), tipo.getDescripcion() );
        }
        
        int indice = leerNumero("Ingrese opcion:" , 1, tipos.length);
        return tipos[indice-1];  
    }
}
