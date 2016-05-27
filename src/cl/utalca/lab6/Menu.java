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
public class Menu
{
   
    public static void mostrarMenuPrincipal()
    {
        System.out.println("---------------------------------------------------------------");
        System.out.println("  Bienvenido al sistema                                        |");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Opciones                                                       |");
        System.out.println("1. Registrar una maquinaria.                                   |" );
        System.out.println("2. Listar todas las maquinarias.                               |");
        System.out.println("3. Eliminar una maquinaria.                                    |");
        System.out.println("4. Modificar una maquinaria.                                   |");
        System.out.println("5. Registrar una nueva mantencion a una maqunaria.             |");
        System.out.println("6. Registrar componentes o piezas de una maqunaria.            |");
        System.out.println("7. Registrar piezas a un componente.                           |");
        System.out.println("8. Emitir resumen de costos de detencion de las maquinarias.   |");
        System.out.println("0. Salir.                                                      |");
        System.out.println("---------------------------------------------------------------");
        
    }
    
    
     public static void mostrarSubMenuMaquinaria(String mensaje)
    {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + mensaje                                                    );
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Vehiculo liviano.                                           |" );
        System.out.println("2. Vehiculo pesado.                                            |");
        System.out.println("3. Maquinaria para explotacion.                                |");
        System.out.println("4. Maquinaria para refinamiento.                               |");
        System.out.println("0. Atras.                                                      |");
        System.out.println("---------------------------------------------------------------"); 
    }
     
     
      public static void mostrarSubMenuModificarVehiculoLiviano(String mensaje)
    {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + mensaje                                                   );
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Nombre del vehiculo.                                        |");
        System.out.println("2. Factor de costo de detencion.                               |");
        System.out.println("0. Atras.                                                      |");
        System.out.println("---------------------------------------------------------------"); 
    }
      
       public static void mostrarSubMenuModificarVehiculoPesado(String mensaje)
    {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + mensaje                                                   );
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Nombre del vehiculo.                                        |" );
        System.out.println("2. Factor de costo de detencion.                               |");
        System.out.println("3. Capacidad de carga del vehiculo                             |");
        System.out.println("0. Atras.                                                      |");
        System.out.println("---------------------------------------------------------------"); 
    }
       
     public static void mostrarSubMenuModificarMaqinariaExplotacion(String mensaje)
    {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + mensaje                                                   );
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Nombre del vehiculo.                                        |" );
        System.out.println("2. Factor de costo de detencion.                               |");
        System.out.println("3. Capacidad de explotacion de la maquinaria.                  |");
        System.out.println("0. Atras.                                                      |");
        System.out.println("---------------------------------------------------------------"); 
    }
     
     
    public static void mostrarSubMenuModificarMaqinariaRefinamiento(String mensaje)
    {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + mensaje                                                   );
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Nombre del vehiculo.                                        |" );
        System.out.println("2. Factor de costo de detencion.                               |");
        System.out.println("3. Capacidad de refinamiento de la maquinaria.                 |");
        System.out.println("0. Atras.                                                      |");
        System.out.println("---------------------------------------------------------------"); 
    }
    
    public static void mostrarSubMenuMantencion(String mensaje)
    {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + mensaje                                                   );
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Maquinaria.                                                 |" );
        System.out.println("2. Componente.                                                 |");
        System.out.println("3. Pieza.                                                      |");
        System.out.println("4. Pieza dentro de componente.                                 |");
        System.out.println("0. Atras.                                                      |");
        System.out.println("---------------------------------------------------------------"); 
    }
}
