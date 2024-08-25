package uniandes.dpoo.estructuras.logica;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.platform.commons.util.CollectionUtils;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> valores = new ArrayList<String>( mapaCadenas.values( ) ); // Se crea una lista con los valores del mapa

        Collections.sort( valores ); // Se ordena la lista

        return valores;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> llaves = new ArrayList<String>( mapaCadenas.keySet( ) ); // Se crea una lista con las llaves del mapa

        Collections.sort( llaves, Collections.reverseOrder( ) ); // Se ordena la lista de mayor a menor

        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        } else {
            List<String> llaves = new ArrayList<String>( mapaCadenas.keySet( ) ); // Se crea una lista con las llaves del mapa
            Collections.sort( llaves ); // Se ordena la lista
            return llaves.get(0);
        }
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        } else {
            List<String> valores = new ArrayList<String>( mapaCadenas.values( ) ); // Se crea una lista con los valores del mapa
            Collections.sort( valores ); // Se ordena la lista
            return valores.get(valores.size()-1);
        }
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        List<String> llaves = new ArrayList<String>( mapaCadenas.keySet( ) ); // Se crea una lista con las llaves del mapa
        List<String> llavesMayusculas = new ArrayList<String>( ); // Se crea una lista vacía para guardar las llaves en mayúsculas

        for (String llave : llaves) { // Se recorre la lista de llaves
            llavesMayusculas.add(llave.toUpperCase()); // Se agrega la llave en mayúsculas a la lista
        }

        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        List<String> valoresDiferentes = new ArrayList<String>( ); // Se crea una lista vacía para guardar los valores diferentes

        for (String valor : mapaCadenas.values()) { // Se recorre la lista de valores
            if (!valoresDiferentes.contains(valor)) {
                valoresDiferentes.add(valor); // Se agrega el valor a la lista si no está
            }
        }

        return valoresDiferentes.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
        mapaCadenas.put(new StringBuilder(cadena).reverse().toString(), cadena); // Se agrega la cadena al mapa
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave); // Se elimina la cadena del mapa
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
        mapaCadenas.remove(new StringBuilder(valor).reverse().toString()); // Se elimina la cadena del mapa
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear(); // Se limpia el mapa

        for (Object objeto : objetos) { // Se recorre la lista de objetos
            agregarCadena(objeto.toString()); // Se agrega la cadena al mapa
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
        Map<String, String> nuevoMapa = new HashMap<String, String>( ); // Se crea un nuevo mapa vacío

        for (String llave : mapaCadenas.keySet()) { // Se recorre la lista de llaves
            nuevoMapa.put(llave.toUpperCase(), mapaCadenas.get(llave)); // Se agrega la llave en mayúsculas al nuevo mapa
        }

        mapaCadenas = nuevoMapa; // Se actualiza el mapa
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        List<String> valores = new ArrayList<String>( mapaCadenas.values( ) ); // Se crea una lista con los valores del mapa

        for (String valor : otroArreglo) { // Se recorre la lista de valores
            if (!valores.contains(valor)) {
                return false; // Si no se encuentra el valor, se retorna false
            }
        }

        return true; // Si se encuentran todos los valores, se retorna true
    }

}
