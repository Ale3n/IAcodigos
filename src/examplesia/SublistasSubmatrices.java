/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examplesia;

import java.util.LinkedList;
import java.util.*;
/**
 *
 * @author LENOVO
 */
public class SublistasSubmatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Matriz M = new Matriz(10,10,3,3);
        M.setElem(0, 0, 1);
         M.setElem(0, 1, 1);
          M.setElem(0, 2, 1);
           M.setElem(1, 0, 2);
            M.setElem(1, 1, 2);
             M.setElem(1, 2, 2);
        mostrarSubMat(M);*/
        LinkedList L1 = new LinkedList<>();
        LinkedList<LinkedList<Integer>> L2 = new LinkedList<>();

        generarElem(L1, 6, -5, 5);

        System.out.println("Lista original:");
        System.out.println(L1);

        encontrarSubListas(L1, L2);

        System.out.println("\nTodas las sublistas:");
        for (LinkedList<Integer> sub : L2) {
        System.out.println(sub);
        }

        System.out.println("\nSublistas solo positivas:");
        subListasPos(L2);

        System.out.println("\nSublistas solo negativas:");
        subListasNeg(L2);

        System.out.println("\nSublistas con positivos y negativos:");
        subListasPosNeg(L2);

        System.out.println("\nSublistas ordenadas ascendente:");
        subListasAsc(L2);

        System.out.println("\nSublistas ordenadas descendente:");
        subListasDesc(L2);

        System.out.println("\nSublistas de tamaño 2:");
        subListas(L2, 2);

        System.out.println("\nSublista de menor suma:");
        subListaMenorSum(L2);

        System.out.println("\nSublista de mayor suma:");
        subListaMayorSum(L2);
    }
    
    /*public static void mostrarSublistas(LinkedList L1){
        for (int i = 0; i < L1.size(); i++) {
            for (int j = i+1; j <= L1.size(); j++) {
                System.out.println(L1.subList(i,j));
            }
        }
    }*/
    //2. encontrarSubListas(L1, L2): Función que encuentra todas las subListas de la Lista L1 en una Lista de Listas L2.
    /*public static LinkedList<LinkedList<Integer>> encontrarSubListas(
            LinkedList<Integer> L1,
            LinkedList<LinkedList<Integer>> L2){
        for (int i = 0; i < L1.size(); i++) {
            for (int j = i + 1; j <= L1.size(); j++) {
                LinkedList<Integer> sub = new LinkedList<>(L1.subList(i, j));
                L2.add(sub);
            }
        }
        return L2;
    }*/
    //3. generarElem(L1, n, a, b): Procedimiento que genera n elementos enteros
    //, entre a y b inclusive. Puede generar también valores negativos. Ejemplo: generarElem(L1, 10, -5, 5), 
    //genera 10 valores enteros entre -5 a 5 inclusive.
    
    //4. subListas(L1, k): Procedimiento que muestra las Listas de tamaño k, de la Lista de Listas L1.
    
    
    public static void mostrarSubMat(Matriz M1){
        for (int i = 0; i < M1.cantFil(); i++) {
            for (int j = 0; j < M1.cantCol(); j++) {
                for (int a = i; a < M1.cantFil(); a++) {
                    for (int b = j; b < M1.cantCol(); b++) {
                        Matriz M2 = M1.subMatriz(i,j,a,b);
                        System.out.println(M2);
                    }
                }
            }
        }
    }
    
        // 1. Mostrar todas las sublistas
    public static void mostrarSubListas(LinkedList L1) {
        for (int i = 0; i < L1.size(); i++) {
            for (int j = i + 1; j <= L1.size(); j++) {
            System.out.println(L1.subList(i, j));
            }
        }
    }

    // 2. Encontrar y guardar sublistas
    public static void encontrarSubListas(LinkedList L1, LinkedList L2) {
        for (int i = 0; i < L1.size(); i++) {
            for (int j = i + 1; j <= L1.size(); j++) {
            LinkedList sub = new LinkedList<>(L1.subList(i, j));
            L2.add(sub);
            }
        }
    }

    // 3. Generar elementos aleatorios
    public static void generarElem(LinkedList L1, int n, int a, int b) {
        Random r = new Random();
        for (int i = 0; i < n; i++) {
        int num = r.nextInt(b - a + 1) + a;
        L1.add(num);
        }
    }

    // 4. Sublistas de tamaño k
    public static void subListas(LinkedList<LinkedList<Integer>> L1, int k) {
        for (LinkedList sub : L1) {
            if (sub.size() == k) {
            System.out.println(sub);
            }
        }
    }

    // 5. Sublistas ordenadas ascendente
    public static void subListasAsc(LinkedList<LinkedList<Integer>>  L1) {
        for (LinkedList sub : L1) {
            LinkedList copia = new LinkedList<>(sub);
            Collections.sort(copia);
            System.out.println(copia);
        }
    }

    // 6. Sublistas ordenadas descendente
    public static void subListasDesc(LinkedList<LinkedList<Integer>>  L1) {
        for (LinkedList sub : L1) {
            LinkedList copia = new LinkedList<>(sub);
            Collections.sort(copia, Collections.reverseOrder());
            System.out.println(copia);
        }
    }

    // 7. Sublistas solo positivas
    public static void subListasPos(LinkedList<LinkedList<Integer>>  L1) {
        for (LinkedList<Integer> sub : L1) {
            boolean todosPos = true;
            for (int x : sub) {
                if (x <= 0) {
                todosPos = false;
                break;
                }
            }
            if (todosPos) {
                System.out.println(sub);
            }
        }
    }

    // 8. Sublistas solo negativas
    public static void subListasNeg(LinkedList<LinkedList<Integer>>  L1) {
        for (LinkedList<Integer> sub : L1) {
            boolean todosNeg = true;
            for (int x : sub) {
                if (x >= 0) {
                todosNeg = false;
                break;
                }
                }
                if (todosNeg) {
                System.out.println(sub);
            }
        }
    }

    // 9. Sublistas con positivos y negativos
    public static void subListasPosNeg(LinkedList<LinkedList<Integer>>  L1) {
        for (LinkedList<Integer> sub : L1) {
            boolean hayPos = false;
            boolean hayNeg = false;

            for (int x : sub) {
            if (x > 0) hayPos = true;
            if (x < 0) hayNeg = true;
            }

            if (hayPos && hayNeg) {
            System.out.println(sub);
            }
        }
    }

    // 10. Sublista de menor suma
    public static void subListaMenorSum(LinkedList<LinkedList<Integer>>  L1) {
        int min = Integer.MAX_VALUE;

        for (LinkedList<Integer> sub : L1) {
            int suma = 0;
            for (int x : sub) suma += x;
            if (suma < min) min = suma;
        }

        for (LinkedList<Integer> sub : L1) {
            int suma = 0;
            for (int x : sub) suma += x;
            if (suma == min) {
            System.out.println(sub);
            }
        }
    }

    // 11. Sublista de mayor suma
    public static void subListaMayorSum(LinkedList<LinkedList<Integer>>  L1) {
    int max = Integer.MIN_VALUE;

    for (LinkedList<Integer>  sub : L1) {
        int suma = 0;
        if (suma > max)        for (int x : sub) suma += x;
 max = suma;
    }

    for (LinkedList<Integer>  sub : L1) {
        int suma = 0;
        for (int x : sub) suma += x;
        if (suma == max) {
        System.out.println(sub);
        }
    }
    }
    
}
