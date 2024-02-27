package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
    // Class Constants
    public static final double IMPUESTO = 0.28;

    // Class Constructor
    public CalculadoraTarifas() {
        ;
    }

    // Class Methods
    protected abstract int calcularCostoBase( Vuelo vuelo, Cliente cliente);

    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    /**
     * Calcula la tarifa a pagar por un cliente para un vuelo.
     * @param vuelo
     * @param cliente
     * @return tarifa a pagar por el cliente para el vuelo.
     */
    public double calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        int valorImpuestos = calcularValorImpuestos(costoBase);

        return costoBase - (costoBase * porcentajeDescuento) + valorImpuestos;
    }

    /**
     * Calcula la distancia entre dos aeropuertos en kilómetros usando la fórmula de Haversine.
     * @param ruta
     * @return distancia entre los dos aeropuertos en kilómetros.
     */
    protected int calcularDistanciaVuelo(Ruta ruta) {
        Aeropuerto origen = ruta.getOrigen();
        Aeropuerto destino = ruta.getDestino();

        double lat_origen = Math.toRadians(origen.getLatitud());
        double lon_origen = Math.toRadians(origen.getLongitud());
        double lat_destino = Math.toRadians(destino.getLatitud());
        double lon_destino = Math.toRadians(destino.getLongitud());

        double dlon = lon_destino - lon_origen;
        double dlat = lat_destino - lat_origen;

        // Uso de la fórmula de Haversine para calcular la distancia entre dos puntos en la superficie de la tierra.
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat_origen) * Math.cos(lat_destino) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        return (int) (c * r);
    }

    /**
     * Calcula el valor de los impuestos a pagar por un vuelo.
     * @param costoBase
     * @return valor de los impuestos a pagar.
     */
    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
}
