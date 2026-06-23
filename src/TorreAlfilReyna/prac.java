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
        int fil;
        int col;
        public Regla(int i, int j){
            this.fil = i;
            this.col = j;
        }
    }
    public static void main(String[] args) {
        int a = 2,b = 2;
        int[][]m = new int[a][b];
        laberintoGenrico(m,0,0,a-1,b-1,1);
    }
    
    public static boolean posvalida(int[][]m,int i,int j){
        return(i>=0 && i <m.length && j>=0 && j<m[i].length && m[i][j] == 0);
    }
    public static void mostrar(int[][]m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void rey1(int[][]m,int i,int j,int ifin,int jfin,int paso){
        if (!posvalida(m,i,j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            mostrar(m);
        }
        rey1(m,i,j-1,ifin,jfin,paso+1);
        rey1(m,i-1,j-1,ifin,jfin,paso+1);
        rey1(m,i-1,j,ifin,jfin,paso+1);
        rey1(m,i-1,j+1,ifin,jfin,paso+1);
        
        rey1(m,i,j+1,ifin,jfin,paso+1);
        rey1(m,i+1,j+1,ifin,jfin,paso+1);
        rey1(m,i+1,j,ifin,jfin,paso+1);
        rey1(m,i+1,j-1,ifin,jfin,paso+1);
        m[i][j] = 0;
    }
    public static void laberintoGenrico(int[][]m,int i,int j,int ifin,int jfin,int paso){
        if (!posvalida(m,i,j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            mostrar(m);
        }
        LinkedList<Regla>l1=rey2(m,i,j);
        while (!l1.isEmpty()) {
            Regla r = l1.removeFirst();
            laberintoGenrico(m,r.fil,r.col,ifin,jfin,paso+1);
            m[r.fil][r.col] = 0;
        }
    }
    public static LinkedList<Regla> rey2(int[][]m,int f,int c){
        LinkedList<Regla>l1= new LinkedList<>();
        int k = f;
        int l = c-1;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
         k = f-1;
         l = c-1;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f-1;
         l = c;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f-1;
         l = c+1;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        
        k = f;
         l = c+1;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c+1;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        k = f+1;
         l = c-1;
        if (posvalida(m,k,l)) {
            l1.add(new Regla(k,l));
        }
        return l1;
        
        
    }
    
    
    
    
    
   
}
    
    
    
    
    
    
    
    
    

