import java.util.Calendar;

public class Docente extends Socio{
    private String area;
    /**
     * Constructo de la clase docente
     */
    public Docente(int p_dniSocio, String p_nombre, String p_area){
        super(p_dniSocio, p_nombre, 5);
        this.setArea(p_area);
    }

    private void setArea(String p_area){
        this.area = p_area;
    }

    public String getArea(){
        return this.area;
    }

    /**
     * Verifica si el docente es responsable, enfocandose en los vencimientos de los libros prestados a este
     */
    public  boolean esResponsable(){
        Calendar vencimiento= Calendar.getInstance();
        int responsable=1;
        for(Prestamo prest: this.getPrestamos()){
            if(prest.vencido(vencimiento)){
                responsable=0;
            }
        }

        if(responsable==1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * M�todo que agrega dias adicionales a la fecha de entrega del libro en caso de que el docente sea responsable
     */
    public void agregarDiasDePrestamo(int p_dias){
        if(this.esResponsable()){
            this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
        }
    }
    
    /**
     * Devuelve que es un socio de tipo Docente
     */
    public String soyDeLaClase(){
        return "Docente";
    }
}
