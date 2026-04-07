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
public class Ejers3 {

    /**
     * @param args the command line arguments
     */
    public static int c = 0;
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //I. PROBLEMA DE LOS SUMANDOS DE UN ENTERO
    //1. Encontrar los sumandos posibles en una Lista.
    public static int suma(LinkedList<Integer> L1) {
        int sum = 0;
        for (int i = 0; i < L1.size(); i++) {
            sum += L1.get(i);
        }
        return sum; 
    }

    public static void sumandos(LinkedList<Integer> L1,
                                LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            L1.add(k);
            sumandos(L1, L2, n, k);
            L1.removeLast();
            k++;
        }
    }
    //2. Encontrar todos los sumandos posibles diferentes en una Lista
    public static void sumandosDIF(LinkedList<Integer> L1,
                                LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            if (!L1.contains(k)) {
                L1.add(k);
                sumandosDIF(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    
    //3. Encontrar todos los sumandos posibles iguales en una Lista
    public static void sumandosIGUAL(LinkedList<Integer> L1,
                                 LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            if (L1.isEmpty() || k == L1.getLast()) {
                L1.add(k);
                sumandosIGUAL(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    //4. Encontrar todos los sumandos primos posibles en una Lista.
    public static void sumandosPRI(LinkedList<Integer> L1,
                               LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            if (primo(k)) {
                L1.add(k);
                sumandosPRI(L1, L2, n, k);
                L1.removeLast();    
            }
            k++;
        }
    }

    public static boolean primo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    //5. Encontrar todos los sumandos entre a y b inclusive en una Lista
    public static void sumandosRan(LinkedList<Integer> L1,
                               LinkedList<LinkedList<Integer>> L2, int n, int a, int b) {
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = a;
        while (k <= b) {
            L1.add(k);
            sumandosRan(L1, L2, n, k, b);
            L1.removeLast();
            k++;
        }
    }
    
    //6. Proponer adicionalmente otros problemas similares interesantes sobre Sumandos y/o sus variantes.
    // Encontrar combinaciones que sumen n usando exactamente m números.
    public static void sumandosCANTFI(LinkedList<Integer> L1,
                                  LinkedList<LinkedList<Integer>> L2, int n, int m, int i) {
        int sum = suma(L1);
        if (sum > n) {
            return;
        }
        if (sum == n && L1.size() == m) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            L1.add(k);
            sumandosCANTFI(L1, L2, n, m, k);
            L1.removeLast();
            k++;
        }
    }
    
    //Dado un entero N, encontrar todos los factores posibles, enteros positivos de N.
    //1. Encontrar los factores posibles en una Lista.
    public static int mult(LinkedList<Integer> L1) {
        int Total = 1;
        for (int i = 0; i < L1.size(); i++) {
            Total *= L1.get(i);
        }
        return Total;
    }

    public static void factores(LinkedList<Integer> L1,
                                LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            L1.add(k);
            factores(L1, L2, n, k);
            L1.removeLast();
            k++;
        }
    }
    
    //2. Encontrar todos los factores posibles diferentes en una Lista
    public static void factoresDIF(LinkedList<Integer> L1,
                               LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            if (!L1.contains(k)) {
                L1.add(k);
                factoresDIF(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    
    //3. Encontrar todos los factores posibles iguales en una Lista
    public static void factoresIGU(LinkedList<Integer> L1,
                               LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            if (L1.isEmpty() || L1.get(0) == k) {
                L1.add(k);
                factoresIGU(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    //4. Encontrar todos los factores primos posibles en una Lista.
    public static void factoresPRI(LinkedList<Integer> L1,
                               LinkedList<LinkedList<Integer>> L2, int n, int i) {
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = i;
        while (k <= n) {
            if (primo(k)) {
                L1.add(k);
                factoresPRI(L1, L2, n, k);
                L1.removeLast();
            }
            k++;
        }
    }
    //5. Encontrar todos los factores entre a y b inclusive en una Lista.
    public static void factoresRAN(LinkedList<Integer> L1,
                               LinkedList<LinkedList<Integer>> L2, int n, int a, int b) {
        int mul = mult(L1);
        if (mul > n) {
            return;
        }
        if (mul == n) {
            L2.add(new LinkedList<>(L1));
            return;
        }
        int k = a;
        while (k <= b) {
            L1.add(k);
            factoresRAN(L1, L2, n, k, b);
            L1.removeLast();
            k++;
        }
    }
    //6. Proponer adicionalmente otros problemas similares interesantes sobre Factores y/o sus variantes y/o Combinarlos.
    //II. EL PROBLEMA DE LA MOCHILA DE CAPACIDAD MAX
    //1. Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila.
    public static void mochila(LinkedList<Integer> L1,
                            LinkedList<Integer> L2, LinkedList<LinkedList<Integer>> L3, int max, int i) {
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        L3.add(new LinkedList<>(L2));
        c++;
        int k = i;
        while (k < L1.size()) {
            L2.add(L1.get(k));
            mochila(L1, L2, L3, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    //2. Encontrar todas las combinaciones de pesos diferentes que se pueden transportar en la mochila.
    public static void mochilaDIF(LinkedList<Integer> L1,
                              LinkedList<Integer> L2, LinkedList<LinkedList<Integer>> L3, int max, int i) {
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        L3.add(new LinkedList<>(L2));
        c++;
        int k = i;
        while (k < L1.size()) {
            if (!L2.contains(L1.get(k))) {
                L2.add(L1.get(k));
                mochilaDIF(L1, L2, L3, max, k + 1);
                L2.removeLast();
            }
            k++;
        }
    }
    
    //3. Encontrar todas las combinaciones de pesos entre a y b inclusive que se pueden transportar en la mochila.
    public static void mochilaRAN(LinkedList<Integer> L1,
                              LinkedList<Integer> L2,
                              LinkedList<LinkedList<Integer>> L3,
                              int max, int i, int a, int b) {
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        L3.add(new LinkedList<>(L2));
        c++;
        int k = i;
        while (k < L1.size()) {
            if (L1.get(k) >= a && L1.get(k) <= b) {
                L2.add(L1.get(k));
                mochilaRAN(L1, L2, L3, max, k + 1, a, b);
                L2.removeLast();
            }
            k++;
        }
    }
    //4. Encontrar las combinaciones de objetos de mayor cantidad de objetos que se pueden transportar
    public static int Tamaño = 0;

    public static void mochilaEXT(LinkedList<Integer> L1,
                                  LinkedList<Integer> L2,
                                  LinkedList<LinkedList<Integer>> L3,
                                  int max, int i) {
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        // lógica de máxima cantidad de elementos
        if (L2.size() > Tamaño) {
            Tamaño = L2.size();
            L3.clear();
            L3.add(new LinkedList<>(L2));
        } else if (L2.size() == Tamaño && Tamaño > 0) {
            L3.add(new LinkedList<>(L2));
        }
        c++;
        // estructura igual al segundo código
        int k = i;
        while (k < L1.size()) {
            L2.add(L1.get(k));
            mochilaEXT(L1, L2, L3, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    //5. Encontrar las mejores combinaciones que se pueden transportar en la mochila. (Las más próximas a la capacidad de la mochila)
    public static void proximos(LinkedList<LinkedList<Integer>> L1,
                            LinkedList<LinkedList<Integer>> L2, int max) {
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
