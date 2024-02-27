package uniandes.dpoo.aerolinea.modelo;

import java.util.HashMap;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
    private String fecha;
    private Avion avion;
    private Ruta ruta;
    private HashMap<String, Tiquete> tiquetes;

    /**
     * Crea un nuevo objeto de tipo Vuelo
     * @param ruta La ruta que realizará el vuelo
     * @param fecha La fecha del vuelo
     * @param avion El avión que realizará el vuelo
     */
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new HashMap<String, Tiquete>();
    }

    // Class Methods
    /**
     * Retorna la ruta del vuelo
     * @return La ruta del vuelo
     */
    public Ruta getRuta() {
        return this.ruta;
    }

    /**
     * Retorna la fecha del vuelo
     * @return La fecha del vuelo
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * Retorna el avión del vuelo
     * @return El avión del vuelo
     */
    public Avion getAvion() {
        return this.avion;
    }

    /**
     * Retorna los tiqutes del vuelo
     * @return Los tiquetes del vuelo
     */
    public HashMap<String, Tiquete> getTiquetes() {
        return this.tiquetes;
    }

    /**
     * Vende un tiquete para el vuelo
     * @param tiquete El tiquete que se va a vender
     */
    public void venderTiquete(Tiquete tiquete) throws VueloSobrevendidoException {
        if (tiquetes.size() >= avion.getCapacidad()) {
            throw new VueloSobrevendidoException(this);
        } else {
            tiquetes.put(tiquete.getCodigo(), tiquete);
        }
    }

    /**
     * Equals method
     * @param object El objeto con el que se va a comparar
     * @return Si el objeto es igual al vuelo
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Vuelo) {
            Vuelo vuelo = (Vuelo) object;
            return vuelo.getFecha().equals(this.fecha) && vuelo.getRuta().equals(this.ruta);
        } else {
            return false;
        }
    }
}
