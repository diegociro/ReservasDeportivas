package servicios;

public class GestorIluminacion {
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10;

    public GestorIluminacion() {
        iluminacion = new boolean[MAX_PISTAS];
    }

    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
}