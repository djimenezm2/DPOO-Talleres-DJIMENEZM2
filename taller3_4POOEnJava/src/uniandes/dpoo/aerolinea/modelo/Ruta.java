package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta {
    // Class Attributes
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String horaSalida;
    private String horaLlegada;
    private String codigoRuta;

    // Class Constructor
    /**
     * Crea un nuevo objeto de tipo Ruta
     * @param origen El aeropuerto de origen
     * @param destino El aeropuerto de destino
     * @param horaSalida La hora de salida
     * @param codigoRuta El código de la ruta
     */
    public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigoRuta = codigoRuta;
    }

    // Class Methods
    /**
     * Retorna el codigo de la ruta
     * @return El código de la ruta
     */
    public String getCodigoRuta() {
        return this.codigoRuta;
    }

    /**
     * Retorna el aeropuerto de origen
     * @return El aeropuerto de origen
     */
    public Aeropuerto getOrigen() {
        return this.origen;
    }

    /**
     * Retorna el aeropuerto de destino
     * @return El aeropuerto de destino
     */
    public Aeropuerto getDestino() {
        return this.destino;
    }

    /**
     * Retorna la hora de salida
     * @return La hora de salida
     */
    public String getHoraSalida() {
        return this.horaSalida;
    }

    /**
     * Retorna la hora de llegada
     * @return La hora de llegada
     */
    public String getHoraLlegada() {
        return this.horaLlegada;
    }

    /**
     * Retorna la duración del vuelo en minutos
     * @return La duración del vuelo en minutos
     */
    public int getDuracion() {
        int horaSalida = Integer.parseInt( this.horaSalida );
        int horaLlegada = Integer.parseInt( this.horaLlegada );

        int minutosSalida = getMinutos( this.horaSalida );
        int minutosLlegada = getMinutos( this.horaLlegada );

        int horas = horaLlegada - horaSalida;
        int minutos = minutosLlegada - minutosSalida;

        if ( minutos < 0 ) {
            minutos += 60;
            horas -= 1;
        }

        return horas * 60 + minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     *
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta ) {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     *
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta ) {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }
}
