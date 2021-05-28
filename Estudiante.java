
public class Estudiante extends Socio{
    private String carrera;
    
    /**
     * Constructor de la clase estudiante
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera){
        super(p_dniSocio, p_nombre,20); 
        this.setCarrera(p_carrera);
    }

    private void setCarrera(String p_carrera){
        this.carrera = p_carrera;    
    }

    public String getCarrera(){
        return this.carrera;
    }
    
    /**
     * Verifica si es posible o no volver a realizar otro prestamo
     */
    @Override
    public boolean puedePedir(){
        if(super.puedePedir() && getPrestamos().size() <= 3){
            return true;
        }else{
            return false;
        }

    }
    
    /**
     * Devuelve que es un tipo de socio Estudiante 
     */
    public String soyDeLaClase(){
        return "Estudiante";

    }
}

