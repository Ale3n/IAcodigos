/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examplesia;

import static examplesia.Examplesia.sumandosRAN;
import java.util.LinkedList;

/**
 *
 * @author Tower
 */
public class Pruebas {
    public static void main(String[] args) {
        LinkedList<Integer>L1 = new LinkedList();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        LinkedList<Integer>L2 = new LinkedList();
        //mochilaEntre(L1,L2,10,1,3,6);
        mochilaDif(L1,L2,7,0);
    }
    public static int suma(LinkedList<Integer> L1){
        int Total = 0;
        for (int i = 0; i < L1.size(); i++) {
            Total += L1.get(i);
        }
        return Total;
    }
    
    
    public static void mochilaEntre(LinkedList<Integer>L1,LinkedList<Integer>L2, int max,int i, int a, int b){
        int sum = suma(L1);
        if (sum > max) {
            return;
        }
        System.out.println(L2);
        
        int k = i;
        while (k < L1.size()) {
            if (L1.get(k) >= a & L1.get(k)<=b) {
                L2.add(L1.get(k));
                mochilaEntre(L1,L2,max,k+1,a,b);
                L2.removeLast();
            }
            k++;
        }
    }
    
    public static void mochilaDif(LinkedList<Integer> L1,LinkedList<Integer> L2,int max,int i){
        int sum = suma(L2);
        if (sum > max) {
            return;
        }
        System.out.println(L2);
        int k = i;
        while (k < L1.size()) {
            if(!L2.contains(L1.get(k))){
                L2.add(L1.get(k));
                mochilaDif(L1,L2,max,k+1);
                L2.removeLast();
            }
            k++;
        }
        
        
        
    }
    
}
