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
class Mochila{
    int peso;
    String color;
    public Mochila(int peso, String color){
        this.peso = peso;
        this.color = color;
    }
    @Override
    public String toString(){
        return "(Peso: "+peso+", Color: "+color+")";
    }
}

public class EjersArealizar {

    /**
     * @param args the command line arguments
     */
     public static int c = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        // En una bodega hay cinco tipos diferentes de botellas.
        // ¿De cuántas formas se pueden elegir cuatro botellas?
        /* int r = 4;
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
        c = 0;*/
        
         LinkedList<Mochila> objetos = new LinkedList<>();

        // Agregar objetos
        objetos.add(new Mochila(2, "Rojo"));
        objetos.add(new Mochila(3, "Azul"));
        objetos.add(new Mochila(4, "Naranja"));
        objetos.add(new Mochila(5, "rosa"));

        LinkedList<Mochila> seleccion = new LinkedList<>();

        int pesoMaximo = 7;

        resolverMochila(objetos, seleccion, pesoMaximo, 0);
        
    }
    
    public static int suma(LinkedList<Integer> L1){
        int Total = 0;
        for (int i = 0; i < L1.size(); i++) {
            Total += L1.get(i);
        }
        return Total;
    }

    public static int mult(LinkedList<Integer> L1){
        int Total = 1;
        for (int i = 0; i < L1.size(); i++) {
            Total *= L1.get(i);
        }
        return Total;
    }
    public static int suma2(LinkedList<Mochila> m){
        int total = 0;
        for (int i = 0; i < m.size(); i++){
            total += m.get(i).peso;
        }
        return total;
    }
  
    
    /*public static void sumandosDIF(LinkedList<Integer> L1,
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
    }*/
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
    //Consulta 1: mocila con restricion de peso
    /*public static void resolverMochila(LinkedList<Objeto> objetos, LinkedList<Objeto> mochila, int i, int pesoActual, int max){
        if(pesoActual > max){
            return;
        }
        System.out.println(mochila);
        for(int j = i; j < objetos.size(); j++){
            mochila.add(objetos.get(j));
            resolverMochila(objetos, mochila, j+1, pesoActual + objetos.get(j).peso, max);
            mochila.removeLast();
        }
    }*/
    public static void resolverMochila(LinkedList<Mochila> objetos, LinkedList<Mochila> m, int max, int i){
        int pesoActual = suma2(m); // asumiendo que tienes un método suma para pesos
        if (pesoActual > max) {
            return;
        }
        System.out.println(m);
        int k = i;
        while (k < objetos.size()){
            m.add(objetos.get(k));
            resolverMochila(objetos, m, max, k + 1);
            m.removeLast();
            k++;
        }
    }
    
    
    // Combinaciones con repetición
    // En una bodega hay cinco tipos diferentes de botellas.
        // ¿De cuántas formas se pueden elegir cuatro botellas?
    public static void combiCR(LinkedList<String> L1, LinkedList<String> L2, int r, int i) {
        if (L2.size() == r) {
            System.out.println(L2);
            //c++;
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
    // Permutaciones sin repetición // ¿Cuántas permutaciones sin repetidos se pueden formar con los digitos 1 al 6?
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
    
    public static void mostrarMatricesPositivos(LinkedList<Matriz> l){
        for(Matriz m : l){
            if (sonPositivos(m)) {
                m.mostrar();
            }
        }
    }
    public static boolean sonPositivos(Matriz m) {
        for (int i = 0; i < m.cantFil(); i++) {
            for (int j = 0; j < m.cantCol(); j++) {
                if (m.elem(i, j) <= 0) { // estrictamente positivos
                    return false;
                }
            }
        }
        return true;
    }
   

    
    
    
}
