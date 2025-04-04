package servicios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import entidades.Reserva;
/**
 * gestión de sistema de reservas deportivas.
 * 
 * @author Diego Ciro
 * @version 1.0
 */

public class SistemaReservasDeportivas {


    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10;
    private GestorIluminacion gestorIluminacion;
    
    /** 
     * constructor de esta clase 
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion();
    }
    
    /**
     * Reservamos la pista (asumiento que hay 10 max por ejemplo)
     * @return true reserva exitosa, si no false.
     */

    public boolean reservarPista(Reserva reserva) {
    	//(int Pista, String fecha, int duracion)
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false;
        }
        if (esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            reservas.add(reserva);
            return true;
        }
        return false;
    }
    
    /**
     * Cancela la reserva.
     * @param idReserva: ID de la reserva
     * @return true si la reserva se canceló, si no false.
     */

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
    /**
     * Activa la iluminación de la pista
     * @param idPista: ID de la pista
     * @return true si la iluminación esta encendida, si no false. 
     */

    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }
    
    /**
     * Desactiva la iluminación de una pista específica.
     * @param idPista ID de la pista
     * @return true si la iluminación está apagada, si no false
     */

    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
    
    /**
     * Verifica la disponibilidad de la pista
     *
     * @param idPista: ID de la pista 
     * @param fecha: fecha para la disponibilidad
     * @param hora: hora de la disponibilidad 
     * @return true si la pista esta vacia, si está ocupada false-
     */

    public boolean verificarDisponibilidad(int idPista, LocalDate fecha, LocalDate hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        return esFechaDisponible(idPista, fecha);    }

        private boolean esFechaDisponible(int idPista, LocalDate fecha) {
            for (Reserva r : reservas) {
                if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                    return false;
                }
            }
            return true;
        }

		public BooleanSupplier reservarPista(int i, String string, int j) {
			// TODO Auto-generated method stub
			return null;
		}
}