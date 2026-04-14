/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aparte;

import java.util.LinkedList;



/**
 *
 * @author Tower
 */

public class Practica {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        
    }
    public static int suma(LinkedList<Integer>l){
        int total = 0;
        for (int i = 0; i < l.size(); i++) {
            total += l.get(i);
        }
        return total;
    }
    public static int suma2(LinkedList<mochila>l){
        int total = 0;
        for (int i = 0; i < l.size(); i++) {
            total += l.get(i).peso;
        }
        return total;
    }
    
    public static int mult(LinkedList<Integer>l){
        int total = 1;
        for (int i = 0; i < l.size(); i++) {
            total *= l.get(i);
        }
        return total;
    }
    
    public static void sumamdosDif(LinkedList<Integer>l,int n,int i){
        int sum =suma(l);
        if (sum>n) {
            return;
        }
        if (sum == n) {
            System.out.println(l);
            return;
        }
        int k = i;
        while (k<=n) {
            if (!l.contains(k)) {
                l.add(k);
                sumamdosDif(l,n,k);
                l.removeLast();
            }
            k++;
        }
    }
    public static void factoresRan(LinkedList<Integer>l,int n,int a,int b){
        int sum =mult(l);
        if (sum>n) {
            return;
        }
        if (sum == n) {
            System.out.println(l);
            return;
        }
        int k = a;
        while (k<=b) {
                l.add(k);
                factoresRan(l,n,k,b);
                l.removeLast();

            k++;
        }
    }
    public static void revolverMochila(LinkedList<mochila>o,LinkedList<mochila>m,int max,int i){
        int sum =suma2(m);
        if (sum>max) {
            return;
        }
            System.out.println(m);

        int k = i;
        while (k<o.size()) {
                m.add(o.get(k));
                revolverMochila(o,m,max,k);
                m.removeLast();

            k++;
        }
    }
    public static void combiCr(LinkedList<mochila>l1,LinkedList<mochila>l2,int r,int i){
        if (l2.size() == r) {
            System.out.println(l2);
            return;
        }

        int k = i;
        while (k<l1.size()) {
                l2.add(l1.get(k));
                combiCr(l1,l2,r,k);
                l2.removeLast();

            k++;
        }
    }
    public static void permutSr(LinkedList<mochila>l1,LinkedList<mochila>l2,int r,int i){
        if (l2.size() == r) {
            System.out.println(l2);
            return;
        }

        int k = 0;
        while (k<l1.size()) {
            if(!l2.contains(l1.get(k))){
                l2.add(l1.get(k));
                combiCr(l1,l2,r,k+1);
                l2.removeLast();
            }
            k++;
        }
    }
    public static int signo(int i,int j){
        if ((i+j)%2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    public static Matriz2 menor(Matriz2 m,int i,int j){
        Matriz2 m1 = new Matriz2(m);
        m1.eliminarFil(i);
        m1.eliminarCol(j);
        return m1;
    }
    public static void mostrarPositivo(LinkedList<Matriz2>l){
        for (Matriz2 m :l) {
            if (esPositivo(m)) {
                m.mostrar();
            }
        }
    }
    public static boolean esPositivo(Matriz2 m){
        for (int i = 0; i < m.cantFil(); i++) {
            for (int j = 0; j < m.cantCol(); j++) {
                if (m.elem(i,j) <=0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int det(Matriz2 m){
        if (m.cantFil()==1) {
            return m.elem(0,0);
        }
        int sum = 0, i = 0, j = 0;
        while (i<m.cantFil()) {
            sum = sum + signo(i,j) * m.elem(i,j) * det(menor(m,i,j));
            i++;
        }
        return sum;
    }
    
    
}
