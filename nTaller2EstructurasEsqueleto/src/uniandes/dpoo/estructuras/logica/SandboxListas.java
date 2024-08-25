package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private List<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private List<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
        List<Integer> copia = new ArrayList<Integer>( listaEnteros ); // Crea una lista con los enteros de la lista

        return copia;
    }

    /**
     * Retorna una copia de la lista de cadenas, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
        List<String> copia = new LinkedList<String>( listaCadenas ); // Crea una lista con las cadenas de la lista

        return copia;
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros, es decir un arreglo del mismo tamaño que contiene copias de los valores de la lista
     * @return Una arreglo de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
        int[] arreglo = new int[ this.listaEnteros.size( ) ]; // Crea un arreglo con los enteros de la lista

        for( int i = 0; i < this.listaEnteros.size( ); i++ ) // Recorre la lista de enteros
        {
            arreglo[ i ] = this.listaEnteros.get( i ); // Copia el valor de la lista al arreglo
        }

        return arreglo;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.listaEnteros.size( ); // Retorna la cantidad de enteros en la lista
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return listaCadenas.size( ); // Retorna la cantidad de cadenas en la lista
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros. Es decir que este método siempre debería aumentar en 1 el tamaño de la lista.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        this.listaEnteros.add( entero ); // Agrega el entero a la lista
    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas. Es decir que este método siempre debería aumentar en 1 la capacidad de la lista.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        listaCadenas.add( cadena ); // Agrega la cadena a la lista
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        this.listaEnteros.removeIf( v -> v == valor ); // Elimina el valor de la lista
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        listaCadenas.removeIf( c -> c.equals( cadena ) ); // Elimina la cadena de la lista
    }

    /**
     * Inserta un nuevo entero en la lista de enteros
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en la lista aumentada. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño de la lista, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
        if( posicion < 0 ) // Si la posición es menor a 0
        {
            this.listaEnteros.add( 0, entero ); // Agrega el entero al inicio de la lista
        } else if( posicion >= this.listaEnteros.size( ) ) // Si la posición es mayor o igual al tamaño de la lista
        {
            this.listaEnteros.add( entero ); // Agrega el entero al final de la lista
        } else // Si la posición está en el rango de la lista
        {
            this.listaEnteros.add( posicion, entero ); // Agrega el entero en la posición dada
        }
    }

    /**
     * Elimina un valor de la lista de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición de la lista de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if( posicion >= 0 && posicion < this.listaEnteros.size( ) ) // Si la posición está en el rango de la lista
        {
            this.listaEnteros.remove( posicion ); // Elimina el entero de la lista
        }
    }

    /**
     * Reinicia la lista de enteros con los valores contenidos en el parámetro 'valores', pero truncados.
     * 
     * Es decir que si el valor fuera 3.67, en la nueva lista debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        this.listaEnteros.clear( ); // Limpia la lista de enteros

        for( double valor : valores ) // Recorre los valores del arreglo
        {
            this.listaEnteros.add( ( int ) valor ); // Agrega el valor entero a la lista
        }
    }

    /**
     * Reinicia la lista de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear( ); // Limpia la lista de cadenas

        for( Object objeto : objetos ) // Recorre la lista de objetos
        {
            listaCadenas.add( objeto.toString( ) ); // Agrega la representación en cadena del objeto a la lista
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < this.listaEnteros.size(); i++) { // Recorre la lista de enteros
            if (this.listaEnteros.get(i) < 0) {
                this.listaEnteros.set(i, this.listaEnteros.get(i) * -1); // Convierte el valor a positivo
            }
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores queden organizados de MAYOR a MENOR.
     */
    public void organizarEnteros( )
    {
        for (int i = 0; i < this.listaEnteros.size(); i++) { // Recorre la lista de enteros
            for (int j = 0; j < this.listaEnteros.size() - 1; j++) { // Recorre la lista de enteros
                if (this.listaEnteros.get(j) < this.listaEnteros.get(j + 1)) { // Si el valor actual es menor al siguiente
                    int temp = this.listaEnteros.get(j); // Intercambia los valores
                    this.listaEnteros.set(j, this.listaEnteros.get(j + 1)); // Intercambia los valores
                    this.listaEnteros.set(j + 1, temp); // Intercambia los valores
                }
            }
        }
    }

    /**
     * Modifica la lista de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
        for (int i = 0; i < listaCadenas.size(); i++) { // Recorre la lista de cadenas
            for (int j = 0; j < listaCadenas.size() - 1; j++) { // Recorre la lista de cadenas
                if (listaCadenas.get(j).compareTo(listaCadenas.get(j + 1)) > 0) { // Si la cadena actual es mayor a la siguiente
                    String temp = listaCadenas.get(j); // Intercambia las cadenas
                    listaCadenas.set(j, listaCadenas.get(j + 1)); // Intercambia las cadenas
                    listaCadenas.set(j + 1, temp); // Intercambia las cadenas
                }
            }
        }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en la lista de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int count = 0; // Inicializa el contador
        for (int i = 0; i < this.listaEnteros.size(); i++) { // Recorre la lista de enteros
            if (this.listaEnteros.get(i) == valor) { // Si el valor actual es igual al valor buscado
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en la lista de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int count = 0; // Inicializa el contador
        for (int i = 0; i < listaCadenas.size(); i++) { // Recorre la lista de cadenas
            if (listaCadenas.get(i).equalsIgnoreCase(cadena)) { // Si la cadena actual es igual a la cadena buscada
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        List<Integer> analizados = new ArrayList<Integer>(); // Lista de enteros analizados
        int count = 0; // Inicializa el contador

        for (int i = 0; i < this.listaEnteros.size(); i++) { // Recorre la lista de enteros
            int numero = this.listaEnteros.get(i); // Obtiene el valor actual
            if (analizados.contains(numero)) { // Si el valor ya fue analizado
                continue;
            } else {
                int apariciones = contarApariciones(numero); // Cuenta las apariciones del valor
                if (apariciones > 1) { // Si el valor aparece más de una vez
                    count++;
                }
                analizados.add(numero); // Agrega el valor a la lista de analizados
            }
        }
        return count;
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros y verifica si contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos son los mismos y en el mismo orden y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (this.listaEnteros.size() != otroArreglo.length) { // Si los tamaños de las listas son diferentes
            return false;
        }
        for (int i = 0; i < this.listaEnteros.size(); i++) { // Recorre la lista de enteros
            if (this.listaEnteros.get(i) != otroArreglo[i]) { // Si los valores son diferentes
                return false;
            }
        }
        return true;
    }

    /**
     * Cambia los elementos de la lista de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en la lista deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en la lista
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        java.util.Random random = new java.util.Random();
        this.listaEnteros.clear(); // Limpia la lista de enteros
        for (int i = 0; i < cantidad; i++) { // Recorre la cantidad de elementos
            int numero = random.nextInt((maximo - minimo) + 1) + minimo; // Genera un número aleatorio
            this.listaEnteros.add(numero); // Agrega el número a la lista
        }
    }

}
