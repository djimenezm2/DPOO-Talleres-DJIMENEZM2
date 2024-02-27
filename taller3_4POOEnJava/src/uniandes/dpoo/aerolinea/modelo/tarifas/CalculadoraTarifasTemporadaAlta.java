package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
    // Class Constants
    public static final int COSTO_POR_KM = 1000;

    // Class Constructor
    public CalculadoraTarifasTemporadaAlta() {
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

        return distancia * COSTO_POR_KM;
    }

    /**
     * Calcula el porcentaje de descuento para un cliente.
     * @param cliente
     * @return porcentaje de descuento para el cliente.
     */
    public double calcularPorcentajeDescuento(Cliente cliente) {
        String tipoCliente = cliente.getTipoCliente();

        if (tipoCliente.equals("Natural")) {
            return 0.1;

        } else if (tipoCliente.equals("Corporativo")) {
            return 0.3;

        } else {
            return 0.0;
        }
    }
}
