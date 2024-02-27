package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente {
    // Class Constants
    public static final String CORPORATIVO = "Corporativo";
    public static final int GRANDE = 1;
    public static final int MEDIANA = 2;
    public static final int PEQUENA = 3;

    // Class Attributes
    private String nombreEmpresa;
    private int tamanoEmpresa;

    // Class Constructor
    /**
     * Crea un nuevo objeto de tipo ClienteCorporativo
     * @param nombreEmpresa El nombre de la empresa
     * @param tamanoEmpresa El tamaño de la empresa
     */
    public ClienteCorporativo( String nombreEmpresa, int tamanoEmpresa ) {
        super();
        this.nombreEmpresa = nombreEmpresa;

        if ( tamanoEmpresa == GRANDE) {
            this.tamanoEmpresa = GRANDE;
        } else if ( tamanoEmpresa == MEDIANA) {
            this.tamanoEmpresa = MEDIANA;
        } else {
            this.tamanoEmpresa = PEQUENA;
        }
    }

    // Class Methods
    /**
     * Retorna el nombre de la empresa
     * @return El nombre de la empresa
     */
    public String getNombreEmpresa( ) {
        return this.nombreEmpresa;
    }

    /**
     * Retorna el tamaño de la empresa
     * @return El tamaño de la empresa
     */
    public int getTamanoEmpresa( ) {
        return this.tamanoEmpresa;
    }

    /**
     * Retorna el tipo de cliente
     * @return El tipo de cliente
     */
    public String getTipoCliente( ) {
        return CORPORATIVO;
    }

    /**
     * Retorna el identificador del cliente
     * @return El identificador del cliente
     */
    public String getIdentificador( ) {
        return this.nombreEmpresa;
    }

    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     *
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}
