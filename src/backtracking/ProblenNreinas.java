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
public class ProblenNreinas {

    /**
     * @param args the command line arguments
     */
    
    public static class Regla{
        int fil,col;
        public Regla(int i,int j){
            this.fil = i;
            this.col = j;
        }
    }
    public static int cantpaso = 0;
    public static int cantBack = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 5, b = 5;
        int[][] m = new int[a][b];
        
        m[0][3] = -1;
        if (laberintoG(m,0,0,a-1,b-1,1)) {
            mostrar(m);
            System.out.println(cantpaso);
            System.out.println(cantBack);
        } else {
            System.out.println("no hay resultado");
        }
        
        
    }
    public static void mostrar(int [][]m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean posvalida(int [][]m, int i, int j){
        return (i>=0 && i<m.length && j>=0 && j<m[i].length && m[i][j] == 0);
    }
    
    public static LinkedList<Regla> reglasaplicat(int[][]m, int f, int c){
        LinkedList<Regla>l1 = new LinkedList<>();
        int k = f;
        int l = c-1;
        while (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
            l--;
        }
        k = f-1;
        l = c;
        while (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
            k--;
        }
        k = f;
        l = c+1;
        while (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
            l++;
        }
        k = f+1;
        l = c;
        while (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
            k++;
        }
        
        return l1;  
    }
    public static Regla elegirMejorRegla(LinkedList<Regla>l1, int ifin, int jfin){
        int i = 0, k = 0;
        double menDist = Double.MAX_VALUE;
        while (i < l1.size()) {
            double dist = distancia(l1.get(i).fil, l1.get(i).col, ifin,jfin);
            if (dist < menDist) {
                menDist = dist;
                k = i;
            }
            i++;
        }
        return l1.remove(k);
    }
    public static double distancia(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }
    public static boolean laberintoG(int [][]m, int i, int j, int ifin, int jfin, int paso){
        cantpaso++;
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            return true;
        }
        LinkedList<Regla>l1 = reglasaplicat(m,i,j);
        while (!l1.isEmpty()) {
            //Regla r = elegirMejorRegla(l1,ifin,jfin);
            Regla r = l1.removeFirst();
            if (laberintoG(m,r.fil,r.col,ifin,jfin,paso+1)) {
                return true;
            }
            cantBack++;
            m[r.fil][r.col] = 0;
        }
        return false;
        
    }
    
    
    
}
