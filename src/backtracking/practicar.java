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
public class practicar {

    /**
     * @param args the command line arguments
     */
    public static int cant = 0;
    public static int back = 0;
    public static class Regla{
        int f,c;
        public Regla(int f,int c){
            this.f = f;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 9,b = 9;
        int m[][] = new int[a][b];
        /*if (reinasCHSH(m,1)) {
            mostrar(m);
            System.out.println(cant);
            System.out.println(back);
        } else {
            System.out.println("no hay");
        }*/
        
        if (sudoku(m,0,0)) {
            mostrar(m);
            System.out.println(cant);
            System.out.println(back);
        } else {
            System.out.println("no hay");
        }
    }
    public static void mostrar(int[][]m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean reinasCHSH(int m[][], int p){
        cant++;
        if (p>m.length) {
            return true;
        }
        LinkedList<Regla>l = reina(m,p-1);
        while (!l.isEmpty()) {
            //Regla r = l.removeFirst();
            Regla r = l.remove(l.size()/2);
            m[r.f][r.c] = p;
            if (reinasCHSH(m,p+1)) {
                return true;
            }
            m[r.f][r.c] = 0;
            back++;
        }
        return false;
        
    }
    public static  LinkedList<Regla> reina(int m[][], int p){
         LinkedList<Regla>l = new  LinkedList<>();
         for (int k = 0; k < m.length; k++) {
             if (posval(m,p,k)) {
                 l.add(new Regla(p,k));
             }
        }
         return l;
    }
    public static  boolean posval(int m[][], int i,int j){
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < m.length; l++) {
                if (m[k][l] != 0 && (l == j || Math.abs(k-i) == Math.abs(l-j))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    //
    public static boolean sudoku(int m[][], int i, int j){
        cant++;
        if(i>=m.length) return true;
        if(j>=m[i].length) return sudoku(m,i+1,0);
        if(m[i][j]!=0) return sudoku(m,i,j+1);
        
        LinkedList<Integer>l = raplica(m,i,j);
        while (!l.isEmpty()) {
            m[i][j] = l.removeFirst();
            if (sudoku(m,i,j+1)) {
                return true;
            }
            m[i][j] = 0;
            back++;
        }
        return false;
    }
    
    public static  LinkedList<Integer> raplica(int m[][], int i, int j){
        LinkedList<Integer>l = new  LinkedList<>();
        for (int v = 1; v <=m.length; v++) {
            if (!enfila(m,i,v) && !encol(m,j,v) && !enregion(m,i,j,v)) {
                l.add(v);
            }
        }
        return l;  
    }
    
    public static boolean enfila(int m[][], int i,int v){
        for (int j = 0; j < m[i].length; j++) {
            if(m[i][j] == v)return true;
        }
        return false;
    }
    public static boolean encol(int m[][], int j,int v){
        for (int i = 0; i < m.length; i++) {
            if(m[i][j] == v)return true;
        }
        return false;
    }
    public static boolean enregion(int m[][], int i,int j,int v){
        int nfil = (int)Math.sqrt(m.length);
        int ncol = (int)Math.sqrt(m[i].length);
        
        int iregion = (i/nfil)*nfil;
        int jregion = (j/ncol)*ncol;
        
        for (int a = iregion; a < iregion + nfil; a++) {
            for (int b = jregion; b < jregion + ncol; b++) {
                if (m[a][b] == v) {
                    return true;
                }
            }
        }
        return false;     
    }
    public static boolean ban = true;
    public static int mejorR(LinkedList<Integer>l){
        if (ban) {
            ban = false;
            return l.removeFirst();
        }else{
            ban = true;
            return l.removeLast();
        }
        
    }
    
    
}
