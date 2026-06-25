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
public class princi {

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
    private static int cantPaso=0;
    private static int cantPasoAtras=0;
    
    public static void mostrar(int[][]m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean posValida(int[][] m, int i, int j){
        return(i>=0 && i < m.length && j>=0 && j <m[i].length && m[i][j] == 0);
    }
    public static LinkedList<Regla> reglasAplicablesLa(int m[][], int f,int c){
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
    
    public static void main(String[] args) {
        int a = 5, b = 5;
        int m[][] = new int[a][b];
        
        //m[0][3] = -1;
        if (labCaballoSH(m,0,0,4,4,1)) {
            mostrar(m);
            System.out.println("la cantidad de pasos es  " + cantPaso);
            System.out.println("la cantidad hacia atras  "+ cantPasoAtras);
        }else{
            System.out.println("Esol");
        }  

        
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
    public static Regla elegirMejorReglaCaballo(LinkedList<Regla> l, int[][] m){
        int mejor = 0;
        int menor = Integer.MAX_VALUE;
        for(int i = 0; i < l.size(); i++){
            Regla r = l.get(i);
            int cant = cantidadMovimientos(m, r.fil, r.col);
            if(cant < menor){
                menor = cant;
                mejor = i;
            }
        }
        return l.remove(mejor);
    }
    public static int cantidadMovimientos(int[][] m, int i, int j){
        return reglasAplicablesSaltoCaballo(m, i, j).size();
    }
    
    
    public static boolean laberinto(int m[][], int i, int j, int ifin, int jfin, int paso){
        cantPaso++;
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            return true;
        }
        LinkedList<Regla>l1 = reglasAplicablesLa(m,i,j);
        while (!l1.isEmpty()) {
            Regla r = elegirMejorRegla(l1,ifin,jfin);
            //Regla r = l1.removeFirst();
            if (laberinto(m,r.fil,r.col,ifin,jfin,paso+1)) {
                return true;
            }
            cantPasoAtras++;
            m[r.fil][r.col] = 0;
        }
        return false;
    }
    

    public static boolean labCaballoSH(int m[][], int i, int j, int ifin, 
            int jfin, int paso) {
        m[i][j] = paso;
        cantPaso++;
        if (i == ifin && j == jfin && paso == (m.length * m[0].length)) {
            return true;
        }
        LinkedList<Regla> l = reglasAplicablesSaltoCaballo(m, i, j);
        while (!l.isEmpty()) {
            //Regla r = l.removeFirst();
            Regla r = elegirMejorReglaCaballo(l, m);
            if (labCaballoSH(m, r.fil, r.col, ifin, jfin, paso + 1)) {
                return true;
            }
            cantPasoAtras++;
            m[r.fil][r.col] = 0;
        }
        return false;
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
    
    
    
    
}
