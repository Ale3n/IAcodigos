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
public class CombiYpermut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> L1 = new LinkedList();
        LinkedList<Integer> L2 = new LinkedList();
        L1.add(1);
         L1.add(2);
          L1.add(3);
        combiSR(L1,L2,2,0);
    }
    
    public static void combiSR(LinkedList<Integer> L1,LinkedList<Integer> L2, int r, int i){
        if (L2.size() == r) {
            System.out.println(L2);
            return;
        }
        int k = i;
        while (k<L1.size()) {
            L2.add(L1.get(k));
            combiSR(L1,L2,r,k+1);
            L2.removeLast();
            k = k+1;
        }
    }
    
    public static void combiCR(LinkedList<Integer> L1,LinkedList<Integer> L2, int r, int i){
        if (L1.size() == r) {
            System.out.println(L2);
            return;
        }
        int k = i;
        while (k<L1.size()) {
            L2.add(L1.get(k));
            combiCR(L1,L2,r,k);
            L2.removeLast();
            k = k+1;
        }
    }
    
    public static void permutCR(LinkedList<Integer> L1,LinkedList<Integer> L2, int r, int i){
        if (L1.size() == r) {
            System.out.println(L2);
            return;
        }
        int k = 0;
        while (k<L1.size()) {
            L2.add(L1.get(k));
            combiSR(L1,L2,r,k+1);
            L2.removeLast();
            k = k+1;
        }
    }
    public static void permutSR(LinkedList<Integer> L1,LinkedList<Integer> L2, int r, int i){
        if (L1.size() == r) {
            System.out.println(L2);
            return;
        }
        int k = 0;
        while (k<L1.size()) {
            if(!L2.contains(L1.get(k))){
                L2.add(L1.get(k));
                combiSR(L1,L2,r,k+1);
                L2.removeLast();
                k = k+1;
            }
        }
    }
}
