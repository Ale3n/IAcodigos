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
public class SolucionesEnListasDeListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static int suma(LinkedList<Integer> L1){
        int sum = 0;
        for (int i = 0; i < L1.size(); i++) {
            sum += L1.get(i);
        }
        return sum;
    }

    public static void sumandos(LinkedList<Integer> L1,
        LinkedList<LinkedList<Integer>> L2, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n){
            L1.add(k);
            sumandos(L1, L2, n, k);
            L1.removeLast();
            k++;
        }
    }

    public static void sumandosPRI(LinkedList<Integer> L1,
        LinkedList<LinkedList<Integer>> L2, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n){
            if (primo(k)) {
                L1.add(k);
                sumandosPRI(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }

    public static boolean primo(int n){
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void sumandosDIF(LinkedList<Integer> L1,
        LinkedList<LinkedList<Integer>> L2, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n){
            if (!L1.contains(k)) {
                L1.add(k);
                sumandosDIF(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }

    public static int c = 0;

    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2,
        LinkedList<LinkedList<Integer>> L3, int max, int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        L3.add(new LinkedList<>(L2));
        c++;
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1, L2, L3, max, k + 1);
            L2.removeLast();
            k++;
        }
    }

    public static void proximos(LinkedList<LinkedList<Integer>> L1,
        LinkedList<LinkedList<Integer>> L2, int max){
        for (int i = 0; i < L1.size(); i++) {
            if (suma(L1.get(i)) == max) {
                L2.add(new LinkedList<>(L1.get(i)));
            }
        }
        if (L2.size() == 0) {
            proximos(L1, L2, max - 1);
        }
    }

    public static void mochilaRAN(LinkedList<Integer> L1,
        LinkedList<Integer> L2, LinkedList<LinkedList<Integer>> L3,
        int max, int i, int a, int b){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        L3.add(new LinkedList<>(L2));
        c++;
        int k = i;
        while (k < L1.size()){
            if (L1.get(k) >= a && L1.get(k) <= b) {
                L2.add(L1.get(k));
                mochilaRAN(L1, L2, L3, max, k + 1, a, b);
                L2.removeLast();
            }
            k++;
        }
    }


    
}
