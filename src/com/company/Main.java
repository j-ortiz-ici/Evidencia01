package com.company;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[][] vinilos = new String [100][3];
        agregarVinilo(vinilos, "Pearl Jam", "Do the evolution", "1998");
        agregarVinilo(vinilos, "Soundgarden", "Fell on Black Days", "1994");
        agregarVinilo(vinilos, "Alice in Chains", "Dirt", "1992");
        agregarVinilo(vinilos, "Alice in Chains", "Dirt", "1992");
        agregarVinilo(vinilos, "Alice in Chains", "Brush Away", "1995");
        agregarVinilo(vinilos, "Alice in Chains", "Dirt", "1992");
        agregarVinilo(vinilos, "Lynyrd Skynyrd", "Free Bird", "1973");
        agregarVinilo(vinilos, "Alice in Chains", "Nutshell", "1992");


        System.out.println("Espacio máximo colección: "+vinilos.length);

        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "Soundgarden";
        String lp = "Fell on black days";
        System.out.println("Buscando artista: " +artista);
        buscarArtista(vinilos,artista,lp);
        mostrarBusquedaArtista(vinilos,artista,lp);

        mostrarColeccion(vinilos);



    }

    /*for (int i = 0; i < m.length; i++) {
       int fila = totalVinilos(m);
       if (i >= 5) {
           System.out.print("La colección se encuentra llena.\n"); //como cancelar el return?
       } else{
           m[fila][0] = gru;
           m[fila][1] = lp;
           m[fila][2] = agno;
           }
       }
   return m;
   }*/ //ideas desechadas, guardadas para tener a mano en caso de necesitar a futuro.
    /*public static boolean mostrarBusquedaArtista(String[][] m, String artista){
        for (String[]grupo: m) {
            for (String info : grupo) {
                System.out.println(info);
                if (info == artista) { //info.contains(artista)
                    System.out.println("El artista " + artista + " fue encontrado");
                    return true; //return detiene el for si se encontró el artista
                }
            }
        }
        System.out.println("El artista " + artista + " no fue encontrado");
        return false;//como no es void reclama que no retorna nada
    } */
    public static int totalVinilos (String[][] m){
        int filas = 0;
        while (filas < m.length) {
            if (m[filas][0] != null) {
                filas++;
            } else{
                break;
            }
        }
        return filas;
    }
    public static String[][] agregarVinilo (String[][] m,String gru, String lp, String agno) {
        if (mostrarBusquedaArtista(m,gru,lp)) {
            return m;
        }
        int fila = totalVinilos(m);
        if (fila >= m.length) {
            System.out.print("La colección se encuentra llena.\n");
        } else {
            m[fila][0] = gru;
            m[fila][1] = lp;
            m[fila][2] = agno;
        }
        return m;
    }
    public static boolean mostrarBusquedaArtista(String[][] m, String artista, String lp){
        for (String[]grupo: m) {
                if (artista.equalsIgnoreCase(grupo[0]) && lp.equalsIgnoreCase(grupo[1])) { // (grupo[0] == artista) o (artista.equalsIgnoreCase(grupo[0]))
                    return true; //return detiene el for si se encontró el artista
                }
            }
        return false;//como no es void tiene que retornar
    }
    public static void mostrarColeccion(String[][] m) {
        /*for (int i=0; i<m.length; i++){
            System.out.print("Fila "+(i+1)+" ");
            for (int j=0; j<m[i].length; j++){
                if (j==m[i].length-1){
                    System.out.println(m[i][j]);
                } else
                    System.out.print(m[i][j]+ " - " );
            }
        }*/ //alternativa inversa al for de abajo para tenerla a mano
        System.out.println("Colección: ");
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null) {
                System.out.print("Fila " + (i + 1) + " ");
                for (int j = 0; j < m[i].length; j++) {
                    if (j < m[i].length - 1) {
                        System.out.print(m[i][j] + " - ");
                    } else
                        System.out.println(m[i][j]);
                }
            }
        }
    }
    public static void mostrarTotal(String[][] m){
       int filastot = 0;
       for (String[] grupo : m) {
           if ((grupo[0]) != null) {
               filastot++;
           }
       }
       System.out.println("Hay un total de: "+filastot+" vinilos en la colección"+"\n");
    }
    public static void mostrarDisponibles(String[][] m) {
        int filasvacias = disponibles(m);
        System.out.println("Espacios disponibles en la colección: "+filasvacias+"\n");
   }
    public static void buscarArtista(String[][] m,String artista,String lp){
        if(mostrarBusquedaArtista(m,artista,lp)) {
            System.out.println("El artista " + artista + " se encuentra en la colección"+"\n");
        } else{
            System.out.println("El artista " + artista + " no se encuentra en la colección"+"\n");
        }
    }
    public static int disponibles(String[][] m){
        int filasvacias = 0;
        for (String[] grupo : m) {
            if ((grupo[0]) == null) {
                filasvacias++;
            }
        }
        return filasvacias;
    }

}


