
/**
 * Clase Biblioteca
 * 
 * @author (Coutinho Martin, Coronel Ismael, Garrido Santiago) 
 * @version (1.0)
 */
import java.util.*;

public class Biblioteca
{
    private String nombre;
    private ArrayList <Libro> libros;
    private ArrayList <Socio> socios;

    /**
     * Constructor clase Biblioteca (sobrecargado)
     */
    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        this.setSocios(new ArrayList<Socio>());
    }

    /**
     * Constructor clase Biblioteca (sobrecargado)
     */
    public Biblioteca(String p_nombre, ArrayList <Libro> p_libros, ArrayList <Socio> p_socios){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(p_socios);
    }

    /**
     * Constructor clase Biblioteca (sobrecargado)
     */
    public Biblioteca(String p_nombre, Libro p_libro, Socio p_socio){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        this.setSocios(new ArrayList<Socio>());
        this.addLibro(p_libro);
        this.addSocio(p_socio);
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setLibros(ArrayList p_libros){
        this.libros = p_libros;
    }

    private void setSocios(ArrayList p_socios){
        this.socios = p_socios;
    }

    public String getNombre(){
        return this.nombre;   
    }

    public ArrayList <Libro> getLibros(){
        return this.libros;   
    }

    public ArrayList <Socio> getSocios(){
        return this.socios;   
    }

    public boolean addLibro(Libro p_libro){
        return this.getLibros().add(p_libro);   
    }

    public boolean removeLibro(Libro p_libro){
        return this.getLibros().remove(p_libro);   
    }

    public boolean addSocio(Socio p_socio){
        return this.getSocios().add(p_socio);   
    }

    public boolean removeSocio(Socio p_socio){
        return this.getLibros().remove(p_socio);   
    }

    /**
     * Crea un nuevo libro y lo agrega al ArrayList
     */
    public void nuevoLibro(String p_titulo,int p_edicion,String p_editorial,int p_anio){
        Libro libro=new Libro( p_titulo, p_edicion, p_editorial, p_anio);
        this.addLibro(libro);
    }

    /**
     * Crea un estudiante y lo agrega al ArrayList
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre,String p_carrera){
        Estudiante estudiante = new Estudiante(p_dniSocio,p_nombre,p_carrera);
        this.addSocio(estudiante);

    }

    /**
     * Crea un docente y lo agrega al ArrayList
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre,String p_area){
        Docente docente = new Docente(p_dniSocio,p_nombre,p_area);
        this.addSocio(docente);

    }

    /**
     * Devuelve la cantidad de socios de un tipo
     */
    public int cantidadDeSociosPorTipo(String p_tipo){
        int cant = 0;
        for(Socio s : this.getSocios()){
            if(s.soyDeLaClase().equals(p_tipo)){
                cant += 1;
            }
        }

        return cant;
    }

    /**
     * Verifica si existe el socio y el libro y le agrega un prestamo
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio,p_libro);
            //Verifica si puede pedir un prestamo o si el libro ya esta prestado
            if(p_socio.puedePedir() && !p_libro.prestado()){
                p_socio.addPrestamo(prestamo);
                p_libro.addPrestamo(prestamo); 
                return true;
                
            }else{
                System.out.println("El socio no puede pedir o el Libro esta prestado");
                return false;
            }
    }

    /**Método devolverLibro que verifica si el libro fue prestado, en caso de ser así asigna la fecha de Devolución al prestamo.
     * @Param p_libro de tipo Libro
     */

    public void  devolverLibro(Libro p_libro){
        Calendar fechaDevolucion= Calendar.getInstance();
        if(p_libro.prestado()==true){
            p_libro.getPrestamo().registrarFechaDevolucion(fechaDevolucion);
        }
    }

    /**Método el cual verifica el vencimiento de los prestamos de la coleccion de Socios
     * @return Una coleccion con todos los prestamos vencidos
     */
    public ArrayList<Prestamo> prestamosVencidos(){
        ArrayList<Prestamo> prestamos= new ArrayList<Prestamo>();
        Calendar fechaHoy= Calendar.getInstance();
        for(int i=0; i<this.getLibros().size();i++){
            if(this.getLibros().get(i).getPrestamo().vencido(fechaHoy)){
                prestamos.add(this.getLibros().get(i).getPrestamo());
            }
        }
        return prestamos;
    }

    /**Verifica los socios docentes responsables, utilizando la collecion de Socios
     * @return Una coleccion de todos los docentes responsables
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> docentesResponsables = new ArrayList<Docente>();
        for(Socio socio: this.getSocios()){
            if(socio.soyDeLaClase().equals("Docente")){
                Docente docenteRes =(Docente)socio;
                docentesResponsables.add(docenteRes);
            }
        }
        return docentesResponsables;
    }

    /**Método que verifica si el libro fue prestado y en caso de ser así devuelvo el nombre del socio que lo posee;
     * @return un dato de Tipo String con el nombre del socio
     */
    public String quienTieneElLibro(Libro p_libro){
        if(p_libro.prestado()){
            return p_libro.getPrestamo().getSocio().getNombre();
        }else{
            return "El libro se encuentra en la biblioteca";
        }
    }

    /**Recorre la coleccion de socios devolviendo una lista con sierta información
     */
    public String listaDeSocios(){
        String listaSocios="";
        int i=1;
        for(Socio socio: this.getSocios()){
            listaSocios += i+")"+socio.toString()+"\n";
            i++;
        }
        return listaSocios;
    }

    /**
     * Devuelve una cadena con una lista de libros prestados
     *
     */
    public String listaDeLibros(){
        String listaLibros="";
        int i = 1;
        for(Libro libro: this.getLibros()){
            listaLibros += i+")"+libro.toString()+" || Prestado (";
            if(libro.prestado()){
                listaLibros += "Si)\n";
            }else{
                listaLibros += "No)\n";
            }
            i++;
        }
        return listaLibros;
    }    

    /**
     * Devuelve una cadena con una lista de datos de docentes responsables
     */
    public String listaDeDocentesResponsables(){
        String listaDocResp="";
        if(this.docentesResponsables().isEmpty() == false){
            for(Docente d: this.docentesResponsables()){
                listaDocResp += d.toString();
            }
        }else{
            listaDocResp = "No existen Docentes Responsables";
        }

        return listaDocResp;

    }

    /**
     * Busca y devuelve con Socio por su dni
     */
    public Socio buscarSocio(int p_dni){

        Socio s = null;
        for(Socio socio: this.getSocios()){
            if(socio.getDniSocio() == p_dni){
                s = socio;
            }
        }
        return s;
    }

}