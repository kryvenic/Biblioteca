import java.util.*;
import java.text.*;
/** Clase que permite crear y manipular objetos de tipo Prestamo (representa prestamos de libros).
 * @author Gomez Kevin David 
 */
public class Prestamo{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    
    /** Constructor.   
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
    //setters y getters
    private void setFechaRetiro(Calendar p_fechaRetiro){
        this.fechaRetiro = p_fechaRetiro;
    }
    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion = p_fechaDevolucion;
    }
    private void setSocio(Socio p_socio){
        this.socio = p_socio;
    }
    private void setLibro(Libro p_libro){
        this.libro = p_libro;
    }
    
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    public Socio getSocio(){
        return this.socio;
    }
    public Libro getLibro(){
        return this.libro;
    }
    
    /** Registra la fecha de devolucion del libro.
     * @param Calendar p_fechaDevolucion.
     */ 
    public void registrarFechaDevolucion(Calendar p_fechaDevolucion){
        this.setFechaDevolucion(p_fechaDevolucion);
    }
    
    /** Devuelve true o false pedendiendo si el prestamo esta vencido.
     * @param Calendar p_fecha
     * @return Valor de tipo boolean.
     */
    public boolean vencido(Calendar p_fecha){
        Calendar vencimiento = this.getFechaRetiro();
        vencimiento.add(Calendar.DATE, (this.getSocio().getDiasPrestamo()));
        if(p_fecha.after(vencimiento)){
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Retorna los detalles del prestamo.
     * @return Valor de tipo String.
     */
    public String toString(){
        Date retiro = new Date();
        retiro = (this.getFechaRetiro()).getTime();
        Date devolucion = new Date();
        devolucion = (this.getFechaDevolucion()).getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Retiro: " + formato.format(retiro) + " - Devolucion: " + formato.format(devolucion) + "\nLibro: " + this.getLibro().getTitulo() + "\nSocio: " + this.getSocio().getNombre();
    }
}
