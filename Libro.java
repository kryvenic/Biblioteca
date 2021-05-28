
/**
 * Clase que representa a un Libro de la Biblioteca, con sus prestamos y disponibilidad.
 * 
 * @author Nicolás Kryvenki
 * @version 1.0
 */
import java.util.ArrayList;
public class Libro
{
   private String titulo;
   private int edicion;
   private String editorial;    
   private ArrayList <Prestamo> prestamos;
   private int anio;
   
   /**
    * Constructor para un Libro sin préstamos.
    */
   public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
       this.setTitulo(p_titulo);
       this.setEdicion(p_edicion);
       this.setEditorial(p_editorial);
       this.setAnio(p_anio);
       this.setPrestamos(new ArrayList <Prestamo> ());
   }
   
   /**
    * Constructor para un libro con un préstamo.
    */
   public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, Prestamo p_prestamo){
       this.setTitulo(p_titulo);
       this.setEdicion(p_edicion);
       this.setEditorial(p_editorial);
       this.setAnio(p_anio);
       this.setPrestamos(new ArrayList <Prestamo> ());
       this.addPrestamo(p_prestamo);
   }
   
   /**
    * Constructor para un libro con varios préstamos.
    */
   public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList <Prestamo> p_prestamos){
       this.setTitulo(p_titulo);
       this.setEdicion(p_edicion);
       this.setEditorial(p_editorial);
       this.setAnio(p_anio);
       this.setPrestamos(p_prestamos);
   }
   
   //Metodos Setters
   private void setTitulo(String p_titulo){
       this.titulo = p_titulo;
   }
   
   private void setEdicion(int p_edicion){
       this.edicion = p_edicion;
   }
   
   private void setEditorial(String p_editorial){
       this.editorial = p_editorial;
   }
   
   private void setAnio(int p_anio){
       this.anio = p_anio;
   }
   
   private void setPrestamos(ArrayList <Prestamo> p_prestamos){
       this.prestamos = p_prestamos;
   }
   
   //Metodos Getters
   public String getTitulo(){
       return this.titulo;
   }
    
   public int getEdicion(){
       return this.edicion;
   }
    
   public String getEditorial(){
       return this.editorial;
   }
   
   public int getAnio(){
       return this.anio;
   }
   
   /**metodo que devuelve la coleccion de prestamos
     * @return ArrayList<Prestamo> prestamos
     */
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
   
   /**
     * Metodo que devuelve el ultimo elemento de la colección.
    */
   public Prestamo getPrestamo(){
      int longitud = this.getPrestamos().size();
      
       if(this.getPrestamos().isEmpty() == false){
        return (this.getPrestamos().get(longitud - 1));
      }else{
          return null;}
   }
   
   /**
    * Método que agrega un prestamo al Libro.
    */
   public void addPrestamo(Prestamo p_prestamo){
      this.getPrestamos().add(p_prestamo);
   }
   
   /**
    * Metodo que quita uno de los prestamos del libro.
    */
   public void removePrestamo(Prestamo p_prestamo){
       this.getPrestamos().remove(p_prestamo);
   }
   
   /**
    * Metodo que retorna V o F dependiendo de si el libro esta prestado o no.
    */
   public boolean prestado(){
       //si el ArrayList está vacio devuelve false, sino, preguntamos si el ultimo prestamo de este libro es null entonces true, caso contrario false.
       if(this.getPrestamos().isEmpty()){
           return false;
        }else{
            if(this.getPrestamo().getFechaDevolucion()==null){
                return true;
            }else{
                return false;
            }
        }
   }
   
   /**
    * Metodo que imprime el titulo del libro.
    */
   public String toString(){
       return ("Titulo: " + this.getTitulo());
   }
}
