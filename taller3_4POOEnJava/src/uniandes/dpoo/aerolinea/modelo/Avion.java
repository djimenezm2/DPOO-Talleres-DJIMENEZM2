package uniandes.dpoo.aerolinea.modelo;

public class Avion {
    // Class Attributes
    private String nombre;
    private int capacidad;

    // Class Constructor
    /**
     * Crea un nuevo objeto de tipo Avion
     * @param nombre El nombre del avión
     * @param capacidad La capacidad del avión
     */
    public Avion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // Class Methods
    /**
     * Retorna el nombre del avión
     * @return El nombre del avión
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Retorna la capacidad del avión
     * @return La capacidad del avión
     */
    public int getCapacidad() {
        return this.capacidad;
    }
}
