package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
    // Class Attributes
    private Cliente cliente;
    private String codigo;
    private int tarifa;
    private boolean usado;
    private Vuelo vuelo;

    // Class Constructor
    /**
     * Crea un nuevo objeto de tipo Tiquete
     * @param codigo El código del tiquete
     * @param vuelo El vuelo al que está asociado el tiquete
     * @param clienteComprador El ciente que compró el tiquete
     * @param tarifa El valor que se le cobró al cliente por el tiquete
     */
    public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.usado = false;
        this.cliente = clienteComprador;
        this.vuelo = vuelo;
    }

    // Class Methods
    /**
     * Retorna el cliente que compró el tiquete
     * @return El cliente que compró el tiquete
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * Retorna el vuelo al que está asociado el tiquete
     * @return El vuelo al que está asociado el tiquete
     */
    public Vuelo getVuelo() {
        return this.vuelo;
    }

    /**
     * Retorna el código del tiquete
     * @return El código del tiquete
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Retorna la tarifa del tiquete
     * @return La tarifa del tiquete
     */
    public int getTarifa() {
        return this.tarifa;
    }

    /**
     * Retorna si el tiquete ya fue usado
     * @return true si el tiquete ya fue usado
     */
    public boolean esUsado() {
        return this.usado;
    }

        /**
     * Marca el tiquete como usado
     */
    public void marcarComoUsado() {
        this.usado = true;
    }

}
