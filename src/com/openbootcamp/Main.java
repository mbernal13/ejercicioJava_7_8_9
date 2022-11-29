package com.openbootcamp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main (String[] args){
        //System.out.println("***** Ejercicio 0 *****");
        String cadena = "Hola mundo";
        //String cadenaReverse = reverse( cadena );
        //System.out.println(cadenaReverse);
        //System.out.println("***** Ejercicio 1 *****");
        //arrayUnidimensional();
        //System.out.println("***** Ejercicio 2 *****");
        //arrayBidimensional();
        //System.out.println("***** Ejercicio 3 *****");
        //vectorInteger();
        //System.out.println("***** Ejercicio 4 *****");
        //problemaVector();
        //System.out.println("***** Ejercicio 5 *****");
        //copyArrayListToLinkedList();
        //System.out.println("***** Ejercicio 6 *****");
        //gameArrayList();
        //System.out.println("***** Ejercicio 7 *****");
        /*try {
            dividePorCero(4,0);
        }
        catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }
        finally {
            System.out.println("Demo de código");
        }*/
        System.out.println("***** Ejercicio 8 *****");
        try {
            InputStream fileIn = new FileInputStream("C:/Users/mbernal/proyectos-java/ejercicios_7_8_9/ejemplo.txt");
            PrintStream fileOut = new PrintStream("destino.txt");
            copyFichero(fileIn, fileOut);
        }
        catch(Exception e){
            System.out.println("Error1: "+e.getMessage());
        }
    }

    public static String reverse(String cadena){
    /*
    Ejercicio 0:
    Escribe el código que devuelva una cadena al revés.
    Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".
    */
        char[] letras = cadena.toCharArray();
        String cadenaReverse = "";

        for ( int i = letras.length - 1; i >= 0; i -- ) {
            cadenaReverse += letras[i];
        }
        return cadenaReverse;
    }

    public static void arrayUnidimensional(){
    /*
    Ejercicio 1:
    Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
    */
        String[] nombres = {"Miguel", "Deybby","Flavio", "Edder", "Alfred"};

        for(String nombre : nombres){
            System.out.println(nombre);
        }
    }

    public static void arrayBidimensional(){
    /*
    Ejercicio 2:
    Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.
    */
        String[][] nombres = {{"Miguel", "Deybby","Flavio", "Edder", "Alfred"},{"Luis", "Renatto","Pio", "Segundo", "Juan"}};

        for(int i = 0; i<nombres.length; i++){
            for (int j = 0; j < nombres[i].length; j++){
                System.out.println("Fila:"+i+" Columna: "+j+" => "+nombres[i][j]);
            }
        }
    }

    public static void  vectorInteger(){
    /*
    Ejercicio 3:
    Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
    Elimina el 2o y 3er elemento y muestra el resultado final.
    */
        Vector<Integer> numeros = new Vector<Integer>();

        numeros.add(1);
        numeros.add(10);
        numeros.add(20);
        numeros.add(25);
        numeros.add(30);

        numeros.remove(2); //Tercer elemento
        numeros.remove(1); //Segundo elemento

        System.out.println("Vector: "+numeros);

    }

    public static void problemaVector(){
    /*
    Ejercicio 4:
    Indica cuál es el problema de utilizar un Vector con la capacidad por defecto
    si tuviésemos 1000 elementos para ser añadidos al mismo.
    */
        System.out.println("El problema es que por debajo se producen copias de los arrays duplicandose, hasta completar la capacidad de los 1000 elementos");

    }

    public static void copyArrayListToLinkedList(){
    /*
    Ejercicio 5:
    Crea un ArrayList de tipo String, con 4 elementos.
    Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.
    */
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Miguel");
        lista.add("Pio");
        lista.add("Renatto");
        lista.add("Willy");

        LinkedList<String> listaLinked = new LinkedList<>(lista);
        System.out.println("*****ArrayList*****");
        for(String nombre : lista){
            System.out.println(nombre);
        }
        System.out.println("*****LinkedList*****");
        for(String nombre : listaLinked){
            System.out.println(nombre);
        }

    }

    public static void gameArrayList(){
    /*
    Ejercicio 6:
    Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
    A continuación, con otro bucle, recórrelo y elimina los numeros pares.
    Por último, vuelve a recorrerlo y muestra el ArrayList final.
    Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
    */
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for(int i = 1; i <= 10; i++){
            numeros.add(i);
        }

        for (Integer numero : numeros){
            if (! ( numero % 2 == 0 ) ){
                System.out.println("Número impar: "+numero);
            }
        }
    }

    public static Integer dividePorCero(Integer numeroA, Integer numeroB) throws ArithmeticException{
    /*
    Ejercicio 7:
    Crea una función DividePorCero.
    Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
    Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
    Finalmente, mostraremos en cualquier caso: "Demo de código".
    */
        Integer resultado;
        try {
            resultado = numeroA/numeroB;
        }
        catch (Exception e){
            throw new ArithmeticException();
        }
        return resultado;
    }

    public static void copyFichero(InputStream fileIn, PrintStream fileOut){
    /*
    Ejercicio 8:
    Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut".
    La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
    */
        try {
            byte[] datos = fileIn.readAllBytes();
            //fileIn.close();

            fileOut.write(datos);
            //fileOut.close();
        }
        catch (Exception e){
            System.out.println("Error2: "+e.getMessage());
        }
    }
}
