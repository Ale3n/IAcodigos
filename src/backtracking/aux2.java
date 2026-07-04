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
public class aux2 {

    /**
     * @param args the command line arguments
     */
    static int paso, back;
    
    static class regla{
        int f, c;

        public regla(int f, int c) {
            this.f = f;
            this.c = c;
        }
        
    }//ESTE ES EL PROBLEMA DE LAS N REINAS
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 4,b = 4;
        int[][]m = new int[a][b];
        if (rsh(m,1)) {
            mostrar(m);
            System.out.println("pasos"+ paso);
            System.out.println("back"+ back);
        }else{
            System.out.println("no hay soloccion");
            
            
        }
        
    }
    
    /*static void mostrar(int [][]m){
        for (int[] is : m) {
            for (int i : is) {
                System.out.print(i+"\t");
            }System.out.println("");
        }System.out.println("");
    }*/
    
    static void mostrar(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    static boolean posr(int [][]m, int i, int j){
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < m.length; l++) {
                if(m[k][l]!=0 && (j==l || Math.abs(k-i) == Math.abs(l-j)))
                    return false;
            }
        }
        return true;
    }
   
    
    static LinkedList<regla> reina(int[][]m, int p){
        LinkedList<regla> l = new LinkedList<>();
        for (int k = 0; k < m.length; k++) {
            if(posr(m, p, k)) l.add(new regla(p, k));
        }
        return l;
                
    }
    
    //reina
    static boolean rsh(int[][]m,int p){
        paso++;
        if(p> m.length)return true;
        
        LinkedList<regla> l = reina(m, p-1);
        while(!l.isEmpty()){
            regla r = l.removeFirst();
            m[r.f][r.c]=p;
            if(rsh(m, p+1)) return true;
            m[r.f][r.c]=0;
            back ++;
        }
        
        return false;
    }
    static boolean rch(int[][]m,int p){
        paso++;
        if(p> m.length)return true;
        
        LinkedList<regla> l = reina(m, p-1);
        while(!l.isEmpty()){
            regla r = l.remove(l.size()/2);
            m[r.f][r.c]=p;
            if(rch(m, p+1)) return true;
            m[r.f][r.c]=0;
            back ++;
        }
        
        return false;
    }
    
    
    
    
    
    /*private static boolean posValida(int[][]m, int f, int c){
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
    }*/
    
    
    
    
    
    
    
}
