/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TorreAlfilReyna;

import java.util.LinkedList;

/**
 *
 * @author Tower
 */
public class prac {

    /**
     * @param args the command line arguments
     */
    
    public static class Regla{
        public int fil,col;
        
        public Regla(int fil, int col){
            this.fil = fil;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 3,b = 3;
        int [][] m = new int[a][b];
        laberintosGenercos(m,0,0,a-1,b-1,1);
    
    }
    
    public static boolean posValida(int[][]m, int i, int j){
        return(i>=0 && i < m.length && j>=0 && j< m[i].length && m[i][j] == 0);
    }
    
    public static void mostrar(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void laberintosimple1(int[][]m, int i, int j,int iFin, int jFin, int paso){
        if (!posValida(m,i,j)) {
            return;
        }
        m[i][j] = paso;
        if (i == iFin && j == jFin) {
            mostrar(m);
        }
        laberintosimple1(m,i,j-1,iFin,jFin,paso+1);
        laberintosimple1(m,i-1,j-1,iFin,jFin,paso+1);
        laberintosimple1(m,i-1,j,iFin,jFin,paso+1);
        laberintosimple1(m,i-1,j+1,iFin,jFin,paso+1);
        laberintosimple1(m,i,j+1,iFin,jFin,paso+1);
        laberintosimple1(m,i+1,j+1,iFin,jFin,paso+1);
        laberintosimple1(m,i+1,j,iFin,jFin,paso+1);
        laberintosimple1(m,i+1,j-1,iFin,jFin,paso+1);
        m[i][j] = 0;
        
    }
    
    public static LinkedList<Regla> rey(int[][]m, int f, int c){
        LinkedList<Regla> l1 = new LinkedList<>();
        int k = f;
        int l = c-1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
         k = f-1;
         l = c-1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f-1;
         l = c;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f-1;
         l = c+1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        
        
        k = f;
         l = c+1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c+1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c-1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        return l1;
        
    }
    
    public static LinkedList<Regla> caballo(int[][]m, int f, int c){
        LinkedList<Regla> l1 = new LinkedList<>();
        int k = f+1;
        int l = c-2;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
         k = f-1;
         l = c-2;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f-2;
         l = c-1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f-2;
         l = c+1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        
        
        k = f-1;
         l = c+2;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c+2;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+2;
         l = c+1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+2;
         l = c-1;
        if (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        return l1; 
    }
    
    public static LinkedList<Regla> torre(int[][]m, int f, int c){
        LinkedList<Regla> l1 = new LinkedList<>();
        int k = f;
        int l = c-1;
        while (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
            l--;
        }
         k = f-1;
         l = c;
        while (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
            k--;
        }
        k = f;
         l = c+1;
        while (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
            l++;
        }
        k = f+1;
         l = c;
        while (posValida(m,k,l)) {
            l1.add(new Regla(k,l));
            k++;
        }
        return l1; 
    }
    
    public static void laberintosGenercos(int[][]m, int i, int j,int iFin, int jFin, int paso){
         if (!posValida(m,i,j)) {
            return;
        }
        m[i][j] = paso;
        if (i == iFin && j == jFin) {
            mostrar(m);
        }
        LinkedList<Regla>l1 = torre(m,i,j);
        while (!l1.isEmpty()) {
            Regla r = l1.removeFirst();
            laberintosGenercos(m,r.fil,r.col,iFin,jFin,paso+1);
            m[r.fil][r.col] = 0;
        }
        
    }
    
    
    
    
    
   
    
}
