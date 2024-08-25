package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int[] copia = new int[this.arregloEnteros.length]; // Crear un nuevo arreglo de enteros con la misma longitud

        for (int i = 0; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo
        {
            copia[i] = this.arregloEnteros[i];
        }

        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        String[] copia = new String[this.arregloCadenas.length]; // Crear un nuevo arreglo de cadenas con la misma longitud

        for (int i = 0; i < this.arregloCadenas.length; i++) // Copiar los valores del arreglo original al nuevo arreglo
        {
            copia[i] = this.arregloCadenas[i] + "";
        }

        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.arregloEnteros.length; // Obtener la longitud del arreglo de enteros
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return this.arregloCadenas.length; // Obtener la longitud del arreglo de cadenas
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int[] nuevoArreglo = new int[this.arregloEnteros.length + 1]; // Crear un nuevo arreglo de enteros con una posición más

        for (int i = 0; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo
        {
            nuevoArreglo[i] = this.arregloEnteros[i];
        }

        nuevoArreglo[this.arregloEnteros.length] = entero; // Agregar el nuevo valor al final del nuevo arreglo
        this.arregloEnteros = nuevoArreglo; // Actualizar la referencia al arreglo de enteros
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        String[] nuevoArreglo = new String[this.arregloCadenas.length + 1]; // Crear un nuevo arreglo de cadenas con una posición más

        for (int i = 0; i < this.arregloCadenas.length; i++) // Copiar los valores del arreglo original al nuevo arreglo
        {
            nuevoArreglo[i] = this.arregloCadenas[i];
        }

        nuevoArreglo[this.arregloCadenas.length] = cadena; // Agregar la nueva cadena al final del nuevo arreglo
        this.arregloCadenas = nuevoArreglo; // Actualizar la referencia al arreglo de cadenas

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int cantidad = 0; // Contador de la cantidad de veces que aparece el valor en el arreglo

        for (int i = 0; i < this.arregloEnteros.length; i++) // Contar cuántas veces aparece el valor en el arreglo
        {
            if (this.arregloEnteros[i] == valor)
            {
                cantidad++;
            }
        }

        int[] nuevoArreglo = new int[this.arregloEnteros.length - cantidad]; // Crear un nuevo arreglo de enteros con una posición menos por cada aparición del valor

        int j = 0; // Índice para recorrer el nuevo arreglo
        for (int i = 0; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo, excepto los valores que se quieren eliminar
        {
            if (this.arregloEnteros[i] != valor)
            {
                nuevoArreglo[j] = this.arregloEnteros[i];
                j++;
            }
        }

        this.arregloEnteros = nuevoArreglo; // Actualizar la referencia al arreglo de enteros
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        int cantidad = 0; // Contador de la cantidad de veces que aparece la cadena en el arreglo

        for (int i = 0; i < this.arregloCadenas.length; i++) // Contar cuántas veces aparece la cadena en el arreglo
        {
            if (this.arregloCadenas[i].equals(cadena))
            {
                cantidad++;
            }
        }

        String[] nuevoArreglo = new String[this.arregloCadenas.length - cantidad]; // Crear un nuevo arreglo de cadenas con una posición menos por cada aparición de la cadena

        int j = 0; // Índice para recorrer el nuevo arreglo
        for (int i = 0; i < this.arregloCadenas.length; i++) // Copiar los valores del arreglo original al nuevo arreglo, excepto las cadenas que se quieren eliminar
        {
            if (!this.arregloCadenas[i].equals(cadena))
            {
                nuevoArreglo[j] = this.arregloCadenas[i];
                j++;
            }
        }

        this.arregloCadenas = nuevoArreglo; // Actualizar la referencia al arreglo de cadenas

    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
        int[] nuevoArreglo = new int[this.arregloEnteros.length + 1]; // Crear un nuevo arreglo de enteros con una posición más

        if (posicion <= 0) // Si la posición es menor a 0, insertar el valor en la primera posición
        {
            nuevoArreglo[0] = entero;
            for (int i = 0; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo
            {
                nuevoArreglo[i + 1] = this.arregloEnteros[i];
            }
        }
        else if (posicion >= this.arregloEnteros.length) // Si la posición es mayor o igual al tamaño del arreglo, insertar el valor en la última posición
        {
            for (int i = 0; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo
            {
                nuevoArreglo[i] = this.arregloEnteros[i];
            }
            nuevoArreglo[this.arregloEnteros.length] = entero;
        }
        else // Insertar el valor en la posición indicada
        {
            for (int i = 0; i < posicion; i++) // Copiar los valores del arreglo original al nuevo arreglo hasta la posición indicada
            {
                nuevoArreglo[i] = this.arregloEnteros[i];
            }
            nuevoArreglo[posicion] = entero; // Agregar el nuevo valor en la posición indicada
            for (int i = posicion; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo desde la posición indicada
            {
                nuevoArreglo[i + 1] = this.arregloEnteros[i];
            }
        }

        this.arregloEnteros = nuevoArreglo; // Actualizar la referencia al arreglo de enteros
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion >= 0 && posicion < this.arregloEnteros.length) // Si la posición está dentro del rango del arreglo
        {
            int[] nuevoArreglo = new int[this.arregloEnteros.length - 1]; // Crear un nuevo arreglo de enteros con una posición menos

            int j = 0; // Índice para recorrer el nuevo arreglo
            for (int i = 0; i < this.arregloEnteros.length; i++) // Copiar los valores del arreglo original al nuevo arreglo, excepto el valor en la posición indicada
            {
                if (i != posicion)
                {
                    nuevoArreglo[j] = this.arregloEnteros[i];
                    j++;
                }
            }

            this.arregloEnteros = nuevoArreglo; // Actualizar la referencia al arreglo de enteros
        }
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        int[] nuevoArreglo = new int[valores.length]; // Crear un nuevo arreglo de enteros con la misma longitud

        for (int i = 0; i < valores.length; i++) // Truncar los valores decimales y agregarlos al nuevo arreglo
        {
            nuevoArreglo[i] = (int) valores[i];
        }

        this.arregloEnteros = nuevoArreglo; // Actualizar la referencia al arreglo de enteros
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
        String[] nuevoArreglo = new String[objetos.length]; // Crear un nuevo arreglo de cadenas con la misma longitud

        for (int i = 0; i < objetos.length; i++) // Convertir los objetos a cadenas y agregarlos al nuevo arreglo
        {
            nuevoArreglo[i] = objetos[i].toString();
        }

        this.arregloCadenas = nuevoArreglo; // Actualizar la referencia al arreglo de cadenas
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < this.arregloEnteros.length; i++) // Hacer positivos los valores negativos
        {
            if (this.arregloEnteros[i] < 0)
            {
                this.arregloEnteros[i] = -this.arregloEnteros[i];
            }
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
        for (int i = 0; i < this.arregloEnteros.length; i++) // Ordenar los valores del arreglo de menor a mayor
        {
            for (int j = i + 1; j < this.arregloEnteros.length; j++)
            {
                if (this.arregloEnteros[i] > this.arregloEnteros[j])
                {
                    int temp = this.arregloEnteros[i];
                    this.arregloEnteros[i] = this.arregloEnteros[j];
                    this.arregloEnteros[j] = temp;
                }
            }
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
        for (int i = 0; i < this.arregloCadenas.length; i++) // Ordenar las cadenas del arreglo lexicográficamente
        {
            for (int j = i + 1; j < this.arregloCadenas.length; j++)
            {
                if (this.arregloCadenas[i].compareTo(this.arregloCadenas[j]) > 0)
                {
                    String temp = this.arregloCadenas[i];
                    this.arregloCadenas[i] = this.arregloCadenas[j];
                    this.arregloCadenas[j] = temp;
                }
            }
        }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int cantidad = 0; // Contador de la cantidad de veces que aparece el valor en el arreglo

        for (int i = 0; i < this.arregloEnteros.length; i++) // Contar cuántas veces aparece el valor en el arreglo
        {
            if (this.arregloEnteros[i] == valor)
            {
                cantidad++;
            }
        }

        return cantidad;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int cantidad = 0; // Contador de la cantidad de veces que aparece la cadena en el arreglo

        for (int i = 0; i < this.arregloCadenas.length; i++) // Contar cuántas veces aparece la cadena en el arreglo
        {
            if (this.arregloCadenas[i].equalsIgnoreCase(cadena))
            {
                cantidad++;
            }
        }

        return cantidad;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int cantidad = contarApariciones(valor); // Contar cuántas veces aparece el valor en el arreglo
        int[] posiciones = new int[cantidad]; // Crear un nuevo arreglo de enteros con la cantidad de veces que aparece el valor

        int j = 0; // Índice para recorrer el arreglo de posiciones
        for (int i = 0; i < this.arregloEnteros.length; i++) // Guardar las posiciones en las que aparece el valor en el arreglo
        {
            if (this.arregloEnteros[i] == valor)
            {
                posiciones[j] = i;
                j++;
            }
        }

        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        int[] rango = new int[2]; // Crear un nuevo arreglo de enteros con dos posiciones

        if (this.arregloEnteros.length == 0) // Si el arreglo está vacío, retornar un arreglo vacío
        {
            return new int[]{};
        }

        int minimo = this.arregloEnteros[0]; // Inicializar el valor mínimo con el primer valor del arreglo
        int maximo = this.arregloEnteros[0]; // Inicializar el valor máximo con el primer valor del arreglo

        for (int i = 1; i < this.arregloEnteros.length; i++) // Encontrar el valor mínimo y el valor máximo en el arreglo
        {
            if (this.arregloEnteros[i] < minimo)
            {
                minimo = this.arregloEnteros[i];
            }
            if (this.arregloEnteros[i] > maximo)
            {
                maximo = this.arregloEnteros[i];
            }
        }

        rango[0] = minimo; // Guardar el valor mínimo en la primera posición del arreglo
        rango[1] = maximo; // Guardar el valor máximo en la segunda posición del arreglo

        return rango;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> histograma = new HashMap<Integer, Integer>(); // Crear un nuevo mapa para el histograma

        for (int i = 0; i < this.arregloEnteros.length; i++) // Contar cuántas veces aparece cada valor en el arreglo
        {
            if (histograma.containsKey(this.arregloEnteros[i]))
            {
                histograma.put(this.arregloEnteros[i], histograma.get(this.arregloEnteros[i]) + 1);
            }
            else
            {
                histograma.put(this.arregloEnteros[i], 1);
            }
        }

        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        int cantidad = 0; // Contador de la cantidad de enteros repetidos

        HashMap<Integer, Integer> histograma = calcularHistograma(); // Calcular el histograma de los valores del arreglo

        for (int valor : histograma.keySet()) // Contar cuántos valores aparecen más de una vez
        {
            if (histograma.get(valor) > 1)
            {
                cantidad++;
            }
        }

        return cantidad;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (this.arregloEnteros.length != otroArreglo.length) // Comparar las longitudes de los arreglos
        {
            return false;

        } else {
            for (int i = 0; i < arregloEnteros.length; i++) // Comparar los valores de los arreglos
            {
                if (arregloEnteros[i] != otroArreglo[i])
                {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        if (this.arregloEnteros.length != otroArreglo.length) // Comparar las longitudes de los arreglos
        {
            return false;
        }
        else {

            for (int i = 0; i < arregloEnteros.length; i++) // Comparar los valores de los arreglos
            {
                boolean encontrado = false;
                for (int j = 0; j < otroArreglo.length; j++)
                {
                    if (arregloEnteros[i] == otroArreglo[j])
                    {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado)
                {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        int[] nuevoArreglo = new int[cantidad]; // Crear un nuevo arreglo de enteros con la cantidad de elementos indicada

        for (int i = 0; i < cantidad; i++) { // Generar los valores aleatorios y agregarlos al nuevo arreglo
            nuevoArreglo[i] = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
        }

        this.arregloEnteros = nuevoArreglo; // Actualizar la referencia al arreglo de enteros
    }
}
