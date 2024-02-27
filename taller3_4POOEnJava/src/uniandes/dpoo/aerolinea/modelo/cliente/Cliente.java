package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
    private List<Tiquete> tiquetesUsados;
    private List<Tiquete> tiquetesSinUsar;


    public Cliente () {
        tiquetesUsados = new ArrayList<Tiquete>();
        tiquetesSinUsar = new ArrayList<Tiquete>();
    }

    public abstract String getTipoCliente();

    public abstract String getIdentificador();

    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }

    public int calcularValorTotalTiquetes() {
        int valorTotal = 0;

        for (Tiquete tiquete : tiquetesUsados) {
            valorTotal += tiquete.getTarifa();
        }

        for (Tiquete tiquete : tiquetesSinUsar) {
            valorTotal += tiquete.getTarifa();
        }

        return valorTotal;
    }

    public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete tiquete : tiquetesSinUsar) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquete.marcarComoUsado();
                tiquetesUsados.add(tiquete);
                tiquetesSinUsar.remove(tiquete);
            }
        }
    }
}
