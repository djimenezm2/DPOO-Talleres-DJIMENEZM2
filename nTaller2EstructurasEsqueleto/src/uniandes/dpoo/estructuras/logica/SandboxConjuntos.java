package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 *
 * Todos los métodos deben operar sobre el atributo arbolCadenas que se declara como un NavigableSet.
 * 
 * El objetivo de usar el tipo NavigableSet es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (TreeSet).
 * 
 * A diferencia de un Set, en un NavigableSet existe una noción de orden que en este caso corresponde al órden lexicográfico.
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxConjuntos
{
    /**
     * Un conjunto (set) de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Por defecto, los elementos del conjunto están ordenados lexicográficamente.
     */
    private NavigableSet<String> arbolCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente
     * @return Una lista con las cadenas ordenadas
     */
    public List<String> getCadenasComoLista( )
    {
        // Cannot be unmodifiable because the list is going to be modified
        List<String> cadenas = new java.util.ArrayList<String>( arbolCadenas ); // Crea una lista con las cadenas del conjunto

        return cadenas; // Retorna la lista con las cadenas
    }

    /**
     * Retorna una lista con las cadenas del conjunto, ordenadas lexicográficamente de mayor a menor.
     * @return Una lista con las cadenas ordenadas de mayor a menor
     */
    public List<String> getCadenasComoListaInvertida( )
    {
        List<String> cadenas = new java.util.ArrayList<String>( arbolCadenas.descendingSet( ) ); // Crea una lista con las cadenas del conjunto invertidas

        return cadenas; // Retorna la lista con las cadenas invertidas
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor en el conjunto de cadenas.
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La primera cadena del conjunto, o null si está vacío.
     */
    public String getPrimera( )
    {
        if ( arbolCadenas.isEmpty( ) ) // Verifica si el conjunto está vacío
        {
            return null; // Retorna null si está vacío
        } else { // Si no está vacío
            return arbolCadenas.first( ); // Retorna la primera cadena del conjunto
        }
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor en el conjunto de cadenas
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La última cadena del conjunto, o null si está vacío.
     */
    public String getUltima( )
    {
        if ( arbolCadenas.isEmpty( ) ) // Verifica si el conjunto está vacío
        {
            return null; // Retorna null si está vacío
        } else { // Si no está vacío
            return arbolCadenas.last( ); // Retorna la última cadena del conjunto
        }
    }

    /**
     * Retorna una colección con las cadenas que hacen parte del conjunto de cadenas y son mayores o iguales a la cadena que se recibe por parámetro
     * @param cadena
     * @return Una colección de cadenas mayores a la cadena dada. Si la cadena hace parte del conjunto, debe hacer parte de la colección retornada.
     */
    public Collection<String> getSiguientes( String cadena )
    {
        return arbolCadenas.tailSet( cadena, true ); // Retorna una colección con las cadenas mayores o iguales a la cadena dada
    }

    /**
     * Retorna la cantidad de valores en el conjunto de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arbolCadenas.size( ); // Retorna la cantidad de cadenas en el conjunto
    }

    /**
     * Agrega un nuevo valor al conjunto de cadenas.
     * 
     * Este método podría o no aumentar el tamaño del conjunto, dependiendo de si el número está repetido o no.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        arbolCadenas.add( cadena ); // Agrega la cadena al conjunto
    }

    /**
     * Elimina una cadena del conjunto de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        arbolCadenas.remove( cadena ); // Elimina la cadena del conjunto
    }

    /**
     * Elimina una cadena del conjunto de cadenas, independientemente de las mayúsculas o minúsculas
     * @param cadena La cadena que se va eliminar, sin tener en cuenta las mayúsculas o minúsculas
     */
    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
        arbolCadenas.removeIf( c -> c.equalsIgnoreCase( cadena ) ); // Elimina la cadena del conjunto sin importar las mayúsculas o minúsculas
    }

    /**
     * Elimina la primera cadena del conjunto
     */
    public void eliminarPrimera( )
    {
        arbolCadenas.pollFirst( ); // Elimina la primera cadena del conjunto
    }

    /**
     * Reinicia el conjunto de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
        arbolCadenas.clear( ); // Limpia el conjunto

        for ( Object objeto : objetos ) // Recorre la lista de objetos
        {
            arbolCadenas.add( objeto.toString( ) ); // Agrega la representación en cadena del objeto al conjunto
        }
    }

    /**
     * Modifica el conjunto de cadenas para que todas las cadenas estén en mayúsculas.
     * 
     * Note que esta operación podría modificar el órden de los elementos dentro del conjunto.
     */
    public void volverMayusculas( )
    {
        TreeSet<String> nuevoArbol = new TreeSet<String>( ); // Crea un nuevo conjunto

        for ( String cadena : arbolCadenas ) // Recorre el conjunto
        {
            nuevoArbol.add( cadena.toUpperCase( ) ); // Agrega la cadena en mayúsculas al nuevo conjunto
        }

        arbolCadenas = nuevoArbol; // Asigna el nuevo conjunto al conjunto original
    }

    /**
     * Construye un árbol de cadenas donde todas las cadenas están organizadas de MAYOR a MENOR.
     */
    public TreeSet<String> invertirCadenas( )
    {
        TreeSet<String> nuevoArbol = new TreeSet<String>( arbolCadenas.descendingSet( ) ); // Crea un nuevo conjunto con las cadenas invertidas

        return nuevoArbol; // Retorna el nuevo conjunto
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del conjunto de cadenas
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro del conjunto
     */
    public boolean compararElementos( String[] otroArreglo )
    {
        for ( String cadena : otroArreglo ) // Recorre el arreglo
        {
            if ( !arbolCadenas.contains( cadena ) ) // Verifica si la cadena no está en el conjunto
            {
                return false; // Retorna false si la cadena no está en el conjunto
            }
        }

        return true; // Retorna true si todas las cadenas están en el conjunto
    }
}
