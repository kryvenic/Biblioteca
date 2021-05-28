
/**
 * Clase ejecutable para la gestión de la Biblioteca Virtual.
 * 
 * @autores Coronel Hipolito, Coutinho, Garrido, Gomez y Kryvenki.
 * @version 1
 */

import java.util.*;
import java.text.*;
public class GestionBiblioteca
{
    public static void main(String [] args){
        Biblioteca biblioteca = new Biblioteca("BIBLIOTECA MARINO");

        String editorial;
        String titulo;
        int edicion;
        int anio;
        char respuesta;
        int dni;
        String carrera;
        String nombre;
        String area;
        Scanner teclado = new Scanner(System.in);
        Estudiante estudiante;
        Docente docente;
        Libro libro;
        int opcion;
        System.out.println("--BIENVENIDO AL SISTEMA DE GESTION DE LA BIBLIOTECA MARINO--");

        do{
            System.out.println("Menu de Opciones: \n 1- Agregar Libro \n 2- Agregar Docente \n 3- Agregar Estudiante \n 4- Prestar Libro \n 5- Devolver Libro \n 6- Cantidad de Socios");
            System.out.print(" 7- Lista docentes responsables \n 8- Lista de socios y libros \n 9- Que socio tiene prestado el libro");
            System.out.print("\nElegir: ");
            opcion = teclado.nextInt();
            switch(opcion){

                case 1:
                System.out.println("--INGRESO DE LIBRO--");
                teclado.nextLine();
                System.out.println("\nIngrese Titulo: ");
                titulo = teclado.next();
                System.out.println("Ingrese Edicion: ");
                edicion = teclado.nextInt();
                System.out.println("Ingrese editorial del libro: ");
                editorial = teclado.next();
                System.out.println("Ingrese aÃ±o del Libro: ");
                anio = teclado.nextInt();
                biblioteca.nuevoLibro(titulo,edicion,editorial,anio);
                break;

                case 2:
                System.out.println("--INGRESO DE DOCENTE--");
                System.out.println("\nIngrese DNI: ");
                dni = teclado.nextInt();
                System.out.println("Ingrese nombre: ");
                nombre = teclado.next();
                teclado.nextLine();
                System.out.println("Ingrese area: ");
                area = teclado.next();
                biblioteca.nuevoSocioDocente(dni,nombre,area);
                break;

                case 3:
                System.out.println("--INGRESO DE ESTUDIANTE--");
                System.out.println("\nIngrese DNI: ");
                dni = teclado.nextInt();
                System.out.println("Ingrese nombre: ");
                nombre = teclado.next();
                System.out.println("Ingrese carrera: ");
                carrera = teclado.next();
                biblioteca.nuevoSocioEstudiante(dni,nombre,carrera);
                break;

                case 4:
                    Calendar fecha = Calendar.getInstance();
                    int i=1, opc=0;
                    System.out.println("--PRESTAR LIBRO--");
                    System.out.println("Seleccione un Socio para continuar: ");
                    for(Socio s: biblioteca.getSocios()){
                        System.out.println(i+") "+s.getNombre());
                        i++;
                    }
                    
                    System.out.println("Elegir: ");
                    opc= teclado.nextInt();
                    
                    Socio socioPrestar= biblioteca.getSocios().get(opc-1);
                    i=1;
                    System.out.println("Seleccione un Libro para continuar: ");
                    for(Libro lib: biblioteca.getLibros()){
                        System.out.println(i+") "+lib.getTitulo());
                        i++;
                    }
                    System.out.println("Elegir: ");
                    opc= teclado.nextInt();
                    
                    Libro libroPrestar= biblioteca.getLibros().get(opc-1);
                    
                    
                    if(biblioteca.prestarLibro(fecha, socioPrestar, libroPrestar)){
                        System.out.println("Prestamo Realizado con Exito");
                    }else{
                        System.out.println("Error! No se pudo realizar el Prestamo");
                    }
                    
                    
                break;

                case 5:
                System.out.println("--DEVOLVER LIBRO--");
                System.out.println("\nIngrese Titulo: ");
                titulo = teclado.next();
                System.out.println("Ingrese Edicion: ");
                edicion = teclado.nextInt();
                System.out.println("Ingrese editorial del libro: ");
                editorial = teclado.next();
                System.out.println("Ingrese año del Libro: ");
                anio = teclado.nextInt();
                libro = new Libro(titulo,edicion,editorial,anio);
                biblioteca.devolverLibro(libro);
                break;

                case 6:

                System.out.println("Cantidad de socios de tipo (Estudiante/Docente):  ");
                String op = teclado.next();
                System.out.println("Cantidad de socios de tipo (" + op + ") = " + biblioteca.cantidadDeSociosPorTipo(op));;
                break;

                case 7:

                System.out.println(biblioteca.listaDeDocentesResponsables());
                break;

                case 8:

                String s_socios = biblioteca.listaDeSocios();
                String s_libros = biblioteca.listaDeLibros();

                //Verifica si el String de socios no es vacio para imprimir
                if(s_socios != ""){
                    System.out.println(s_socios);
                }else{
                    System.out.println("No hay Socios");
                }

                //Verifica si el String de libros no es vacio para imprimir 
                if(s_libros != ""){
                    System.out.println(s_libros);
                }else{
                    System.out.println("No hay Libros");
                }
                break;

                case 9:

                System.out.println("--DATOS DEL LIBRO--");
                System.out.println("\nIngrese Titulo: ");
                titulo = teclado.next();
                System.out.println("Ingrese Edicion: ");
                edicion = teclado.nextInt();
                System.out.println("Ingrese editorial del libro: ");
                editorial = teclado.next();
                System.out.println("Ingrese aÃ±o del Libro: ");
                anio = teclado.nextInt();
                libro = new Libro(titulo,edicion,editorial,anio);
                System.out.println(biblioteca.quienTieneElLibro(libro));
                break;
                default:
                System.out.println("OPCION INVALIDA. INGRESE DE NUEVO");
                break;
            }
            System.out.println("\n * Mas Opciones? (S/N) :");
            respuesta = teclado.next().charAt(0);
        }while(respuesta == 's' || respuesta == 'S');

    }
}
