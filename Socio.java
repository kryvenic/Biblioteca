import java.util.*;
/** Clase abstracta que nos permite cubrir las caracteristicas basicas de un socio en una biblioteca
 * @author Gomez Kevin David 
 */
public abstract class Socio{
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList <Prestamo> prestamos;
    
    /** Constructor.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList <Prestamo> ());
    }
    
    //setters y getters
    private void setDniSocio(int p_dniSocio){
        this.dniSocio = p_dniSocio;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    public void setDiasPrestamo(int p_diasPrestamo){
        this.diasPrestamo = p_diasPrestamo;
    }
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    
    public int getDniSocio(){
        return this.dniSocio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    
    /** Permite añadir un prestamo.
     * @param Prestamo p_prestamo.
     */
    public  void addPrestamo(Prestamo p_prestamo){
        this.getPrestamos().add(p_prestamo);
        
    }
    
    /** Permite remover un prestamo.
     * @param Prestamo p_prestamo.
     */
    public void removePrestamo(Prestamo p_prestamo){
        this.getPrestamos().remove(p_prestamo);
    }
    
    
    /** Retorna la cantidad de libros prestados que tiene un socio.
     * @return Valor de tipo int.
     */
    public int cantLibrosPrestados(){
        int libros = 0;
        for(Prestamo prestamo : this.getPrestamos()){
            libros++;
        }
        return libros;
    }
    
    /** Retorna los detalles del socio.
     * @return Valor de tipo String.
     */
    public String toString(){
        return "D.N.I.: " + this.getDniSocio() + " || " + this.getNombre() + " (" + this.soyDeLaClase() + 
        ") || Libros Prestados: " + this.cantLibrosPrestados();
    }
    
    /** Retorna la leyenda (Profesor o Alumno) seg�n corresponda.
     * @return Valor de tipo String.
     */
    public abstract String soyDeLaClase();
    
    /** Retorna true o false, pedendiendo si puede pedir o no un prestamo (puede hacerlo si no tiene ninguno vencido).
     * @return Valor de tipo boolean.
     */
    public boolean puedePedir(){
        Calendar hoy = Calendar.getInstance();
        for(Prestamo prestamo : this.getPrestamos()){
            if(prestamo.vencido(hoy)){
                return false;
            }
        }
        return true;
    }
}
