/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ajedrez;

/**
 *
 * @author Tower
 */
public class PromLaberinto {

    /**
     * @param args the command line arguments
     */
    public static int c = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        /*int a = 3,b=4;
        int m[][] = new int[a][b];
        laberintoDiagonal(m,0,0,a-1,b-1,1);
        System.out.println(c);*/
        
        
        int a = 3, b = 4;
        int[][] m = new int[a][b];
        int total = a * b;

        laberintoDiagonal3(m, 0, 0, a - 1, b - 1, 1, total);

        System.out.println("Cantidad de soluciones: " + c);
        
        
    }
    
    public static boolean posicionValida(int m[][], int i,int j)
    {
        return i>=0 && i<m.length && j>=0 && j<m[i].length && m[i][j] == 0;
    }
    public static void laberinto(int m[][], int i,int j,int iFin, int jFin,int paso)
    {
        if(!posicionValida(m,i,j)) return;
        m[i][j] = paso;
        if (i== iFin && j==jFin) {
            mostrar(m);
            
        }
        laberinto(m,i,j-1,iFin,jFin,paso+1);
        laberinto(m,i-1,j,iFin,jFin,paso+1);
        laberinto(m,i,j+1,iFin,jFin,paso+1);
        laberinto(m,i+1,j,iFin,jFin,paso+1);
        m[i][j] = 0;
    }
    
    /*b) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final tal que
    se visiten todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.*/
    public static void laberinto2(int[][] m, int i, int j,
                                 int iFin, int jFin,
                                 int paso, int total) {

        if (!posicionValida(m, i, j)) return;

        m[i][j] = paso;

        if (i == iFin && j == jFin && paso == total) {
            mostrar(m);
            c++;
        } else {
            laberinto2(m, i, j - 1, iFin, jFin, paso + 1, total);
            laberinto2(m, i - 1, j, iFin, jFin, paso + 1, total);
            laberinto2(m, i, j + 1, iFin, jFin, paso + 1, total);
            laberinto2(m, i + 1, j, iFin, jFin, paso + 1, total);
        }

        m[i][j] = 0; 
    }
    /*c) Algoritmo para mostrar todos los caminos posibles desde una posición inicial a una posición final tal que
    NO se visiten todas las casillas de la matriz. Además, mostrar la cantidad de soluciones posibles.*/
    public static void laberinto3(int[][] m, int i, int j,
                                 int iFin, int jFin,
                                 int paso, int total) {

        if (!posicionValida(m, i, j)) return;

        m[i][j] = paso;

        if (i == iFin && j == jFin && paso < total) {
            mostrar(m);
            c++;
        } else {
            laberinto3(m, i, j - 1, iFin, jFin, paso + 1, total);
            laberinto3(m, i - 1, j, iFin, jFin, paso + 1, total);
            laberinto3(m, i, j + 1, iFin, jFin, paso + 1, total);
            laberinto3(m, i + 1, j, iFin, jFin, paso + 1, total);
        }

        m[i][j] = 0; 
    }
    
    /*d) Resolver los problemas a), b) y c), haciendo que en el Laberinto se pueda avanzar también por las
    diagonales*/
    //a
    public static void laberintoDiagonal(int m[][], int i, int j,
                                     int iFin, int jFin, int paso) {

        if (!posicionValida(m, i, j)) return;

        m[i][j] = paso;

        if (i == iFin && j == jFin) {
            mostrar(m);
            c++;
            m[i][j] = 0;
            return;
        }

        laberintoDiagonal(m, i, j-1, iFin, jFin, paso+1);
        laberintoDiagonal(m, i-1, j, iFin, jFin, paso+1);
        laberintoDiagonal(m, i, j+1, iFin, jFin, paso+1);
        laberintoDiagonal(m, i+1, j, iFin, jFin, paso+1);

        laberintoDiagonal(m, i-1, j-1, iFin, jFin, paso+1);
        laberintoDiagonal(m, i-1, j+1, iFin, jFin, paso+1);
        laberintoDiagonal(m, i+1, j+1, iFin, jFin, paso+1);
        laberintoDiagonal(m, i+1, j-1, iFin, jFin, paso+1);

        m[i][j] = 0;
    }
    //b
    public static void laberintoDiagonal2(int m[][], int i, int j,
                                      int iFin, int jFin,
                                      int paso, int total) {

        if (!posicionValida(m, i, j)) return;

        m[i][j] = paso;

        if (i == iFin && j == jFin && paso == total) {
            mostrar(m);
            c++;
            m[i][j] = 0;
            return;
        }

        laberintoDiagonal2(m, i, j-1, iFin, jFin, paso+1, total);
        laberintoDiagonal2(m, i-1, j, iFin, jFin, paso+1, total);
        laberintoDiagonal2(m, i, j+1, iFin, jFin, paso+1, total);
        laberintoDiagonal2(m, i+1, j, iFin, jFin, paso+1, total);

        laberintoDiagonal2(m, i-1, j-1, iFin, jFin, paso+1, total);
        laberintoDiagonal2(m, i-1, j+1, iFin, jFin, paso+1, total);
        laberintoDiagonal2(m, i+1, j+1, iFin, jFin, paso+1, total);
        laberintoDiagonal2(m, i+1, j-1, iFin, jFin, paso+1, total);

        m[i][j] = 0;
    }
    
    //c
    public static void laberintoDiagonal3(int m[][], int i, int j,
                                      int iFin, int jFin,
                                      int paso, int total) {

        if (!posicionValida(m, i, j)) return;

        m[i][j] = paso;

        if (i == iFin && j == jFin && paso < total) {
            mostrar(m);
            c++;
            m[i][j] = 0;
            return;
        }

        laberintoDiagonal3(m, i, j-1, iFin, jFin, paso+1, total);
        laberintoDiagonal3(m, i-1, j, iFin, jFin, paso+1, total);
        laberintoDiagonal3(m, i, j+1, iFin, jFin, paso+1, total);
        laberintoDiagonal3(m, i+1, j, iFin, jFin, paso+1, total);

        laberintoDiagonal3(m, i-1, j-1, iFin, jFin, paso+1, total);
        laberintoDiagonal3(m, i-1, j+1, iFin, jFin, paso+1, total);
        laberintoDiagonal3(m, i+1, j+1, iFin, jFin, paso+1, total);
        laberintoDiagonal3(m, i+1, j-1, iFin, jFin, paso+1, total);

        m[i][j] = 0;
    }
    
    
    
    
    public static void mostrar(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    
    
}
