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
public class sudoku {

    /**
     * @param args the command line arguments
     */
    
    public static int cant = 0;
    public static int back = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        int m[][] = new int[9][9];
        
        //m[0][1] = 1;
        //m[1][3] = 3;
        
        //mostrar(m);
        if (sudoku(m,0,0)) {
            System.out.println("tiene solucion");
            mostrar(m);
            System.out.println(cant);
            System.out.println(back);
        } else {
            System.out.println("no tiene solucion");
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
    
    public static boolean sudoku(int m[][], int i, int j){
        cant++;
        if(i >= m.length) return true;
        if(j >= m[i].length) return sudoku(m, i + 1, 0);
        if(m[i][j] != 0) return sudoku(m, i, j + 1);

        LinkedList<Integer> L1 = reglasAplicables(m, i, j);
        while(!L1.isEmpty()){
            //m[i][j] = L1.removeFirst();
            m[i][j] = L1.removeLast();
            //m[i][j] = mejorR(L1);
            if(sudoku(m, i, j + 1)) return true;
            m[i][j] = 0;
            back++;
        }

        return false;
    }
    
    public static LinkedList<Integer> reglasAplicables(int m[][], int i, int j){
        LinkedList<Integer> L1 = new LinkedList();

        for (int valor = 1; valor <= m.length; valor++) {
            if( !enFila(m, i, valor) &&
                !enColumna(m, j, valor) &&
                !enRegion(m, i, j, valor) )
                L1.add(valor);
        }

        return L1;
    }
    
    public static boolean enFila(int m[][], int i, int valor){
        for (int j = 0; j < m[i].length; j++) {
            if(m[i][j] == valor) return true;
        }
        return false;
    }

    public static boolean enColumna(int m[][], int j, int valor){
        for (int i = 0; i < m.length; i++) {
            if(m[i][j] == valor) return true;
        }
        return false;
    }
    
    public static boolean enRegion(int m[][], int i, int j, int valor){
        int nFil = (int)Math.sqrt(m.length);
        int nCol = (int)Math.sqrt(m[i].length);

        int iRegion = (i / nFil) * nFil;
        int jRegion = (j / nCol) * nCol;

        for(int a = iRegion; a < iRegion + nFil; a++){
            for(int b = jRegion; b < jRegion + nCol; b++){
                if(m[a][b] == valor) return true;
            }
        }

        return false;
    }
    
    /*private static int mejorR(LinkedList<Integer> L1){
        int pos = 0;
        int mejor = L1.get(0);

        for (int i = 1; i < L1.size(); i++) {
            if(L1.get(i) < mejor){      // ejemplo: escoger el menor valor
                mejor = L1.get(i);
                pos = i;
            }
        }

        return L1.remove(pos);
    }*/
    /*private static int mejorR(LinkedList<Integer> L1){
        return L1.remove(L1.size()/2);
    }*/
    
    /*private static int mejorR(LinkedList<Integer> L1){
        return L1.removeLast();
    }*/
    static boolean primero = true;

    private static int mejorR(LinkedList<Integer> L1){
        if (primero) {
            primero = false;
            return L1.removeFirst();
        } else {
            primero = true;
            return L1.removeLast();
        }
    }
    
    
    
    
}
