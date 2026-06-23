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
public class principalTAR {

    /**
     * @param args the command line arguments
     */
    
    private static class Regla{
        int fil, col;

        public Regla(int fil, int col) {
            this.fil = fil;
            this.col = col;
        }
        
    }
    
   
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int [][] m = new int [a][b];
        laberintoGenerico(m,0,0,a-1,b-1,1);
    }
    
    private static boolean posValida(int[][] m, int f, int c){
        return (f>=0)&&(f < m.length)&&(c>=0)&&(c<m[f].length)&&(m[f][c]==0);
    }
    
    private static void mostrar(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    private static boolean casillasTodasVisitadas(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
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
    private static LinkedList<Regla> reglasAplicablesRey(int[][] m, int f, int c){//el rey tine 8 moviientos
        LinkedList<Regla> lista = new LinkedList<>();
        // izquierda
        int k = f;
        int l = c-1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // diag sup izq
        k = f-1;
        l = c-1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // arriba
        k = f-1;
        l = c;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // diag sup der
        k = f-1;
        l = c+1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // derecha
        k = f;
        l = c+1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // diag inf der
        k = f+1;
        l = c+1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // abajo
        k = f+1;
        l = c;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // diag inf izq
        k = f+1;
        l = c-1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        return lista;
    }
    
    
    private static LinkedList<Regla> reglasAplicablesSaltoCaballo(int[][] m, int f, int c){//el caballo tine 8
        LinkedList<Regla> lista = new LinkedList<>();
        // izquierda abajo
        int k = f+1;
        int l = c-2;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // izquierda arriba
        k = f-1;
        l = c-2;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // arriba izquierda
        k = f-2;
        l = c-1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // arriba derecha
        k = f-2;
        l = c+1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // derecha arriba
        k = f-1;
        l = c+2;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // derecha abajo
        k = f+1;
        l = c+2;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // abajo derecha
        k = f+2;
        l = c+1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        // abajo izquierda
        k = f+2;
        l = c-1;
        if (posValida(m, k, l)){
            lista.add(new Regla(k, l));
        }
        return lista;
    }
    
    
    private static LinkedList<Regla> reglasAplicablesTorre(int[][] m, int f, int c){
        LinkedList<Regla> lista = new LinkedList<>();
        // izquierda
        int k = f;
        int l = c-1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            l--;
        }
        // arriba
        k = f-1;
        l = c;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k--;
        }
        // derecha
        k = f;
        l = c+1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            l++;
        }
        // abajo
        k = f+1;
        l = c;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k++;
        }
        return lista;
    }
     
    private static LinkedList<Regla> reglasAplicablesAlfil(int [][] m, int f, int c){
        LinkedList<Regla> lista = new LinkedList<>();
        // diag sup izq
        int k = f-1;
        int l = c-1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k--;
            l--;
        }
        // diag sup der
        k = f-1;
        l = c+1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k--;
            l++;
        }
        // diag inf der
        k = f+1;
        l = c+1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k++;
            l++;
        }
        // diag inf izq
        k = f+1;
        l = c-1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k++;
            l--;
        }
        return lista;
    }
    
    
    private static LinkedList<Regla> reglasAplicablesDama(int[][] m, int f, int c){//8 movimiento
        LinkedList<Regla> lista = new LinkedList<>();
        // izquierda
        int k = f;
        int l = c-1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            l--;
        }
        // diag sup izq
        k = f-1;
        l = c-1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k--;
            l--;
        }
        // arriba
        k = f-1;
        l = c;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k--;
        }
        // diag sup der
        k = f-1;
        l = c+1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k--;
            l++;
        }
        // derecha
        k = f;
        l = c+1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            l++;
        }
        // diag inf der
        k = f+1;
        l = c+1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k++;
            l++;
        }
        // abajo
        k = f+1;
        l = c;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k++;
        }
        // diag inf izq
        k = f+1;
        l = c-1;
        while (posValida(m, k, l)){
            lista.add(new Regla(k, l));
            k++;
            l--;
        }
        return lista;
    }
    
    private static void laberintoGenerico(int[][] m, int i, int j, int iFin, int jFin, int paso){
        if(!posValida(m, i, j)){
            return;
        }
        m[i][j] = paso;
        if (i==iFin && j==jFin){  
            mostrar(m);
        }
        LinkedList<Regla> l1 = reglasAplicablesDama(m, i, j);
        while (!l1.isEmpty()){
            Regla R = l1.removeFirst();
            laberintoGenerico(m, R.fil, R.col, iFin, jFin, paso+1);
            m[R.fil][R.col] = 0;
        }  
    }
}
