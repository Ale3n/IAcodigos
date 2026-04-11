/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examplesia;

import java.util.LinkedList;

/**
 *
 * @author Tower
 */
public class PermutacionesYCombinaciones {

    /**
     * @param args the command line arguments
     */
     public static int c = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Se va a programar un torneo de ajedrez para los 10 integrantes de un club.
        //¿Cuántos partidos se deben programar si cada integrante jugará
        //con cada uno de los demás sin partidos de revancha?

        int r = 2;
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        L1.add(1);
        L1.add(2);
        L1.add(3);
        L1.add(4);
        L1.add(5);
        L1.add(6);
        L1.add(7);
        L1.add(8);
        L1.add(9);
        L1.add(10);

        combiSR(L1, L2, r, 0);
        System.out.println("Combinaciones totales = " + c); //45
        c = 0;

        // En una bodega hay cinco tipos diferentes de botellas.
        // ¿De cuántas formas se pueden elegir cuatro botellas?

        r = 4;
        LinkedList<String> L3 = new LinkedList<>();
        LinkedList<String> L4 = new LinkedList<>();

        L3.add("Coca cola");
        L3.add("Pepsi");
        L3.add("Simba");
        L3.add("Oro");
        L3.add("Guarana");

        combiCR(L3, L4, r, 0);
        System.out.println("Combinaciones totales = " + c); //70
        c = 0;

        // ¿Cuántas permutaciones sin repetidos se pueden formar con los digitos 1 al 6?

        r = 6;
        LinkedList<Integer> L5 = new LinkedList<>();
        LinkedList<Integer> L6 = new LinkedList<>();

        L5.add(1);
        L5.add(2);
        L5.add(3);
        L5.add(4);
        L5.add(5);
        L5.add(6);

        permutSR(L5, L6, r, 0);
        System.out.println("Combinaciones totales = " + c); //720
        c = 0;

        // ¿Cuántas permutaciones con repetidos se pueden formar con los digitos 1 al 6?

        r = 6;
        LinkedList<Integer> L7 = new LinkedList<>();
        LinkedList<Integer> L8 = new LinkedList<>();

        L7.add(1);
        L7.add(2);
        L7.add(3);
        L7.add(4);
        L7.add(5);
        L7.add(6);

        permutCR(L7, L8, r, 0);
        System.out.println("Combinaciones totales = " + c); //46656
    }
    // Combinaciones sin repetición
    public static void combiSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            c++;
            return;
        }
        int k = i;
        while (k < L1.size()) {
            L2.add(L1.get(k));
            combiSR(L1, L2, r, k + 1);
            L2.removeLast();
            k = k + 1;
        }
    }

    // Combinaciones con repetición
    public static void combiCR(LinkedList<String> L1, LinkedList<String> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            c++;
            return;
        }
        int k = i;
        while (k < L1.size()) {
            L2.add(L1.get(k));
            combiCR(L1, L2, r, k);
            L2.removeLast();
            k = k + 1;
        }
    }

    // Permutaciones con repetición
    public static void permutCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            c++;
            return;
        }
        int k = 0;
        while (k < L1.size()) {
            L2.add(L1.get(k));
            permutCR(L1, L2, r, k + 1);
            L2.removeLast();
            k = k + 1;
        }
    }

    // Permutaciones sin repetición
    public static void permutSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            c++;
            return;
        }
        int k = 0;
        while (k < L1.size()) {
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                permutSR(L1, L2, r, k + 1);
                L2.removeLast();
            }
            k = k + 1;
        }
    }
    
}
