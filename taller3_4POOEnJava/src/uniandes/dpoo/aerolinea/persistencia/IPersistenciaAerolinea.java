package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {

    /**
     * Carga la información de la aerolínea desde un archivo y actualiza la estructura de objetos que se encuentra dentro de la aerolínea.
     * @param archivo
     * @throws IOException
     * @throws InformacionInconsistenteException
     */
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException;

    /**
     * Salva en un archivo toda la información sobre la aerolínea.
     * @param archivo
     * @throws IOException
     */
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException;
}
