package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {
    // Class Methods
    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException {
        String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
        JSONObject raiz = new JSONObject( jsonCompleto );
        // TODO: Implementar el método
    }

    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
        // TODO Implementar el método
    }
}
