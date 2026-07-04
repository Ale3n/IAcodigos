/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backtracking;

import java.util.LinkedList;

/**
 *
 * @author examp
 */
public class Pract_N_Reinas {

    /**
     * @param args the command line arguments
     */
    
    private static class Regla{
        public int fil, col;

        public Regla(int fil, int col) {
            this.fil = fil;
            this.col = col;
        }
    }
    
    private static int cantPaso=0;
    private static int cantPasoAtras=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 4;
        int[][] tablero = new int[n][n];
        
        System.out.println("Dimensión del tablero : " + n);
        
        if (nReinas(tablero, 1)){
            System.out.println("El tablero tiene solución");
            System.out.println("Cantidad de pasos : " + cantPaso);
            System.out.println("Cantidad de pasos hacia atras: " + cantPasoAtras);
            mostrarTablero(tablero);
        } else {
            System.out.println("El tablero NO tiene solución");
        }
        
    }
    
    private static void mostrarTablero(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != 0)
                    System.out.print("X  ");
                else
                    System.out.print(m[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
    private static boolean posValida(int[][]m, int f, int c){
        return (f>=0 && f<m.length && c>=0 && c<m[f].length);
    }
    
    private static boolean posDisponible(int[][] m, int f, int c){
        int k = f;
        int l = c-1;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            l--;
        }
        
        k = f-1;
        l = c-1;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            k--;
            l--;
        }
        
        k = f-1;
        l = c;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            k--;
        }
        
        k = f-1;
        l = c+1;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            k--;
            l++;
        }
        
        k = f;
        l = c+1;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            l++;
        }
        
        k = f+1;
        l = c+1;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            k++;
            l++;
        }
        
        k = f+1;
        l = c;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            k++;
        }
        
        k = f+1;
        l = c-1;
        while(posValida(m, k, l)){
            if(m[k][l] != 0)
                return false;
            k++;
            l--;
        }    
        return true;
    }
    private static LinkedList<Regla> reglasAplicables(int[][] m, int fil){
        LinkedList<Regla> l = new LinkedList<>();
        for (int col = 0; col < m[fil].length; col++) {
            if (posDisponible(m, fil, col))
                l.add(new Regla(fil, col));
        }
        return l;
    }
    
    private static Regla elegirPrimerRegla(LinkedList<Regla> l){
        return l.removeFirst();
    }
    
    private static Regla elegirReglaDeMedios(LinkedList<Regla> l){
        int pos = 0;
        if (l.size()>1)
            pos = l.size()/2;
        return l.remove(pos);
    }
    private static boolean nReinas(int [][] m, int paso){
        cantPaso++;
        if (paso > m.length)
            return true;
        LinkedList<Regla> reglasPosibles = reglasAplicables(m, paso-1);
        while (! reglasPosibles.isEmpty()){
          //Regla R=elegirPrimerRegla(reglasPosibles);//Sin heurística
         Regla R=elegirReglaDeMedios(reglasPosibles);//Con heurística
            //Regla R = reglasPosibles.removeFirst();
            m[R.fil][R.col] = paso;
            if (nReinas(m, paso+1))
                return true;
            cantPasoAtras++;
            m[R.fil][R.col] = 0;
        }
        return false;
    }
    
    
    
}
