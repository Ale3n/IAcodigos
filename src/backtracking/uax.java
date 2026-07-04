/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backtracking;

import java.util.LinkedList;

/**
 *
 * @author Tower
 */
public class uax {

    /**
     * @param args the command line arguments
     */
  
    /**
     * @param args the command line arguments
     */
    public static int cont = 0, back = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 5, b = 5;
        int m[][] = new int[a][b];
        /*if (NReinas(m,1)) {
            mostrar(m);
        }else{
            System.out.println("No hay SOLUCION");
        }
        System.out.println("Pasos " + cont);
        System.out.println("Back "+ back);*/
    }
    public static class Regla{
        int f,c;
        public Regla(int i,int j){
            this.f = i;
            this.c = j;
        }
        
    }
    public static void mostrar(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    public static boolean posV(int m[][], int i, int j){
        return i < m.length && i >= 0 && (j < m[0].length && j >= 0) && m[i][j] == 0;
    }
   
 
    // Reinas
    public static boolean NReinas(int m[][], int i, int paso){
        cont++;
        if (i == m.length) {
            return true;
        }
        LinkedList<Regla> R = ReglaA(m, i);
        
        while (!R.isEmpty()) {            
            Regla r = mejorR(m, R);
            m[r.f][r.c] = paso;
            if (NReinas(m, i+1, paso+1)) {
                return true;
            }
            back++;
            m[r.f][r.c] = 0;
        }
        return true;
    }
    public static boolean posVar(int m[][], int i, int j){
        int k, h;
        k = i - 1;
        h = j;
        while (k >= 0) {            
            if (m[k][h] != 0) {
                return false;
            }
            k--;
        }
        k = i - 1;
        h = j - 1;
        while (k >= 0 && h >= 0) {            
            if (m[k][h] != 0) {
                return false;
            }
            k--;
            h--;
        }
        k = i - 1;
        h = j + 1;
        while (k >= 0 && h < m[0].length) {            
            if (m[k][h] != 0) {
                return false;
            }
            k--;
            h++;
        }
        return true;
    }
    public static LinkedList<Regla> ReglaA(int m[][], int i){
        LinkedList<Regla> l = new LinkedList<>();
        for (int j = 0; j < m[0].length; j++) {
            if (posVar(m,i,j)) {
                l.add(new Regla(i,j));
            }
        }
        return l;
    }

    private static Regla mejorR(int[][] m, LinkedList<Regla> R) {
        int i = 0;
        double minD = Double.MAX_VALUE;
        double centro = (m[0].length - 1)/2.0;
        for (int j = 0; j < R.size(); j++) {
            Regla r = R.get(i);
            double dist = Math.abs(r.c - centro);
            if (dist < minD) {
                minD = dist;
                i = j;
            }
        }
        return R.remove(i);
    }
    
    ////
    
    
    
  
   
}
