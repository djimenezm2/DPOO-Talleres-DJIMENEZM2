package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{
    // Class Constants
    public final String NATURAL = "Natural";

    // Class Attributes
    private String nombre;

    // Class Constructor
    public ClienteNatural(String nombre) {
        super();
        this.nombre = nombre;
    }

    // Class Methods
    /**
     * Retorna el identificador del cliente
     * @return El identificador del cliente
     */
    public String getIdentificador() {
        return this.nombre;
    }

    /**
     * Retorna el tipo de cliente
     * @return El tipo de cliente
     */
    public String getTipoCliente() {
        return NATURAL;
    }
}
