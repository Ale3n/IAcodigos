/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicas_laberintos;

import java.util.LinkedList;

/**
 *
 * @author examp
 */
public class Practicas_laberintos {

    /**
     * @param args the command line arguments
     */
    
    private static int cantSol = 0;
    
    private static class Regla{
        int fil, col;

        public Regla(int fil, int col) {
            this.fil = fil;
            this.col = col;
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 3;
        int[][] tablero = new int[n][n];  
        mostrar(tablero);
        //System.out.println("Laberinto Simple :");
        //laberinto_simple(tablero, 0, 0, n-1, n-1, 1);
        //System.out.println("El laberinto tiene : " + cantSol + ", soluciones");
        
        cantSol = 0;
        tablero = new int[n][n]; 
        System.out.println("Laberinto Mejorado :");
        laberinto_mejorado(tablero, 0, 0, n-1, n-1, 1);
        System.out.println("El laberinto tiene : " + cantSol + ", soluciones");
        
    }
    
    private static boolean posValida(int[][] m, int f, int c){
        return (f >= 0) && (c >= 0) && (f < m.length) && (c < m[f].length) && (m[f][c] == 0);
    }
    
    private static void mostrar(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print( m[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    private static void laberinto_simple(int[][] m, int i, int j, int finFil, int finCol, int paso){
        if (!posValida(m, i, j)){
            return;
        }
        
        m[i][j] = paso;
        
        if(i==finFil && j==finCol){
            cantSol++;
            System.out.println("Solución número : " + cantSol);
            mostrar(m);
        }
        
        laberinto_simple(m, i, j-1, finFil, finCol, paso+1);
        laberinto_simple(m, i-1, j, finFil, finCol, paso+1);
        laberinto_simple(m, i, j+1, finFil, finCol, paso+1);
        laberinto_simple(m, i+1, j, finFil, finCol, paso+1);
        m[i][j] = 0;
    }
    
    private static LinkedList<Regla> reglasAplicablesSimples(int[][] m, int f, int c){
        LinkedList<Regla> lista = new LinkedList<>();
        if(posValida(m, f, c-1)){
            lista.add(new Regla(f, c-1));
        }
        if(posValida(m, f-1, c)){
            lista.add(new Regla(f-1, c));
        }
        if(posValida(m, f, c+1)){
            lista.add(new Regla(f, c+1));
        }
        if(posValida(m, f+1, c)){
            lista.add(new Regla(f+1, c));
        }
        return lista;
    }
    
    private static LinkedList<Regla> reglasAplicablesMasDiagonales(int[][] m, int f, int c){
        LinkedList<Regla> lista = new LinkedList<>();
        if(posValida(m, f, c-1)){
            lista.add(new Regla(f, c-1));
        }
        if(posValida(m, f-1, c-1)){
            lista.add(new Regla(f-1, c-1));
        }
        if(posValida(m, f-1, c)){
            lista.add(new Regla(f-1, c));
        }
        if(posValida(m, f-1, c+1)){
            lista.add(new Regla(f-1, c+1));
        }
        if(posValida(m, f, c+1)){
            lista.add(new Regla(f, c+1));
        }
        if(posValida(m, f+1, c+1)){
            lista.add(new Regla(f+1, c+1));
        }
        if(posValida(m, f+1, c)){
            lista.add(new Regla(f+1, c));
        }
        if(posValida(m, f+1, c-1)){
            lista.add(new Regla(f+1, c-1));
        }
        return lista;
    }
    
    private static boolean casillasTodasVisitas(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void laberinto_mejorado(int[][] m, int i, int j, int finFil, int finCol, int paso){//DEL LABORATORIO 3 ESTE RESUELVE EL INCISO D,
        if (!posValida(m, i, j)){
            return;
        }
        
        m[i][j] = paso;
        
        //if(i==finFil && j==finCol){ 
            // Para todas las soluciones posibles..
        if(i==finFil && j==finCol && casillasTodasVisitas(m)){ 
        // aqui mostrará resultado si:
        // el tamaño de n es impar 
        // si es par no muestra resultado
        // if(i==finFil && j==finCol && !casillasTodasVisitas(m)){  
            //excluye todas las casillas visitadas
            cantSol++;
            mostrar(m);
        }
              
        LinkedList<Regla> lra = reglasAplicablesSimples(m, i, j);
        //LinkedList<Regla> lra = reglasAplicablesMasDiagonales(m, i, j);
        
        while(!lra.isEmpty()){
            Regla R = lra.removeFirst();
            laberinto_mejorado(m, R.fil, R.col, finFil, finCol, paso+1);
            m[R.fil][R.col] = 0;
        }        
    }
    
}
