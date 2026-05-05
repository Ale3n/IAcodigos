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
 
        Matriz2 m = new Matriz2(10,10,3,3);
        m.setElem(0, 0, 2);
        m.setElem(0, 1, -2);
        m.setElem(0, 2, -100);
        
        m.setElem(0, 0, 2);
        m.setElem(0, 1, -2);
        m.setElem(0, 2, 100);
        
        m.setElem(0, 0, 2);
        m.setElem(0, 1, 2);
        m.setElem(0, 2, 100);
        
        mostrarPositivos(m);
        
        
    }
    public static void mostrarPositivos(Matriz2 m){
        for (int i = 0; i < m.cantFil(); i++) {
            for (int j = 0; j < m.cantCol(); j++) {
                for (int a = i; a < m.cantFil(); a++) {
                    for (int b = j; b < m.cantCol(); b++) {
                        Matriz2 m1 = m.subMatriz(i, j, a, b);
                        if (esPositivo(m1)) {
                         m1.mostrar();
                        }
                    }
                }
            }
        }
    }
    
    public static boolean esPositivo(Matriz2 m){
        for (int i = 0; i < m.cantFil(); i++) {
            for (int j = 0; j < m.cantCol(); j++) {
                if (m.elem(i, j)<=0) {
                    return false;
                }
            }
        }
        return true;
    }
  
    
}
