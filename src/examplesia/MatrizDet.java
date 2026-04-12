/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examplesia;
import java.util.LinkedList;


/**
 *
 * @author LENOVO
 */
public class MatrizDet {

    /**
     * @param args the command line arguments
     */
    public static int det(Matriz M){
        if (M.cantFil()==1) {/////////////////
            return M.elem(0,0);
        }
        int sum = 0, i = 0, j = 0;
        while (i < M.cantFil()) {
            sum = sum + signo(i,j) * M.elem(i,j) * det(menor(M,i,j));
            i++;
        }
        return sum;
    }
    public static int signo(int i, int j){
        if ((i + j) % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    public static Matriz menor(Matriz M, int i, int j){
        Matriz M1 = new Matriz(M);
        M1.eliminarFil(i);
        M1.eliminarCol(j);
        return M1;
    }
    
    
    //8. encontrarMenores(M1, L1) : Procedimiento que encuentra en la Lista de Matrices L1, todas las matrices menores derivados de la matriz M1
    public static void encontrarMenores(Matriz M1, LinkedList<Matriz> L1){
        for (int i = 0; i < M1.cantFil(); i++) {
            for (int j = 0; j < M1.cantCol(); j++) {
                Matriz menor = new Matriz(M1);
                menor.eliminarFil(i);
                menor.eliminarCol(j);
                L1.add(menor);
            }
        }
    }
    
    ////////////////////5 consultas
    ///1 Mostrar todas
    public static void mostrarLista(LinkedList<Matriz> L1){
        for (Matriz m : L1) {
            System.out.println(m);
        }
    }
    ///2 Contar matrices
    public static int cantidadMatrices(LinkedList<Matriz> L1){
        return L1.size();
    }
    //////3 Determinante mayor
    public static Matriz mayorDeterminante(LinkedList<Matriz> L1){
        Matriz mejor = L1.get(0);
        int max = det(mejor);

        for (Matriz m : L1) {
            int d = det(m);
            if (d > max) {
                max = d;
                mejor = m;
            }
        }
        return mejor;
    }
    /////4 Filtrar matrices con suma > X
    public static void sumaMayorA(LinkedList<Matriz> L1, int x){
        for (Matriz m : L1) {
            int suma = 0;
            for (int i = 0; i < m.cantFil(); i++) {
                for (int j = 0; j < m.cantCol(); j++) {
                    suma += m.elem(i,j);
                }
            }
            if (suma > x) {
                System.out.println(m);
            }
        }
    }
    ////5 Buscar matrices con ceros
    public static void matricesConCeros(LinkedList<Matriz> L1){
        for (Matriz m : L1) {
            boolean tieneCero = false;
            for (int i = 0; i < m.cantFil(); i++) {
                for (int j = 0; j < m.cantCol(); j++) {
                    if (m.elem(i,j) == 0) {
                        tieneCero = true;
                    }
                }
            }
            if (tieneCero) {
                System.out.println(m);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Matriz M1 = new Matriz(10,10,3,3);
        Matriz M2 = new Matriz(0,0,0,0);
        M1.setElem(0,0,9);
        M1.setElem(0,1,4);
        M1.setElem(0,2,1);
        /*M1.setElem(1,0,5);
        M1.setElem(1,1,2);
        M1.setElem(1,2,7);
        M1.setElem(2,0,3);
        M1.setElem(2,1,8);
        M1.setElem(2,2,6);*/
        System.out.println(det(M1));
        //M1.eliminarCol(1);
        M1.mostrar();
    }
 
    
    
    
    
    
}
