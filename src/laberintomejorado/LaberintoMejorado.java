/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberintomejorado;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author examp
 */
public class LaberintoMejorado {

    /**
     * @param args the command line arguments
     */
    public static int cantSol = 0;
    public static int maxPaso;
    public static int minPaso;

    public static class Regla {

        public int fil, col;

        public Regla(int fil, int col) {
            this.fil = fil;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int a = 4;
        int b = 4;

        int m[][] = new int[a][b];
        maxPaso = 0;
        minPaso = a + b;

        LinkedList<int[][]> l = new LinkedList<int[][]>();
        
        System.out.println("******* Matriz Inicial *******");
        //System.out.println("Con atajos o paredes : ");
        //ponerParedMatriz(m, a);
        mostrar(m);
        //laberintoA(m, 0, 0, a-1, b-1, 1);        
        //laberintoB(m, 0, 0, a - 1, b - 1, 1);
        //laberintoC(m, 0, 0, a-1, b-1, 1);        
        laberintoD(m, 0, 0, a-1, b-1, 1);
        //laberintoE(m, 0, 0, a-1, b-1, 1);
        
        //System.out.println("soluciones : " + cantSol);
        
        //laberintoSaltoCaballoEnLista(l, m, 0, 0, a - 1, b - 1, 1);
        //mostrarListaMat(l);
        //System.out.println("Cantidad de soluciones : " + l.size());
    }
    
    private static void ponerParedMatriz(int m[][], int cantPared) {
        boolean posValida;
        int n = m.length;
        int f, c;
        for (int i = 1; i <= cantPared; i++) {
            posValida = false;
            while (!posValida) {
                f = ThreadLocalRandom.current().nextInt(0, n);
                c = ThreadLocalRandom.current().nextInt(0, n);
                if (!(f == 0 && c == 0) && !(c == n - 1 && f == n - 1)) {
                    if (m[f][c] == 0) {
                        m[f][c] = -1;
                        posValida = true;
                    }
                }
            }
        }
    }

    public static void laberintoA(int[][] m, int i, int j, int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == iFin && j == jFin) {
            cantSol++;
            System.out.println("Solución nro. : " + cantSol);
            mostrar(m);            
        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoA(m, R.fil, R.col, iFin, jFin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoB(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && todasCasillasVisitadas(m)) {
            cantSol++;
            System.out.println("Solución nro. : " + cantSol);
            mostrar(m);
        }
        LinkedList L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoB(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static boolean todasCasillasVisitadas(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void laberintoC(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && !todasCasillasVisitadas(m)) {
            cantSol++;
            System.out.println("Solución nro. : " + cantSol);
            mostrar(m);
        } else {
            LinkedList L1 = reglasAplicables(m, i, j);
            while (!L1.isEmpty()) {
                Regla R = elegirRegla(L1);
                laberintoC(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
        }
    }

    public static void laberintoD(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && paso >= maxPaso) {
            cantSol++;
            maxPaso = paso;  // maxPaso variable global
            System.out.println("Solución nro. : " + cantSol);
            mostrar(m);
        } else {
            LinkedList L1 = reglasAplicables(m, i, j);
            while (!L1.isEmpty()) {
                Regla R = elegirRegla(L1);
                laberintoD(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
        }
    }

    public static void laberintoE(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && paso <= minPaso) {
            cantSol++;
            minPaso = paso;  // minPaso variable global
            System.out.println("Solución nro. : " + cantSol);
            mostrar(m);
        } else {
            LinkedList L1 = reglasAplicables(m, i, j);
            while (!L1.isEmpty()) {
                Regla R = elegirRegla(L1);
                laberintoE(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
        }
    }

    private static LinkedList reglasAplicablesMasDiagonal(int[][] m, int i, int j) {
        LinkedList L1 = new LinkedList<>();
        if (posValida(m, i, j - 1)) {
            L1.add(new Regla(i, j - 1));
        }
        if (posValida(m, i - 1, j - 1)) {
            L1.add(new Regla(i - 1, j - 1));
        }
        if (posValida(m, i - 1, j)) {
            L1.add(new Regla(i - 1, j));
        }
        if (posValida(m, i - 1, j + 1)) {
            L1.add(new Regla(i - 1, j + 1));
        }
        if (posValida(m, i, j + 1)) {
            L1.add(new Regla(i, j + 1));
        }
        if (posValida(m, i + 1, j + 1)) {
            L1.add(new Regla(i + 1, j + 1));
        }
        if (posValida(m, i + 1, j)) {
            L1.add(new Regla(i + 1, j));
        }
        if (posValida(m, i + 1, j - 1)) {
            L1.add(new Regla(i + 1, j - 1));
        }
        return L1;
    }

    public static void laberintoDiagonalA(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            cantSol++;
            mostrar(m);
        }

        LinkedList L1 = reglasAplicablesMasDiagonal(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoDiagonalA(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoDiagonalB(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && todasCasillasVisitadas(m)) {
            mostrar(m);
        }
        LinkedList L1 = reglasAplicablesMasDiagonal(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoDiagonalB(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoDiagonalC(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;

        if (i == ifin && j == jfin && !todasCasillasVisitadas(m)) {
            cantSol++;
            mostrar(m);
        } else {
            LinkedList<Regla> L1 = reglasAplicablesMasDiagonal(m, i, j);
            while (!L1.isEmpty()) {
                Regla R = elegirRegla(L1);
                laberintoDiagonalC(m, R.fil, R.col, ifin, jfin, paso + 1);
                m[R.fil][R.col] = 0;
            }
        }
    }

    public static void laberintoSoloDiagonalA(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            cantSol++;
            mostrar(m);
        }

        LinkedList L1 = reglasAplicablesDiagonales(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSoloDiagonalA(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoSoloDiagonalB(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && todasCasillasVisitadas(m)) {
            mostrar(m);
        }
        LinkedList L1 = reglasAplicablesDiagonales(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSoloDiagonalB(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoSoloDiagonalC(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;

        if (i == ifin && j == jfin && !todasCasillasVisitadas(m)) {
            cantSol++;
            mostrar(m);
        }
        LinkedList<Regla> L1 = reglasAplicablesDiagonales(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSoloDiagonalC(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoEnListaDeMatrices(LinkedList<int[][]> l, int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && todasCasillasVisitadas(m)) {
            int m1[][] = new int[m.length][m[0].length];
            copiarMatriz(m, m1);
            l.add(m1);
        }
        LinkedList<Regla> L1 = reglasAplicables(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoEnListaDeMatrices(l, m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    private static void copiarMatriz(int mA[][], int mB[][]) {
        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mA[i].length; j++) {
                mB[i][j] = mA[i][j];
            }
        }
    }

    private static void mostrarListaMat(LinkedList<int[][]> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.println("Solución no. : " + (i+1));
            mostrar(l.get(i));
        }
    }

    public static Regla elegirRegla(LinkedList<Regla> l1) {
        return l1.removeFirst();
    }

    private static void mostrar(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static boolean posValida(int[][] m, int i, int j) {
        return (i >= 0 && i < m.length && j >= 0 && j < m[i].length && m[i][j] == 0);
    }
    
    
    
    public static LinkedList<Regla> reglasAplicables(int[][] m, int i, int j) {
        LinkedList<Regla> L1 = new LinkedList<>();
        if (posValida(m, i, j - 1)) {
            L1.add(new Regla(i, j - 1));
        }
        if (posValida(m, i - 1, j)) {
            L1.add(new Regla(i - 1, j));
        }
        if (posValida(m, i, j + 1)) {
            L1.add(new Regla(i, j + 1));
        }
        if (posValida(m, i + 1, j)) {
            L1.add(new Regla(i + 1, j));
        }
        return L1;
    }
    
    private static LinkedList<Regla> reglasAplicables2(int[][] m , int i,int j){
        LinkedList<Regla> l1 = new LinkedList<>();
        if (posValida(m,i,j-1)) {
            l1.add(new Regla(i,j-1));
        }
        if (posValida(m,i-1,j)) {
            l1.add(new Regla(i-1,j));
        }
        if (posValida(m,i,j+1)) {
            l1.add(new Regla(i,j+1));
        }
        if (posValida(m,i+1,j)) {
            l1.add(new Regla(i+1,j));
        }
        return l1;
    }
    
    
    

    private static LinkedList reglasAplicablesDiagonales(int[][] m, int i, int j) {
        LinkedList L1 = new LinkedList<>();
        if (posValida(m, i - 1, j - 1)) {
            L1.add(new Regla(i - 1, j - 1));
        }
        if (posValida(m, i - 1, j + 1)) {
            L1.add(new Regla(i - 1, j + 1));
        }
        if (posValida(m, i + 1, j + 1)) {
            L1.add(new Regla(i + 1, j + 1));
        }
        if (posValida(m, i + 1, j - 1)) {
            L1.add(new Regla(i + 1, j - 1));
        }
        return L1;
    }

    // Algoritmos para el salto del caballo...
    private static LinkedList<Regla> reglasAplicablesSaltoCaballo(int[][] m, int i, int j) {
        LinkedList L1 = new LinkedList<>();
        if (posValida(m, i + 1, j - 2)) {
            L1.add(new Regla(i + 1, j - 2));
        }
        if (posValida(m, i - 1, j - 2)) {
            L1.add(new Regla(i - 1, j - 2));
        }
        if (posValida(m, i - 2, j - 1)) {
            L1.add(new Regla(i - 2, j - 1));
        }
        if (posValida(m, i - 2, j + 1)) {
            L1.add(new Regla(i - 2, j + 1));
        }
        if (posValida(m, i - 1, j + 2)) {
            L1.add(new Regla(i - 1, j + 2));
        }
        if (posValida(m, i + 1, j + 2)) {
            L1.add(new Regla(i + 1, j + 2));
        }
        if (posValida(m, i + 2, j + 1)) {
            L1.add(new Regla(i + 2, j + 1));
        }
        if (posValida(m, i + 2, j - 1)) {
            L1.add(new Regla(i + 2, j - 1));
        }
        return L1;
    }

    public static void laberintoSaltoCaballoA(int[][] m, int i, int j, int iFin, int jFin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == iFin && j == jFin) {
            mostrar(m);
            cantSol++;
        }
        LinkedList<Regla> L1 = reglasAplicablesSaltoCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSaltoCaballoA(m, R.fil, R.col, iFin, jFin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoSaltoCaballoB(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && todasCasillasVisitadas(m)) {
            cantSol++;
            mostrar(m);
        }
        LinkedList L1 = reglasAplicablesSaltoCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSaltoCaballoB(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoSaltoCaballoC(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && !todasCasillasVisitadas(m)) {
            cantSol++;
            mostrar(m);
        }
        LinkedList L1 = reglasAplicablesSaltoCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSaltoCaballoC(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoSaltoCaballoD(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && paso >= maxPaso) {
            cantSol++;
            maxPaso = paso;  // maxPaso variable global
            mostrar(m);
        }
        LinkedList L1 = reglasAplicablesSaltoCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSaltoCaballoD(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

    public static void laberintoSaltoCaballoE(int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && paso <= minPaso) {
            cantSol++;
            minPaso = paso;  // minPaso variable global
            mostrar(m);
        }
        LinkedList L1 = reglasAplicablesSaltoCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSaltoCaballoE(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }
    
    public static void laberintoSaltoCaballoEnLista(LinkedList<int[][]> l, int[][] m, int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin && paso <= minPaso) {
            minPaso = paso;  // minPaso variable global
            int m1[][] = new int[m.length][m[0].length];
            copiarMatriz(m, m1);
            l.add(m1);
        }
        LinkedList L1 = reglasAplicablesSaltoCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = elegirRegla(L1);
            laberintoSaltoCaballoEnLista(l, m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }

}
