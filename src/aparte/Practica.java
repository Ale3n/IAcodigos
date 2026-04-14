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
    public static int suma(LinkedList<Integer> l1){
        int total = 0;
        for (int i = 0; i < l1.size(); i++) {
            total += l1.get(i);
        }
        return total;
    }
    public static int suma2(LinkedList<mochila> l1){
        int total = 0;
        for (int i = 0; i < l1.size(); i++) {
            total += l1.get(i).peso;
        }
        return total;
    }
    
    public static int mult(LinkedList<Integer> l1){
        int total = 0;
        for (int i = 0; i < l1.size(); i++) {
            total *= l1.get(i);
        }
        return total;
    }
    
    
    public static void sumandosDif(LinkedList<Integer> l1,int n,int i){
        int sum = suma(l1);
        if (sum>n) {
            return;
        }
        if (sum == n) {
            System.out.println(l1);
        }
        int k = i;
        while (k<=n) {
            if (!l1.contains(k)) {
                l1.add(k);
                sumandosDif(l1,n,k);
                l1.removeLast();
            }
            k++;
        }
    }
    public static void factoresRan(LinkedList<Integer> l1,int n,int a,int b){
        int sum = mult(l1);
        if (sum>n) {
            return;
        }
        if (sum == n) {
            System.out.println(l1);
        }
        int k = a;
        while (k<=b) {

                l1.add(k);
                sumandosDif(l1,k,b);
                l1.removeLast();
            
            k++;
        }
    }
    public static void resolMochila(LinkedList<mochila> o,LinkedList<mochila> m,int max, int i){
        int sum = suma2(m);
        if (sum>max) {
            return;
        }
        System.out.println(m);
        int k = i;
        while (k<o.size()) {

                m.add(o.get(k));
                resolMochila(o,m,max,k+1);
                m.removeLast();
            
            k++;
        }
    }
    public static void combiCR(LinkedList<String> l1,LinkedList<String> l2,int r, int i){
        if (l2.size()==r) {
            System.out.println(l2);
            return;
        }
        int k = i;
        while (k<l1.size()) {

                l2.add(l1.get(k));
                combiCR(l1,l2,r,k);
                l2.removeLast();
            
            k++;
        }
    }
    public static void permutSR(LinkedList<Integer> l1,LinkedList<Integer> l2,int r, int i){
        if (l2.size()==r) {
            System.out.println(l2);
            return;
        }
        int k = 0;
        while (k<l1.size()) {
            if(!l2.contains(l1.get(k))){
                l2.add(l1.get(k));
                permutSR(l1,l2,r,k+1);
                l2.removeLast();
            }
            k++;
        }
    }
    
    
    
}
