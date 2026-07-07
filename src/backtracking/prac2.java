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
public class prac2 {

    /**
     * @param args the command line arguments
     */
    public static int cant = 0;
    public static int back = 0;
    
    public static class regla{
        int f,c;
        public regla(int i, int j){
            this.f = i;
            this.c = j;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 11;
        int m[][] = new int[a][a];
        if (reinacs(m,1)) {
            mostrar(m);
            System.out.println(cant);
            System.out.println(back);
        } else {
            System.out.println("no hay resul");
        }
        /*m[2][3] = 2;
        m[4][2] = 2;
        if (sudoku(m,0,0)) {
            mostrar(m);
            System.out.println(cant);
            System.out.println(back);
        } else {
            System.out.println("no hay resul");
        }*/
    }
    
    public static void mostrar(int m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static boolean reinacs(int m[][], int p){
        cant++;
        if (p>m.length) {
            return true;
        }
        LinkedList<regla>l = raplica(m,p-1);
        while (!l.isEmpty()) {
            //regla r = mejorR(l,m.length);
            //regla r = l.remove(l.size()/2);
            regla r = l.removeFirst();
            m[r.f][r.c] = p;
            if (reinacs(m,p+1)) {
                return true;
            }
            m[r.f][r.c] = 0;
            back++;
        }
        return false; 
    }
    public static LinkedList<regla> raplica(int m[][], int p){
        LinkedList<regla>l = new LinkedList<>();
        for (int k = 0; k < m.length; k++) {
            if (posvar(m,p,k)) {
                l.add(new regla(p,k));
            }
        }
        return l;
    }
    
    public static boolean posvar(int m[][], int i,int j){
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < m.length; l++) {
                if (m[k][l]!=0 && (l == j || Math.abs(k-i) == Math.abs(l-j))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static regla mejorR(LinkedList<regla> l, int n){
        int centro = n / 2;
        int pos = 0;
        int mejor = Math.abs(l.get(0).c - centro);

        for(int i = 1; i < l.size(); i++){
            int d = Math.abs(l.get(i).c - centro);
            if(d < mejor){
                mejor = d;
                pos = i;
            }
        }
        return l.remove(pos);
    }
    
    public static boolean sudoku(int m[][], int i, int j){
        cant++;
        if(i>=m.length) return true;
        if(j>=m[i].length) return sudoku(m,i+1,0);
        if(m[i][j]!=0) return sudoku(m,i,j+1);
        
        
        LinkedList<Integer>l = raplicas(m,i,j);
        while (!l.isEmpty()) {       
            int r = l.removeFirst();
            //int r = best(l);
            m[i][j] = r;
            if (sudoku(m,i,j+1)) {
                return true;
            }
            m[i][j] = 0;
            back++;
        }
        return false; 
    }
    
    public static LinkedList<Integer> raplicas(int m[][], int i,int j){
        LinkedList<Integer>l = new LinkedList<>();
        for (int v = 1; v <=m.length; v++) {
            if (!enfil(m,i,v) && !encol(m,j,v) && !enregion(m,i,j,v)) {
                l.add(v);
            }
        }
        return l;
    }
    
    public static boolean enfil(int m[][], int i,int v){
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] == v) {
                return true;
            }
        }
        return false;
    }
    public static boolean encol(int m[][], int j,int v){
        for (int i = 0; i < m.length; i++) {
            if (m[i][j] == v) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean enregion(int m[][], int i,int j, int v){
        int nfil = (int)Math.sqrt(m.length);
        int ncol = (int)Math.sqrt(m[i].length);
        
        int iregion = (i/nfil)*nfil;
        int jregion = (j/ncol)*ncol;
        
        for (int a = iregion; a < iregion + nfil; a++) {
            for (int b = jregion; b < jregion + ncol; b++) {
                if (m[a][b]==v) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean band = true;
    public static int best(LinkedList<Integer>l){
        if (band) {
            band = false;
            return l.removeFirst();
        } else {
            band = true;
            return l.removeLast();
        }
    }
  
    
}
