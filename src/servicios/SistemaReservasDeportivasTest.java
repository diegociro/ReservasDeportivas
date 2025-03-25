package servicios;
import entidades.Reserva;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaReservasDeportivasTest {
    private SistemaReservasDeportivas sistema;
    private Reserva reservaValida;
    
    @BeforeEach
    void setUp() {
        sistema = new SistemaReservasDeportivas();
        reservaValida = new Reserva(1, LocalDate.now().plusDays(1), 60);
    }

    @Test
    void testReservarPistaExitosa() {
        assertTrue(sistema.reservarPista(reservaValida));
    }
    
    @Test
    void testReservarPistaOcupada() {
        sistema.reservarPista(reservaValida);
        Reserva reservaConflictiva = new Reserva(1, reservaValida.getFecha(), 30);
        assertFalse(sistema.reservarPista(reservaConflictiva));
    }
    
    @Test
    void testReservarPistaInvalida() {
        Reserva reservaInvalida = new Reserva(-1, LocalDate.now(), 60);
        assertFalse(sistema.reservarPista(reservaInvalida));
    }
    
    @Test
    void testCancelarReservaExistente() {
        sistema.reservarPista(reservaValida);
        assertTrue(sistema.cancelarReserva(reservaValida.getIdPista()));
    }
    
    @Test
    void testCancelarReservaInexistente() {
        assertFalse(sistema.cancelarReserva(999));
    }
    
    @Test
    void testEncenderLucesPistaValida() {
        assertTrue(sistema.encenderLuces(0));
    }
    
    @Test
    void testEncenderLucesPistaInvalida() {
        assertFalse(sistema.encenderLuces(11));
    }
}
