package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
    // Class Constants
    protected final int COSTO_POR_KM_CORPORATIVO = 900;
    protected final int COSTO_POR_KM_NATURAL = 600;
    protected final double DESCUENTO_GRANDES = 0.2;
    protected final double DESCUENTO_MEDIANAS = 0.1;
    protected final double DESCUENTO_PEQ = 0.02;

    // Class Constructor
    /**
     * Constructor de la clase CalculadoraTarifasTemporadaBaja.
     */
    public CalculadoraTarifasTemporadaBaja() {
        super();
    }

    // Class Methods
    /**
     * Calcula el costo base de un vuelo para un cliente.
     * @param vuelo
     * @param cliente
     * @return costo base del vuelo para el cliente.
     */
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        String tipoCliente = cliente.getTipoCliente();

        if (tipoCliente.equals("Natural")) {
            return distancia * COSTO_POR_KM_NATURAL;

        } else if (tipoCliente.equals("Corporativo")) {
            return distancia * COSTO_POR_KM_CORPORATIVO;

        } else {
            return 0;
        }
    }

    /**
     * Calcula el porcentaje de descuento para un cliente.
     * @param cliente
     * @return porcentaje de descuento para el cliente.
     */
    public double calcularPorcentajeDescuento(Cliente cliente) {
        String tipoCliente = cliente.getTipoCliente();

        if (tipoCliente.equals("Natural")) {
            return DESCUENTO_PEQ;

        } else if (tipoCliente.equals("Corporativo")) {
            return DESCUENTO_GRANDES;

        } else {
            return 0.0;
        }
    }
}
