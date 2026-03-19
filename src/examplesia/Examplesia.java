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
public class Examplesia {

     public static int c = 0;
    public static void main(String[] args) {
            // TODO code application logic here
        LinkedList<Integer> L1 = new LinkedList<>();
        //Sumandos
        //sumandos(L1, 7, 1);
//        sumandosDIF(L1,12,1);
//        sumandosIGU(L1, 12, 1);
//        sumandosPRI(L1, 12, 1);
//        sumandosRAN(L1, 12, 2, 5);
        //Factores
        factores(L1, 6, 2);
//        factoresDIF(L1, 81, 2);
//        factoresIGU(L1, 81, 2);
//        factoresPRI(L1, 81, 2);
//        factoresRAN(L1, 81, 2, 28);
        //Mochila
        /*LinkedList<Integer> L2 = new LinkedList<>();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        mochila(L1, L2, 34, 0);
//        mochilaDIF(L1, L2, 34, 0);
//        mochilaRAN(L1, L2, 34, 0, 2, 5);
        mochilaEXT(L1, L2, 15, 0);
        for (int i = 0; i < CombiEXT.size(); i++) {
            System.out.println(CombiEXT.get(i));
        }
//        mochilaMEJ(L1, L2, 34, 0);
//        for (int i = 0; i < CombiMEJ.size(); i++) {
//            System.out.println(CombiMEJ.get(i));
//        }C
        System.out.println("Sol = "+ c);   */       
    }
    
    //Sumandos
    public static int suma(LinkedList<Integer> L1){
        int Total = 0;
        for (int i = 0; i < L1.size(); i++) {
            Total += L1.get(i);
        }
        return Total;
    }
    
    public static void sumandos(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            L1.add(k);
            sumandos(L1, n, k);
            L1.removeLast();
            k++;
        }
    }
    //Encontrar todos los sumandos posibles diferentes en una Lista.
    public static void sumandosDIF(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            if (!L1.contains(k)) {
                L1.add(k);
                sumandosDIF(L1, n, k);
                L1.removeLast(); 
            }
            k++;
        }
    }
    //Encontrar todos los sumandos posibles iguales en una Lista.
    public static void sumandosIGU(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            if (L1.isEmpty() || L1.get(0) == k) {
                L1.add(k);
                sumandosIGU(L1, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    
    public static boolean Primo(int n){
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    //Encontrar todos los sumandos primos posibles en una Lista.
    public static void sumandosPRI(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            if (Primo(k)) {
                L1.add(k);
                sumandosPRI(L1, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    
    public static void sumandosRAN(LinkedList<Integer> L1, int n, int a, int b){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        int k = a;
        while (k <= b){
            L1.add(k);
            sumandosRAN(L1, n, k, b);
            L1.removeLast();
            k++;
        }
    }
    
    //Factores
    public static int mult(LinkedList<Integer> L1){
        int Total = 1;
        for (int i = 0; i < L1.size(); i++) {
            Total *= L1.get(i);
        }
        return Total;
    }
    //Encontrar los factores posibles en una Lista
    public static void factores(LinkedList<Integer> L1, int n, int i){
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            L1.add(k);
            factores(L1, n, k);
            L1.removeLast();
            k++;
        }
    }
    
    public static void factoresDIF(LinkedList<Integer> L1, int n, int i){
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            if (!L1.contains(k)) {
                L1.add(k);
                factoresDIF(L1, n, k);
                L1.removeLast(); 
            }
            k++;
        }
    }
    
    public static void factoresIGU(LinkedList<Integer> L1, int n, int i){
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            if (L1.isEmpty() || L1.get(0) == k) {
                L1.add(k);
                factoresIGU(L1, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    
    public static void factoresPRI(LinkedList<Integer> L1, int n, int i){
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k <= n){
            if (Primo(k)) {
                L1.add(k);
                factoresPRI(L1, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    
    public static void factoresRAN(LinkedList<Integer> L1, int n, int a, int b){
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            System.out.println(L1);
            return;
        }
        int k = a;
        while (k <= b){
            L1.add(k);
            factoresRAN(L1, n, k, b);
            L1.removeLast();
            k++;
        }
    }
    
    //Mochila
    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        System.out.println(L2);
        c++;
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1, L2, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    
    public static void mochilaDIF(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        System.out.println(L2);
        c++;
        int k = i;
        while (k < L1.size()){
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                mochilaDIF(L1, L2, max, k + 1);
                L2.removeLast();
            }
            k++;
        }
    }
    
    public static void mochilaRAN(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i,int a, int b){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        System.out.println(L2);
        c++;
        int k =i;
        while (k < L1.size()){
            if (L1.get(k) >= a && L1.get(k) <= b) {
                L2.add(L1.get(k));
                mochilaRAN(L1, L2, max, k + 1, a, b);
                L2.removeLast();
            }
            k++;
        }
    }
    
    public static LinkedList<LinkedList<Integer>> CombiEXT = new LinkedList<>();
    public static int Tamaño = 0;
    
    public static void mochilaEXT(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        if (L2.size() > Tamaño) {
            Tamaño = L2.size();
            CombiEXT.clear();
            CombiEXT.add(new LinkedList<>(L2));
            c=1;
        }else if ((L2.size() == Tamaño) && (Tamaño > 0)) {
             CombiEXT.add(new LinkedList<>(L2));
        }
        c++;
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochilaEXT(L1, L2, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    
    public static LinkedList<LinkedList<Integer>> CombiMEJ = new LinkedList<>();
    public static int MEJPeso = Integer.MAX_VALUE;
    
    public static void mochilaMEJ(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        int dif = max - sum;
        if (dif < MEJPeso) {
            MEJPeso = dif;
            CombiMEJ.clear();
            CombiMEJ.add(new LinkedList<>(L2));
            c = 1;
        }else if (dif == MEJPeso) {
             CombiMEJ.add(new LinkedList<>(L2));
        }
        c++;
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochilaMEJ(L1, L2, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    
}
