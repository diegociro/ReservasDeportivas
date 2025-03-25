package entidades;
import java.time.LocalDate;

/**
 * Reservas.
 * 
 * @author Diego Ciro
 * @version 1.0
 */
public class Reserva {
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    /**
     * Constructor de la clase Reserva.
     *
     * @param idPista: ID de la pista
     * @param fecha: Fecha de la reserva
     * @param duracion: Duración de la reserva
     */
    
    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }
    
    /**
     * Obtiene el ID de la pista reservada.
     * @return ID de la pista
     */

    public int getIdPista() {
        return idPista;
    }
    
    /**
     * Obtiene la fecha de su reserva
     * @return Fecha de la reserva
     */

    public LocalDate getFecha() {
        return fecha;
    }
    
    /**
     * Obtiene la duración de la reserva.
     * @return Duración de la reserva
     */

    public int getDuracion() {
        return duracion;
    }
}