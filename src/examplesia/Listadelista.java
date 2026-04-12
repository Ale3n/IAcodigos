/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examplesia;


import java.util.LinkedList;

/**
 *
 * @author LENOVO
 */
public class Listadelista {
    public static int c = 0;
    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList();
        //L1.add(1);
        L1.add(4);
        L1.add(5);
        L1.add(6);
        LinkedList<Integer> L2 = new LinkedList();
        LinkedList<LinkedList<Integer>> L3 = new LinkedList();
        mochilaEXT(L1,L2,L3,10,0);
        for (int i = 0; i < L3.size(); i++) {
            System.out.println(L3.get(i));
        }
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
        if (sum>n) {
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
    //I. PROBLEMA DE LOS SUMANDOS DE UN ENTERO
    //4.     Encontrar todos los sumandos primos posibles en una Lista.
    public static void sumandosPRI(LinkedList<Integer> L1,
    LinkedList<LinkedList<Integer>> L2, int n, int i){
        int sum = suma(L1);
        if (sum>n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n){
            if(esPrimo(k)){
                L1.add(k);
                sumandosPRI(L1, L2, n, k);
                L1.removeLast();           
            }
            k++;
        }
    }
    
    public static boolean esPrimo(int n) {
        if (n <= 1) return false; // 0 y 1 no son primos

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // tiene un divisor
            }
        }

        return true; // no tiene divisores
    }
    
    //5.     Encontrar todos los sumandos entre a y b inclusive en una Lista.
    public static void sumandosRAN(LinkedList<Integer> L1, LinkedList<LinkedList<Integer>> L2, int n, int a, int b){
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = a;
        while (k <= b){
            L1.add(k);
            sumandosRAN(L1,L2, n, k, b);
            L1.removeLast();
            k++;
        }
    }
    
   //  6 Proponer adicionalmente otros problemas similares interesantes sobre Sumandos y/o sus variantes
    //  Encontrar combinaciones que sumen n usando exactamente m números.
    public static void sumandosCANTFI(LinkedList<Integer> L1,
    LinkedList<LinkedList<Integer>> L2, int n,int m, int i){
        int sum = suma(L1);
        if (sum>n) {
            return;
        }
        if (sum == n && L1.size()==m) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n){
            L1.add(k);
            sumandosCANTFI(L1, L2, n,m, k);
            L1.removeLast();
            k++;
        }
    }
     //II. EL PROBLEMA DE LA MOCHILA DE CAPACIDAD MAX
    // 2.     Encontrar todas las combinaciones de pesos diferentes que se pueden transportar en la mochila.
    public static void mochilaDIF(LinkedList<Integer> L1, LinkedList<Integer>
        L2, LinkedList<LinkedList<Integer>> L3, int max, int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        L3.add(new LinkedList<>(L2));
        c++;
        int k = i;
        while (k < L1.size()){
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                mochilaDIF(L1, L2, L3, max, k + 1);
                L2.removeLast();
            }
            k++;
        }
    }
    
    //4.     Encontrar las combinaciones de objetos de mayor cantidad de objetos que se pueden transportar.
    public static int Tamaño = 0;
    public static void mochilaEXT(LinkedList<Integer> L1,
    LinkedList<Integer> L2, LinkedList<LinkedList<Integer>> L3,
    int max, int i){

        int sum = suma(L2);

        if (sum > max) {
            return;
        }

        // lógica de máxima cantidad de elementos
        if (L2.size() > Tamaño) {
            Tamaño = L2.size();
            L3.clear();
            L3.add(new LinkedList<>(L2));
        } 
        else if (L2.size() == Tamaño && Tamaño > 0) {
            L3.add(new LinkedList<>(L2));
        }

        c++;

        // estructura igual al segundo código
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochilaEXT(L1, L2, L3, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    
     
    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> 
    L2, LinkedList<LinkedList<Integer>> L3, int max, int i){ 
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
    
    public static void mochilaRAN(LinkedList<Integer> L1, 
    LinkedList<Integer> L2, LinkedList<LinkedList<Integer>> L3 , int max, int 
    i,int a, int b){ 
            int sum = suma(L2); 
            if (sum > max) { 
                return; 
            } 
            L3.add(new LinkedList<>(L2)); 
            c++; 
            int k =i; 
            while (k < L1.size()){ 
                if (L1.get(k) >= a && L1.get(k) <= b) { 
                    L2.add(L1.get(k)); 
                    mochilaRAN(L1, L2, L3, max, k + 1, a, b); 
                    L2.removeLast(); 
                } 
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
}
