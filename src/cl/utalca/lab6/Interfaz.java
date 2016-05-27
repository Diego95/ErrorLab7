/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.utalca.lab6;

import java.io.IOException;

/**
 *
 * @author universidad
 */
public class Interfaz
{

    private Lector lector;
    private Sistema sistema;
    private Creador inicializar;

    public Interfaz() throws IOException, ClassNotFoundException
    {
        this.lector = new Lector();
        this.sistema = new Sistema();
        this.inicializar = new Creador();
    }

    public void iniciarMenuPrincipal() throws IOException
    {
        int opcion = 0;
        do
        {
            Menu.mostrarMenuPrincipal();
            opcion = lector.leerNumero("\nEscoja una opcion: ", 0, 8);

            switch (opcion)
            {
                case 1:
                    iniciarSubMenuMaquinariaAgregar();
                    break;
                case 2:
                    mostrarTodo();
                    break;

                case 3:
                    iniciarSubMenuMaquinariaEliminar();
                    break;
                case 4:
                    iniciarSubMenuMaquinariaModificar();
                    break;
                case 5:
                    registrarMantencion();
                    break;
                case 6:
                    registrarComponentesOPiezas();
                    break;
                case 7:
                    registrarPiezasAComponente();
                    break;
                case 8:
                    sistema.costoDeDetencion();
                    break;
            }

        } while (opcion != 0);
         sistema.datosEscritura();
    }

    public void iniciarSubMenuMaquinariaEliminar() throws IOException
    {
        int opcion = 0;
        do
        {
            Menu.mostrarSubMenuMaquinaria(" ¿Que tipo de maquianria desea eliminar? ");
            opcion = lector.leerNumero("\nEscoja una opcion: ", 0, 4);

            switch (opcion)
            {
                case 1:
                    eliminarUnVehiculoLiviano();
                    break;
                case 2:
                    eliminarrUnVehiculoPesado();
                    break;

                case 3:
                    eliminarUnaMaquinariaExplotacion();
                    break;
                case 4:
                    eliminarUnaMaquinariaRefinamiento();
                    break;
            }

        } while (opcion != 0);
       
    }

    public void iniciarSubMenuMaquinariaAgregar()
    {
        int opcion = 0;
        do
        {
            Menu.mostrarSubMenuMaquinaria(" ¿Que tipo de maquianria desea agregar? ");
            opcion = lector.leerNumero("\nEscoja una opcion: ", 0, 4);

            switch (opcion)
            {
                case 1:
                    registarUnVehiculoLiviano();
                    break;
                case 2:
                    registrarUnVehiculoPesado();
                    break;

                case 3:
                    registrarUnaMaquinariaExplotacion();
                    break;
                case 4:
                    registrarUnaMaquinariaRefinamiento();
                    break;
            }

        } while (opcion != 0);
    }

    public void iniciarSubMenuMaquinariaModificar()
    {
        int opcion = 0;
        do
        {
            Menu.mostrarSubMenuMaquinaria(" ¿Que tipo de maquinaria desea modificar? ");
            opcion = lector.leerNumero("\nEscoja una opcion: ", 0, 4);

            switch (opcion)
            {
                case 1:
                    modificarVehiculoLiviano();
                    break;
                case 2:
                    modificarVehiculoPesado();
                    break;

                case 3:
                    modificarMaquinariaExplotacion();
                    break;
                case 4:
                    modificarMaquinariaRefinamiento();
                    break;
            }

        } while (opcion != 0);
    }

    private void registarUnVehiculoLiviano()
    {
        Maquinaria vehiculo = inicializar.inicializarVehiculoLivinado();
       // Maquinaria encontrada = sistema.obtenerMaquinaria(vehiculo.getNombre());
        //if (encontrada == null)
        //{
            boolean ok = sistema.addMaquinaria(vehiculo);

            if (ok)
            {
                System.out.println("\n Se ha registrado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha registrado correctamente el vehiculo en el sistema.\n");
            }
        //} else
        //{
            //System.out.println("\nEsta maquinaria ya ha sido registrada en el sistema.\n");
        //}

    }

    private void registrarUnVehiculoPesado()
    {
        Maquinaria vehiculo = inicializar.inicializarVehiculoPesado();
        Maquinaria encontrada = sistema.obtenerMaquinaria(vehiculo.getNombre());
        if (encontrada == null)
        {
            boolean ok = sistema.addMaquinaria(vehiculo);

            if (ok)
            {
                System.out.println("\n Se ha registrado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha registrado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria ya ha sido registrada en el sistema.\n");
        }
    }

    private void registrarUnaMaquinariaExplotacion()
    {
        Maquinaria maquinaria = inicializar.inicializarMaquinariaExplotacion();
        Maquinaria encontrada = sistema.obtenerMaquinaria(maquinaria.getNombre());
        if (encontrada == null)
        {
            boolean ok = sistema.addMaquinaria(maquinaria);

            if (ok)
            {
                System.out.println("\n Se ha registrado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha registrado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria ya ha sido registrada en el sistema.\n");
        }
    }

    private void registrarUnaMaquinariaRefinamiento()
    {
        Maquinaria maquinaria = inicializar.inicializarMaquinariaRefinamiento();
        Maquinaria encontrada = sistema.obtenerMaquinaria(maquinaria.getNombre());
        if (encontrada == null)
        {
            boolean ok = sistema.addMaquinaria(maquinaria);

            if (ok)
            {
                System.out.println("\n Se ha registrado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha registrado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria ya ha sido registrada en el sistema.\n");
        }
    }

    private void eliminarUnVehiculoLiviano()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria que dese eliminar: ");
        Maquinaria encontrada = sistema.obtenerMaquinaria(nombre);
        if (encontrada instanceof VehiculoLiviano && encontrada != null)
        {
            boolean ok = sistema.removeMaquinaria(encontrada);

            if (ok)
            {
                System.out.println("\n Se ha eliminado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha eliminado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria NO ha sido registrada en el sistema.\n");
        }
    }

    private void eliminarrUnVehiculoPesado()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria que dese eliminar: ");
        Maquinaria encontrada = sistema.obtenerMaquinaria(nombre);
        if (encontrada instanceof VehiculoPesado && encontrada != null)
        {
            boolean ok = sistema.removeMaquinaria(encontrada);

            if (ok)
            {
                System.out.println("\n Se ha eliminado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha eliminado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria NO ha sido registrada en el sistema.\n");
        }
    }

    private void eliminarUnaMaquinariaExplotacion()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria que dese eliminar: ");
        Maquinaria encontrada = sistema.obtenerMaquinaria(nombre);
        if (encontrada instanceof MaquinariaParaExplotacion && encontrada != null)
        {
            boolean ok = sistema.removeMaquinaria(encontrada);

            if (ok)
            {
                System.out.println("\n Se ha eliminado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha eliminado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria NO ha sido registrada en el sistema.\n");
        }
    }

    private void eliminarUnaMaquinariaRefinamiento()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria que dese eliminar: ");
        Maquinaria encontrada = sistema.obtenerMaquinaria(nombre);
        if (encontrada instanceof MaquinariaParaRefinamiento && encontrada != null)
        {
            boolean ok = sistema.removeMaquinaria(encontrada);

            if (ok)
            {
                System.out.println("\n Se ha eliminado correctamente el vehiculo en el sistema.\n");
            } else
            {
                System.out.println("\nNO se ha eliminado correctamente el vehiculo en el sistema.\n");
            }
        } else
        {
            System.out.println("\nEsta maquinaria NO ha sido registrada en el sistema.\n");
        }
    }

    public void registrarMantencion()
    {
        int opcion;
        do
        {
            Menu.mostrarSubMenuMantencion("¿Donde desea resgistra una mantencion?");
            opcion = lector.leerNumero("\nEscoja una opcion: ");
            switch (opcion)
            {
                case 1:
                    registrarMantencionMaquinaria();
                    break;
                case 2:
                    registrarMantencionComponente();
                    break;
                case 3:
                    registrarMantencionPieza();
                    break;
                case 4:
                    registrarMantencionPiezaAComponente();
                    break;
            }

        } while (opcion != 0);
    }

    public void registrarMantencionMaquinaria()
    {

        Continuar opcion;
        do
        {
            String nombre = lector.leerLinea("Nombre de la maquinaria que quiere registrar una mantencion: ");
            Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
            if (maquinaria != null)
            {
                Mantencion mantencion = inicializar.inicializarMantencion();

                boolean ok = maquinaria.addMantencion(mantencion);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente la mantencion.\n");
                } else
                {
                    System.out.println("\nNO se ha agregado correctamente la mantencion");
                }
            } else
            {
                System.out.println("\nEsta mantencion NO ha sido registrada en el sistema.\n");
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando mantenciones?");

        } while (!"No".equals(opcion.getDescripcion()));
    }

    public void registrarMantencionComponente()
    {

        Continuar opcion;
        do
        {
            String nombre = lector.leerLinea("Nombre de la maquinaria:  ");
            Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
            if (maquinaria != null)
            {
                Componente componente = maquinaria.listarComponentesMaquinaria("¿Elija el componente que desea resgistrar una mantencion?");

                Mantencion mantencion = inicializar.inicializarMantencion();

                boolean ok = componente.addMantencion(mantencion);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente la mantencion.\n");
                } else
                {
                    System.out.println("\nNO se ha agregado correctamente la mantencion");
                }
            } else
            {
                System.out.println("\nEsta mantencion NO ha sido registrada en el sistema.\n");
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando mantenciones?");

        } while (!"No".equals(opcion.getDescripcion()));
    }

    public void registrarMantencionPieza()
    {

        Continuar opcion;
        do
        {
            String nombre = lector.leerLinea("Nombre de la maquinaria:  ");
            Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
            if (maquinaria != null)
            {

                Pieza pieza = maquinaria.listarPiezasMaquinaria("¿Elija la pieza que dese agregar una mantencion?");

                Mantencion mantencion = inicializar.inicializarMantencion();

                boolean ok = pieza.addMantencion(mantencion);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente la mantencion.\n");
                } else
                {
                    System.out.println("\nNO se ha agregado correctamente la mantencion");
                }
            } else
            {
                System.out.println("\nEsta mantencion NO ha sido registrada en el sistema.\n");
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando mantenciones?");
        } while (!"No".equals(opcion.getDescripcion()));
    }

    public void registrarMantencionPiezaAComponente()
    {

        Continuar opcion;
        do
        {
            String nombre = lector.leerLinea("Nombre de la maquinaria:  ");
            Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
            if (maquinaria != null)
            {
                Componente componente = maquinaria.listarComponentesMaquinaria("¿Elija el componente?");

                Pieza pieza = componente.listarPiezas("¿Elija la pieza que dese agregar una mantencion?");

                Mantencion mantencion = inicializar.inicializarMantencion();

                boolean ok = pieza.addMantencion(mantencion);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente la mantencion.\n");
                } else
                {
                    System.out.println("\nNO se ha agregado correctamente la mantencion");
                }
            } else
            {
                System.out.println("\nEsta mantencion NO ha sido registrada en el sistema.\n");
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando mantenciones?");
        } while (!"No".equals(opcion.getDescripcion()));
    }

    public void registrarComponentesOPiezas()
    {
        ComponenteOPieza desicion;
        Continuar opcion;
        do
        {
            desicion = lector.leerComponenteOPieza("¿Que desea agregar?");

            switch (desicion)
            {
                case COMPONENTE:
                    registrarComponente();
                    break;
                case PIEZA:
                    registrarPieza();
                    break;
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando componentes o piezas?");
        } while (!"No".equals(opcion.getDescripcion()));

    }

    public void registrarComponente()
    {
        Continuar opcion;
        do
        {
            String nombre = lector.leerLinea("Nombre de la maquinaria que quiere registrar un componente: ");
            Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
            if (maquinaria != null)
            {
                Componente componente = inicializar.inicializarComponente();

                boolean ok = maquinaria.addComponente(componente);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente el componente.\n");
                } else
                {
                    System.out.println("\nNO se ha agregado correctamente el componente");
                }
            } else
            {
                System.out.println("\nEsta maaquinaria NO ha sido registrada en el sistema.\n");
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando componentes?");

        } while (!"No".equals(opcion.getDescripcion()));
    }

    public void registrarPieza()
    {
        Continuar opcion;
        do
        {
            String nombre = lector.leerLinea("Nombre de la maquinaria o componente que quiere registrar una pieza: ");
            Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
            if (maquinaria != null)
            {
                Pieza pieza = inicializar.inicializarPieza();

                boolean ok = maquinaria.addPieza(pieza);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente la pieza.\n");
                } else
                {
                    System.out.println("\nNO se ha agregado correctamente la pieza");
                }
            } else
            {
                System.out.println("\nEsta mantencion NO ha sido registrada en el sistema.\n");
            }

            opcion = lector.leerContinuar("¿Desea seguir registrando piezas?");

        } while (!"No".equals(opcion.getDescripcion()));
    }

    public void registrarPiezasAComponente()
    {
        String nombre = lector.leerLinea("Nombre de la maquinaria que quiere registrar una pieza a uno desus componentes: ");
        Maquinaria maquinaria = sistema.obtenerMaquinaria(nombre);
        if (maquinaria != null)
        {
            Componente componente = maquinaria.listarComponentesMaquinaria("Elija el componente que quiere registrar una pieza: ");

            if (componente != null)
            {
                Pieza pieza = inicializar.inicializarPieza();
                boolean ok = componente.addPieza(pieza);
                if (ok)
                {
                    System.out.println("\n Se ha registrado correctamente la pieza.\n");
                } else
                {
                }
            } else
            {
                System.out.println("\nNo se ha registrado correctamente la pieza.\n");
            }

        } else
        {
            System.out.println("\nNo se ha encontrado la maquinaria.\n");
        }
    }

    private void mostrarTodo()
    {
        sistema.mostrarMaquinarias();
    }

    public void modificarVehiculoLiviano()
    {
        int opcion;
        do
        {
            Menu.mostrarSubMenuModificarVehiculoLiviano("¿Que desea modificar del vehiculo?");
            opcion = lector.leerNumero("Escoja una opcion: ", 0, 2);

            switch (opcion)
            {
                case 1:
                    modificarNombre();
                    break;
                case 2:
                    modificarFactorCosto();
                    break;
            }

        } while (opcion != 0);
    }

    private void modificarNombre()
    {
        String nombreActual = lector.leerLinea("Nombre actual del vehiculo");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreActual);
        if (vehiculo != null)
        {
            String newNombre = lector.leerLinea("Nuevo nombre del vehiculo");
            vehiculo.setNombre(newNombre);
        } else
        {
            System.out.println("\nNo se encontro la maquinaria");
        }

    }

    private void modificarFactorCosto()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual del vehiculo");
        int factorCosto = lector.leerNumero("Nuevo factor de costo de detencion");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreMaquinaria);
        if (vehiculo != null)
        {
            vehiculo.setFactorCostoConstante(factorCosto);
        } else
        {
            System.out.println("\nNo se modificado el factor de costo de detencion.\n");
        }

    }

    public void modificarVehiculoPesado()
    {
        int opcion;
        do
        {
            Menu.mostrarSubMenuModificarVehiculoPesado("¿Que desea modificar del vehiculo?");
            opcion = lector.leerNumero("Escoja una opcion: ", 0, 3);

            switch (opcion)
            {
                case 1:

                    modificarNombrePesado();
                    break;
                case 2:
                    modificarFactorCostoPesado();
                    break;
                case 3:
                    modificarCapacidadCarga();
                    break;
            }

        } while (opcion != 0);
    }

    private void modificarNombrePesado()
    {
        String nombreActual = lector.leerLinea("Nombre actual del vehiculo");
        String newNombre = lector.leerLinea("Nuevo nombre del vehiculo");

        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreActual);
        if (vehiculo != null)
        {
            vehiculo.setNombre(newNombre);
        } else
        {
            System.out.println("\nNo se modificado el nombre del vehiculo.\n");
        }

    }

    private void modificarFactorCostoPesado()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual del vehiculo");
        int factorCosto = lector.leerNumero("Nuevo factor de costo de detencion");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreMaquinaria);
        vehiculo.setFactorCostoConstante(factorCosto);
    }

    private void modificarCapacidadCarga()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual del vehiculo");
        int capacidadCarga = lector.leerNumero("Nueva capacidad de carga");
        VehiculoPesado vehiculo = (VehiculoPesado) sistema.obtenerMaquinaria(nombreMaquinaria);
        if (vehiculo != null)
        {
            vehiculo.setCapacidadCarga(capacidadCarga);
        } else
        {
            System.out.println("\nNo se modificado la capacidad de carga.\n");
        }

    }

    public void modificarMaquinariaExplotacion()
    {
        int opcion;
        do
        {
            Menu.mostrarSubMenuModificarMaqinariaExplotacion("¿Que desea modificar de la maquinaria?");
            opcion = lector.leerNumero("Escoja una opcion: ", 0, 3);

            switch (opcion)
            {
                case 1:
                    modificarNombreExplotacion();
                    break;
                case 2:
                    modificarFactorCostoExplotacion();
                    break;
                case 3:
                    modificarCapacidadExplotacion();
                    break;
            }

        } while (opcion != 0);
    }

    private void modificarNombreExplotacion()
    {
        String nombreActual = lector.leerLinea("Nombre actual de la maquinaria");
        String newNombre = lector.leerLinea("Nuevo nombre del vehiculo");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreActual);
        if (vehiculo != null)
        {
            vehiculo.setNombre(newNombre);
        } else
        {
            System.out.println("\nNo se modificado el nombre de la maquinaria.\n");
        }

    }

    private void modificarFactorCostoExplotacion()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual de la maquinaria");
        int factorCosto = lector.leerNumero("Nuevo factor de costo de detencion");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreMaquinaria);
        if (vehiculo != null)
        {
            vehiculo.setFactorCostoConstante(factorCosto);
        } else
        {
            System.out.println("\nNo se modificado factor constante de costo de dentencion.\n");
        }

    }

    private void modificarCapacidadExplotacion()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual del vehiculo");
        int capacidadExplotacion = lector.leerNumero("Nueva capacidad de explotacion");
        MaquinariaParaExplotacion maquinaria = (MaquinariaParaExplotacion) sistema.obtenerMaquinaria(nombreMaquinaria);
        if (maquinaria != null)
        {
            maquinaria.setCapacidadExplotacion(capacidadExplotacion);
        } else
        {
            System.out.println("\nNo se modificado la capacidad de explotaicion.\n");
        }

    }

    public void modificarMaquinariaRefinamiento()
    {
        int opcion;
        do
        {
            Menu.mostrarSubMenuModificarMaqinariaRefinamiento("¿Que desea modificar de la maquinaria?");
            opcion = lector.leerNumero("Escoja una opcion: ", 0, 3);

            switch (opcion)
            {
                case 1:
                    modificarNombreRefinamiento();
                    break;
                case 2:
                    modificarFactorCostoRefinamiento();
                    break;
                case 3:
                    modificarCapacidadRefinamiento();
                    break;
            }

        } while (opcion != 0);
    }

    private void modificarNombreRefinamiento()
    {
        String nombreActual = lector.leerLinea("Nombre actual de la maquinaria");
        String newNombre = lector.leerLinea("Nuevo nombre del vehiculo");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreActual);
        if (vehiculo != null)
        {
            vehiculo.setNombre(newNombre);
        } else
        {
            System.out.println("\nNo se ha modificado el nombre de la maquinaria");
        }

    }

    private void modificarFactorCostoRefinamiento()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual de la maquinaria");
        int factorCosto = lector.leerNumero("Nuevo factor de costo de detencion");
        Maquinaria vehiculo = sistema.obtenerMaquinaria(nombreMaquinaria);
        if (vehiculo != null)
        {
            vehiculo.setFactorCostoConstante(factorCosto);
        } else
        {
            System.out.println("\nNo se ha modificado el factor constante de costo de detencion");
        }

    }

    private void modificarCapacidadRefinamiento()
    {
        String nombreMaquinaria = lector.leerLinea("Nombre actual del vehiculo");
        int capacidadRefinamiento = lector.leerNumero("Nueva capacidad de refinaminamiento");
        MaquinariaParaRefinamiento maquinaria = (MaquinariaParaRefinamiento) sistema.obtenerMaquinaria(nombreMaquinaria);
        if (maquinaria != null)
        {
            maquinaria.setCapacidadRefinamiento(capacidadRefinamiento);
        } else
        {
            System.out.println("\nNo se ha modificado la capacidad de refinamiento");
        }

    }
}
